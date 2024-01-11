package com.berkemre.spotifyproject.business.dtos.like.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLikesResponse {
  // private GetUserResponse username;
  // private GetMusicResponse music;
  private UUID id;
  private String userName;
  private String musicName;
}
