package com.berkemre.spotifyproject.business.dtos.artist.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddArtistResponse {
  private UUID id;
  private String name;
}
