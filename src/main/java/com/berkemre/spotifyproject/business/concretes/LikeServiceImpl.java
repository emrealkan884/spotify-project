package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.LikeService;
import com.berkemre.spotifyproject.business.dtos.like.requests.LikeAddRequest;
import com.berkemre.spotifyproject.business.dtos.like.requests.LikeUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeAddResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeGetResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeUpdateResponse;
import com.berkemre.spotifyproject.repositories.LikeRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
  private final LikeRepository likeRepository;

  @Override
  public LikeAddResponse add(LikeAddRequest request) {
    return null;
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
