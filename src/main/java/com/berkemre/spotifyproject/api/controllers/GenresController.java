package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.GenreService;
import com.berkemre.spotifyproject.business.dtos.genre.requests.AddGenreRequest;
import com.berkemre.spotifyproject.business.dtos.genre.requests.UpdateGenreRequest;
import com.berkemre.spotifyproject.business.dtos.genre.responses.AddGenreResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GetAllGenresResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GetGenreResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.UpdateGenreResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/genres")
@RestController
@RequiredArgsConstructor
public class GenresController {
  private final GenreService genreService;

  @GetMapping
  public List<GetAllGenresResponse> getAll() {
    return genreService.getAll();
  }

  @GetMapping("/{id}")
  public GetGenreResponse getById(@PathVariable UUID id) {
    return genreService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AddGenreResponse add(@RequestBody @Valid AddGenreRequest request) {
    return genreService.add(request);
  }

  @PutMapping("/{id}")
  public UpdateGenreResponse update(
      @PathVariable UUID id, @RequestBody @Valid UpdateGenreRequest request) {

    return genreService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {
    genreService.delete(id);
  }
}
