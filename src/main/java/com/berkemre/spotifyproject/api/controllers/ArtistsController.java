package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.business.dtos.artist.requests.AddArtistRequest;
import com.berkemre.spotifyproject.business.dtos.artist.requests.UpdateArtistRequest;
import com.berkemre.spotifyproject.business.dtos.artist.responses.AddArtistResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.GetAllArtistsResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.GetArtistResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.UpdateArtistResponse;
import jakarta.validation.Valid;
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
  public List<GetAllArtistsResponse> getAll() {
    return artistService.getAll();
  }

  @GetMapping("/{id}")
  public GetArtistResponse getById(@PathVariable UUID id) {
    return artistService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AddArtistResponse add(@RequestBody @Valid AddArtistRequest request) {
    return artistService.add(request);
  }

  @PutMapping("/{id}")
  public UpdateArtistResponse update(
      @PathVariable UUID id, @RequestBody @Valid UpdateArtistRequest request) {

    return artistService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    artistService.delete(id);
  }
}
