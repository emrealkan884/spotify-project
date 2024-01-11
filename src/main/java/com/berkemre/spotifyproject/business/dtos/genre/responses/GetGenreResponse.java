package com.berkemre.spotifyproject.business.dtos.genre.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetGenreResponse {
  private UUID id;
  private String name;
}
