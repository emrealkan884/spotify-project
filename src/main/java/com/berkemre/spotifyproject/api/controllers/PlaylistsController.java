package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.PlaylistService;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.PlaylistAddRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.PlaylistUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistAddResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistGetResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistUpdateResponse;
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
  public List<PlaylistGetResponse> getAll() {
    return playlistService.getAll();
  }

  @GetMapping("/{id}")
  public PlaylistGetResponse getById(@PathVariable UUID id) {
    return playlistService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PlaylistAddResponse add(@RequestBody PlaylistAddRequest request) {
    return playlistService.add(request);
  }

  @PutMapping("/{id}")
  public PlaylistUpdateResponse update(
      @PathVariable UUID id, @RequestBody PlaylistUpdateRequest request) {
    return playlistService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    playlistService.delete(id);
  }
}
