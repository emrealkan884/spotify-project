package com.berkemre.spotifyproject.business.dtos.album.responses;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlbumGetResponse {
  private UUID id;
  private String name;
  private LocalDate releaseDate;
}
