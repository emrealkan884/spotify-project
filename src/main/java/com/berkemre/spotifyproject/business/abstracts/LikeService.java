package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.like.requests.AddLikeRequest;
import com.berkemre.spotifyproject.business.dtos.like.requests.UpdateLikeRequest;
import com.berkemre.spotifyproject.business.dtos.like.responses.AddLikeResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.GetLikeResponse;
import com.berkemre.spotifyproject.business.dtos.like.responses.UpdateLikeResponse;
import java.util.List;
import java.util.UUID;

public interface LikeService {
  AddLikeResponse add(AddLikeRequest request);

  UpdateLikeResponse update(UUID id, UpdateLikeRequest request);

  void delete(UUID id);

  GetLikeResponse getById(UUID id);

  List<GetLikeResponse> getAll();
}
