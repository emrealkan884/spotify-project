package com.berkemre.spotifyproject.business.dtos.album.responses;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AlbumUpdateResponse {
  private UUID id;
  private String name;
  private LocalDate releaseDate;
}
