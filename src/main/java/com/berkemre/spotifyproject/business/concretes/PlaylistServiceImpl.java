package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.PlaylistService;
import com.berkemre.spotifyproject.business.abstracts.UserService;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.AddPlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.UpdatePlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.AddPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.UpdatePlaylistResponse;
import com.berkemre.spotifyproject.entities.Playlist;
import com.berkemre.spotifyproject.repositories.PlaylistRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {
  private final PlaylistRepository playlistRepository;
  private final UserService userService;

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
  public void delete(UUID id) {}

  @Override
  public GetPlaylistResponse getById(UUID id) {
    return null;
  }

  @Override
  public List<GetPlaylistResponse> getAll() {
    return null;
  }
}
