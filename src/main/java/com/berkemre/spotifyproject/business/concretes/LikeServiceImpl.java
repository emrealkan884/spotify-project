package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.LikeService;
import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.abstracts.UserService;
import com.berkemre.spotifyproject.business.dtos.like.requests.LikeAddRequest;
import com.berkemre.spotifyproject.business.dtos.like.requests.LikeUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeAddResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeGetResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeUpdateResponse;
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
  private final MusicService musicService;

  @Override
  public LikeAddResponse add(LikeAddRequest request) {
    Like like =
        Like.builder()
            .user(userService.getForByIdNative(request.getUserId()))
            .music(musicService.getForByIdNative(request.getMusicId()))
            .build();
    like = likeRepository.save(like);
    LikeAddResponse likeAddResponse =
        LikeAddResponse.builder()
            .musicId(like.getMusic().getId())
            .userId(like.getUser().getId())
            .date(like.getDate())
            .build();
    return likeAddResponse;
  }

  @Override
  public LikeUpdateResponse update(UUID id, LikeUpdateRequest request) {
    return null;
  }

  @Override
  public void delete(UUID id) {}

  @Override
  public LikeGetResponse getById(UUID id) {
    return null;
  }

  @Override
  public List<LikeGetResponse> getAll() {
    return null;
  }
}
