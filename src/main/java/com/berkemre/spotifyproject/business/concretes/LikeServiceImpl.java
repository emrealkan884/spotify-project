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
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.Like;
import com.berkemre.spotifyproject.repositories.LikeRepository;
import java.util.ArrayList;
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
  public AddLikeResponse add(AddLikeRequest request) {
    Like like =
        Like.builder()
            .user(userService.getForByIdNative(request.getUserId()))
            .music(musicService.getForByIdNative(request.getMusicId()))
            .build();
    like = likeRepository.save(like);
    AddLikeResponse addLikeResponse =
        AddLikeResponse.builder()
            .musicName(like.getMusic().getName())
            .userName(like.getUser().getUsername())
            .date(like.getDate())
            .build();
    return addLikeResponse;
  }

  @Override
  public UpdateLikeResponse update(UUID id, UpdateLikeRequest request) {
    return null;
  }

  @Override
  public void delete(UUID id) {
    likeRepository.deleteById(id);
  }

  @Override
  public GetLikeResponse getById(UUID id) {
    return null;
  }

  @Override
  public List<GetAllLikesResponse> getAll() {
    List<Like> likes = likeRepository.findAll();
    List<GetAllLikesResponse> response = new ArrayList<>();

    for (Like like : likes) {
      response.add(
          new GetAllLikesResponse(
              like.getId(), like.getUser().getUsername(), like.getMusic().getName()));
    }
    return response;
  }

  private void checkIfLikeExists(UUID id) {
    if (!likeRepository.existsById(id))
      throw new BusinessException("Boyle bir begeni mevcut degil");
  }

  //  private void checkIfLikeIsNotExists(UUID userId, UUID musicId) {
  //    if (!likeRepository.existsByUserIdAndMusicId(userId, musicId))
  //      throw new BusinessException("Bu sarkiyi daha onceden begendigin icin tekrar
  // begenemezsin.");
  //  }
}
