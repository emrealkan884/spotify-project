package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.business.dtos.album.requests.AddAlbumRequest;
import com.berkemre.spotifyproject.business.dtos.album.requests.UpdateAlbumRequest;
import com.berkemre.spotifyproject.business.dtos.album.responses.AddAlbumResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.GetAlbumResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.UpdateAlbumResponse;
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
  public List<GetAlbumResponse> getAll() {
    return albumService.getAll();
  }

  @GetMapping("/{id}")
  public GetAlbumResponse getById(@PathVariable UUID id) {
    return albumService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AddAlbumResponse add(@RequestBody AddAlbumRequest request) {
    return albumService.add(request);
  }

  @PutMapping("/{id}")
  public UpdateAlbumResponse update(
      @PathVariable UUID id, @RequestBody UpdateAlbumRequest request) {

    return albumService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    albumService.delete(id);
  }
}
