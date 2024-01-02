package com.berkemre.spotifyproject.business.dtos.music.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UpdateMusicRequest {

  private String name;

  private String link;

  private String photo;

  private float duration;
}
