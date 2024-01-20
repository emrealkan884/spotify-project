package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.abstracts.PlaylistService;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.AddPlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.UpdatePlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.AddPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetAllPlaylistsResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.UpdatePlaylistResponse;
import com.berkemre.spotifyproject.core.exceptions.types.BusinessException;
import com.berkemre.spotifyproject.entities.Music;
import com.berkemre.spotifyproject.entities.Playlist;
import com.berkemre.spotifyproject.repositories.PlaylistRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {
  private final PlaylistRepository playlistRepository;
  private final MusicService musicService;
  private final ModelMapper modelMapper;

  @Override
  public AddPlaylistResponse add(AddPlaylistRequest request) {
    Playlist playlist = modelMapper.map(request, Playlist.class);
    playlist.setCreatedDate(LocalDateTime.now());
    Playlist createdPlaylist = playlistRepository.save(playlist);
    AddPlaylistResponse response = modelMapper.map(createdPlaylist, AddPlaylistResponse.class);
    return response;
  }

  @Override
  public UpdatePlaylistResponse update(UUID id, UpdatePlaylistRequest request) {
    Playlist playlist = modelMapper.map(request, Playlist.class);
    playlist.setId(id);
    playlist.setUpdatedDate(LocalDateTime.now());
    Playlist updatedPlaylist = playlistRepository.save(playlist);
    UpdatePlaylistResponse response =
        modelMapper.map(updatedPlaylist, UpdatePlaylistResponse.class);
    return response;
  }

  @Override
  public void delete(UUID id) {
    checkIfPlaylistExists(id);
    playlistRepository.deleteById(id);
  }

  @Override
  public GetPlaylistResponse getById(UUID id) {
    checkIfPlaylistExists(id);
    Playlist playlist = playlistRepository.findById(id).orElseThrow();
    GetPlaylistResponse response = modelMapper.map(playlist, GetPlaylistResponse.class);
    return response;
  }

  @Override
  public List<GetAllPlaylistsResponse> getAll() {
    List<Playlist> playlists = playlistRepository.findAll();
    List<GetAllPlaylistsResponse> response =
        playlists.stream()
            .map(playlist -> modelMapper.map(playlist, GetAllPlaylistsResponse.class))
            .toList();
    return response;
  }

  @Override
  public void addMusicsInPlaylist(UUID playlistId, UUID musicId) {
    checkIfPlaylistExists(playlistId);
    Playlist playlist = playlistRepository.getReferenceById(playlistId);
    List<Music> musics = playlist.getMusics();
    musics.add(musicService.getForByIdNative(musicId));
    playlist.setMusics(musics);
    playlistRepository.save(playlist);
  }

  private void checkIfPlaylistExists(UUID id) {
    if (!playlistRepository.existsById(id))
      throw new BusinessException("Boyle bir playlist mevcut degil");
  }
}
