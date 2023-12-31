package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.dtos.music.requests.AddMusicRequest;
import com.berkemre.spotifyproject.business.dtos.music.requests.UpdateMusicRequest;
import com.berkemre.spotifyproject.business.dtos.music.responses.AddMusicResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.GetAllMusicsResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.GetMusicResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.UpdateMusicResponse;
import com.berkemre.spotifyproject.entities.Music;
import com.berkemre.spotifyproject.repositories.MusicRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
  private final MusicRepository musicRepository;
  private final AlbumService albumService;

  @Override
  public AddMusicResponse add(AddMusicRequest request) {
    Music music =
        Music.builder()
            .name(request.getName())
            .link(request.getLink())
            .album(albumService.getForByIdNative(request.getAlbumId()))
            .duration(request.getDuration())
            .photo(request.getPhoto())
            .genre(albumService.getForByIdNative(request.getAlbumId()).getArtist().getGenre())
            .build();
    music = musicRepository.save(music);
    AddMusicResponse addMusicResponse =
        AddMusicResponse.builder()
            .id(music.getId())
            .name(music.getName())
            .artistName(music.getAlbum().getArtist().getName())
            .genreName(music.getGenre().getName())
            .link(music.getLink())
            .build();
    return addMusicResponse;
  }

  @Override
  public UpdateMusicResponse update(UUID id, UpdateMusicRequest request) {
    return null;
  }

  @Override
  public void delete(UUID id) {}

  @Override
  public GetMusicResponse getById(UUID id) {
    return null;
  }

  @Override
  public List<GetAllMusicsResponse> getAll() {
    return null;
  }

  @Override
  public List<Music> getForByIdsNative(List<UUID> ids) {
    return musicRepository.getForByIdsNative(ids);
  }

  @Override
  public Music getForByIdNative(UUID id) {
    return musicRepository.getForByIdNative(id);
  }
}
