package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.LikeService;
import com.berkemre.spotifyproject.business.dtos.like.requests.AddLikeRequest;
import com.berkemre.spotifyproject.business.dtos.like.requests.UpdateLikeRequest;
import com.berkemre.spotifyproject.business.dtos.like.responses.AddLikeResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.GetAllLikesResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.GetLikeResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.UpdateLikeResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikesController {
  private final LikeService likeService;

  @GetMapping
  public List<GetAllLikesResponse> getAll() {
    return likeService.getAll();
  }

  @GetMapping("/{id}")
  public GetLikeResponse getById(@PathVariable UUID id) {
    return likeService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AddLikeResponse add(@RequestBody @Valid AddLikeRequest request) {
    return likeService.add(request);
  }

  @PutMapping("/{id}")
  public UpdateLikeResponse update(
      @PathVariable UUID id, @RequestBody @Valid UpdateLikeRequest request) {

    return likeService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {

    likeService.delete(id);
  }
}
