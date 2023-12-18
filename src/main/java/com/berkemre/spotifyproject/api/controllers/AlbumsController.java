package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.business.dtos.album.requests.AlbumAddRequest;
import com.berkemre.spotifyproject.business.dtos.album.requests.AlbumUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumAddResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumGetResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumUpdateResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/albums")
@RestController
@RequiredArgsConstructor
public class AlbumsController {
  private final AlbumService albumService;

  @GetMapping
  public List<AlbumGetResponse> getAll() {
    return albumService.getAll();
  }

  @GetMapping("/{id}")
  public AlbumGetResponse getById(@PathVariable UUID id) {
    return albumService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AlbumAddResponse add(@RequestBody AlbumAddRequest request) {
    return albumService.add(request);
  }

  @PutMapping("/{id}")
  public AlbumUpdateResponse update(
      @PathVariable UUID id, @RequestBody AlbumUpdateRequest request) {

    return albumService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    albumService.delete(id);
  }
}
