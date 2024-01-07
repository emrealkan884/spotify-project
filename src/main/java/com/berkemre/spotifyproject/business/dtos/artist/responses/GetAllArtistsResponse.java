package com.berkemre.spotifyproject.business.dtos.artist.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllArtistsResponse {
  // private List<GetAllAlbumsResponse> albums;
  private String name;
}
