package com.berkemre.spotifyproject.business.dtos.like.responses;

import com.berkemre.spotifyproject.business.dtos.music.responses.MusicGetResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.UserGetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeGetResponse {
  private UserGetResponse username;
  private MusicGetResponse music;
}
