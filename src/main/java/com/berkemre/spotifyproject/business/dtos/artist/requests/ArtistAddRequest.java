package com.berkemre.spotifyproject.business.dtos.artist.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArtistAddRequest {
  private String username;
  private String firstName;
  private String lastName;
  private String password;
}
