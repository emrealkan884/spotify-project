package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.GenreService;
import com.berkemre.spotifyproject.business.dtos.genre.requests.GenreAddRequest;
import com.berkemre.spotifyproject.business.dtos.genre.requests.GenreUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreAddResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreGetResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreUpdateResponse;
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
  public List<GenreGetResponse> getAll() {
    return genreService.getAll();
  }

  @GetMapping("/{id}")
  public GenreGetResponse getById(@PathVariable UUID id) {
    return genreService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GenreAddResponse add(@RequestBody GenreAddRequest request) {
    return genreService.add(request);
  }

  @PutMapping("/{id}")
  public GenreUpdateResponse update(
      @PathVariable UUID id, @RequestBody GenreUpdateRequest request) {

    return genreService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {

    genreService.delete(id);
  }
}
