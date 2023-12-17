package com.berkemre.spotifyproject.business.dtos.music.requests;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MusicAddRequest {

  private String name;

  private String link;

  private String photo;

  private float duration;

  private UUID artistId;
}
