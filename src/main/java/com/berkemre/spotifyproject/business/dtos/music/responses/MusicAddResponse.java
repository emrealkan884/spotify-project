package com.berkemre.spotifyproject.business.dtos.music.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MusicAddResponse {

  private UUID id;

  private String name;

  private String link;

  private String artistUserName;
}
