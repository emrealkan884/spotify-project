package com.berkemre.spotifyproject.business.dtos.album.responses;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateAlbumResponse {
  private UUID id;
  private String name;
  private LocalDate releaseDate;
}
