package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.dtos.music.requests.MusicAddRequest;
import com.berkemre.spotifyproject.business.dtos.music.requests.MusicUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicAddResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicGetResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicUpdateResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/musics")
@RestController
@RequiredArgsConstructor
public class MusicsController {
  private final MusicService musicService;

  @GetMapping
  public List<MusicGetResponse> getAll() {
    return musicService.getAll();
  }

  @GetMapping("/{id}")
  public MusicGetResponse getById(@PathVariable UUID id) {
    return musicService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MusicAddResponse add(@RequestBody MusicAddRequest request) {
    return musicService.add(request);
  }

  @PutMapping("/{id}")
  public MusicUpdateResponse update(
      @PathVariable UUID id, @RequestBody MusicUpdateRequest request) {

    return musicService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {

    musicService.delete(id);
  }
}
