package com.berkemre.spotifyproject.business.dtos.genre.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateGenreRequest {
  private String name;
}
