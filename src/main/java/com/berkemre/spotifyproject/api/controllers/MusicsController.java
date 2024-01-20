package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.dtos.music.requests.AddMusicRequest;
import com.berkemre.spotifyproject.business.dtos.music.requests.UpdateMusicRequest;
import com.berkemre.spotifyproject.business.dtos.music.responses.AddMusicResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.GetAllMusicsResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.GetMusicResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.UpdateMusicResponse;
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
  public List<GetAllMusicsResponse> getAll() {
    return musicService.getAll();
  }

  @GetMapping("/{id}")
  public GetMusicResponse getById(@PathVariable UUID id) {
    return musicService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AddMusicResponse add(@RequestBody AddMusicRequest request) {
    return musicService.add(request);
  }

  @PutMapping("/{id}")
  public UpdateMusicResponse update(
      @PathVariable UUID id, @RequestBody UpdateMusicRequest request) {

    return musicService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {

    musicService.delete(id);
  }

  @GetMapping(("/countLikes"))
  public int countLikesById(@RequestParam UUID id) {
    return musicService.countLikesById(id);
  }
}
