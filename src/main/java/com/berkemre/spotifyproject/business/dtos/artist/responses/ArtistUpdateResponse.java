package com.berkemre.spotifyproject.business.dtos.artist.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistUpdateResponse {
  private UUID id;
  private String name;
}
