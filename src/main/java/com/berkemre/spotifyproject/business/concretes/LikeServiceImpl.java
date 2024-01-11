package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.LikeService;
import com.berkemre.spotifyproject.business.dtos.like.requests.AddLikeRequest;
import com.berkemre.spotifyproject.business.dtos.like.requests.UpdateLikeRequest;
import com.berkemre.spotifyproject.business.dtos.like.responses.AddLikeResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.GetAllLikesResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.GetLikeResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.UpdateLikeResponse;
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.Like;
import com.berkemre.spotifyproject.repositories.LikeRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
  private final LikeRepository likeRepository;
  private final ModelMapper modelMapper;

  @Override
  public AddLikeResponse add(AddLikeRequest request) {
    Like like = modelMapper.map(request, Like.class);
    like.setId(UUID.randomUUID());
    Like createdLike = likeRepository.save(like);
    AddLikeResponse response = modelMapper.map(createdLike, AddLikeResponse.class);
    return response;
  }

  @Override
  public UpdateLikeResponse update(UUID id, UpdateLikeRequest request) {
    checkIfLikeExists(id);
    Like like = modelMapper.map(request, Like.class);
    like.setId(id);
    Like updatedLike = likeRepository.save(like);
    UpdateLikeResponse response = modelMapper.map(updatedLike, UpdateLikeResponse.class);
    return response;
  }

  @Override
  public void delete(UUID id) {
    checkIfLikeExists(id);
    likeRepository.deleteById(id);
  }

  @Override
  public GetLikeResponse getById(UUID id) {
    checkIfLikeExists(id);
    Like like = likeRepository.findById(id).orElseThrow();
    GetLikeResponse response = modelMapper.map(like, GetLikeResponse.class);
    return response;
  }

  @Override
  public List<GetAllLikesResponse> getAll() {
    List<Like> likes = likeRepository.findAll();
    List<GetAllLikesResponse> response =
        likes.stream().map(like -> modelMapper.map(like, GetAllLikesResponse.class)).toList();
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
