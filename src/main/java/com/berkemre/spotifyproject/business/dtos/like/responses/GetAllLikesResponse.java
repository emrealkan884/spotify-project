package com.berkemre.spotifyproject.business.dtos.like.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetAllLikesResponse {
  private UUID id;
  private String userUsername;
  private String musicName;
}
