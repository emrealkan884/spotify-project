package com.berkemre.spotifyproject.business.dtos.artist.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateArtistRequest {
  private String name;
}
