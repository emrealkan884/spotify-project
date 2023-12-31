package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.LikeService;
import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.abstracts.UserService;
import com.berkemre.spotifyproject.business.dtos.like.requests.AddLikeRequest;
import com.berkemre.spotifyproject.business.dtos.like.requests.UpdateLikeRequest;
import com.berkemre.spotifyproject.business.dtos.like.responses.AddLikeResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.GetAllLikesResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.GetLikeResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.UpdateLikeResponse;
import com.berkemre.spotifyproject.entities.Like;
import com.berkemre.spotifyproject.repositories.LikeRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
  private final LikeRepository likeRepository;
  private final UserService userService;
  private MusicService musicService;

  @Override
  public AddLikeResponse add(AddLikeRequest request) {
    Like like =
        Like.builder()
            .user(userService.getForByIdNative(request.getUserId()))
            .music(musicService.getForByIdNative(request.getMusicId()))
            .build();
    like = likeRepository.save(like);
    AddLikeResponse addLikeResponse =
        AddLikeResponse.builder()
            .musicId(like.getMusic().getId())
            .userId(like.getUser().getId())
            .date(like.getDate())
            .build();
    return addLikeResponse;
  }

  @Override
  public UpdateLikeResponse update(UUID id, UpdateLikeRequest request) {
    return null;
  }

  @Override
  public void delete(UUID id) {}

  @Override
  public GetLikeResponse getById(UUID id) {
    return null;
  }

  @Override
  public List<GetAllLikesResponse> getAll() {
    return null;
  }
}
