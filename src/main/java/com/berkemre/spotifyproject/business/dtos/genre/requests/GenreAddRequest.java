package com.berkemre.spotifyproject.business.dtos.genre.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GenreAddRequest {
  private String username;
  private String firstName;
  private String lastName;
  private String password;
}
