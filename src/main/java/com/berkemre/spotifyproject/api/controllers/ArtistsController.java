package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.business.dtos.artist.requests.ArtistAddRequest;
import com.berkemre.spotifyproject.business.dtos.artist.requests.ArtistUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistAddResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistGetResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistUpdateResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/artists")
@RestController
@RequiredArgsConstructor
public class ArtistsController {
  private final ArtistService artistService;

  @GetMapping
  public List<ArtistGetResponse> getAll() {
    return artistService.getAll();
  }

  @GetMapping("/{id}")
  public ArtistGetResponse getById(@PathVariable UUID id) {
    return artistService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ArtistAddResponse add(@RequestBody ArtistAddRequest request) {
    return artistService.add(request);
  }

  @PutMapping("/{id}")
  public ArtistUpdateResponse update(
      @PathVariable UUID id, @RequestBody ArtistUpdateRequest request) {

    return artistService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    artistService.delete(id);
  }
}
