package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.like.requests.LikeAddRequest;
import com.berkemre.spotifyproject.business.dtos.like.requests.LikeUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeAddResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeGetResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.LikeUpdateResponse;
import java.util.List;
import java.util.UUID;

public interface LikeService {
  LikeAddResponse add(LikeAddRequest request);

  LikeUpdateResponse update(UUID id, LikeUpdateRequest request);

  void delete(UUID id);

  LikeGetResponse getById(UUID id);

  List<LikeGetResponse> getAll();
}
