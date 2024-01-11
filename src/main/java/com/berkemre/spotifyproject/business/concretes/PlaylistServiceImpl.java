package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.abstracts.PlaylistService;
import com.berkemre.spotifyproject.business.abstracts.UserService;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.AddPlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.UpdatePlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.AddPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetAllPlaylistsResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.UpdatePlaylistResponse;
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.Music;
import com.berkemre.spotifyproject.entities.Playlist;
import com.berkemre.spotifyproject.repositories.PlaylistRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {
  private final PlaylistRepository playlistRepository;
  private final UserService userService;
  private final MusicService musicService;

  @Override
  public AddPlaylistResponse add(AddPlaylistRequest request) {
    Playlist playlist =
        Playlist.builder()
            .createdDate(LocalDate.now())
            .user(userService.getForByIdNative(request.getUserId()))
            .name(request.getName())
            .build();
    playlist = playlistRepository.save(playlist);
    AddPlaylistResponse addPlaylistResponse =
        AddPlaylistResponse.builder().name(playlist.getName()).build();
    return addPlaylistResponse;
  }

  @Override
  public UpdatePlaylistResponse update(UUID id, UpdatePlaylistRequest request) {
    return null;
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
    GetPlaylistResponse getPlaylistResponse =
        GetPlaylistResponse.builder().name(playlist.getName()).musics(playlist.getMusics()).build();
    return getPlaylistResponse;
  }

  @Override
  public List<GetAllPlaylistsResponse> getAll() {
    List<Playlist> playlists = playlistRepository.findAll();
    List<GetAllPlaylistsResponse> response = new ArrayList<>();

    for (Playlist playlist : playlists) {
      response.add(new GetAllPlaylistsResponse(playlist.getId(), playlist.getName()));
    }
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
