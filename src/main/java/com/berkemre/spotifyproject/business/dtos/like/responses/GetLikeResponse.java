package com.berkemre.spotifyproject.business.dtos.like.responses;

import com.berkemre.spotifyproject.business.dtos.music.responses.GetMusicResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLikeResponse {
  private GetUserResponse username;
  private GetMusicResponse music;
}
