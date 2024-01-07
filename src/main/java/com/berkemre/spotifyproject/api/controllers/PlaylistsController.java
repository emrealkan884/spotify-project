package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.PlaylistService;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.AddPlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.UpdatePlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.AddPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetAllPlaylistsResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.UpdatePlaylistResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/playlists")
@RestController
@RequiredArgsConstructor
public class PlaylistsController {
  private final PlaylistService playlistService;

  @GetMapping
  public List<GetAllPlaylistsResponse> getAll() {
    return playlistService.getAll();
  }

  @GetMapping("/{id}")
  public GetPlaylistResponse getById(@PathVariable UUID id) {
    return playlistService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AddPlaylistResponse add(@RequestBody AddPlaylistRequest request) {
    return playlistService.add(request);
  }

  @PutMapping("/{id}")
  public UpdatePlaylistResponse update(
      @PathVariable UUID id, @RequestBody UpdatePlaylistRequest request) {
    return playlistService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    playlistService.delete(id);
  }
}
