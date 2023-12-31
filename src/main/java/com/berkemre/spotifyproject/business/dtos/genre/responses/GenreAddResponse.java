package com.berkemre.spotifyproject.business.dtos.genre.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreAddResponse {
  private UUID id;
  private String name;
}
