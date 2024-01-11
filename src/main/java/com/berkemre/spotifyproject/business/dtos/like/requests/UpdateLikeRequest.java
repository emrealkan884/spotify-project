package com.berkemre.spotifyproject.business.dtos.like.requests;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateLikeRequest {
  private UUID userId;
  private UUID musicId;
}
