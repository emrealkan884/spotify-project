package com.berkemre.spotifyproject.business.dtos.artist.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetArtistResponse {
  // private List<Album> albums;
  private String name;
}
