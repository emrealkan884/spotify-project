package com.berkemre.spotifyproject.business.dtos.artist.requests;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArtistAddRequest {
  private String name;
  private UUID genreId;
}
