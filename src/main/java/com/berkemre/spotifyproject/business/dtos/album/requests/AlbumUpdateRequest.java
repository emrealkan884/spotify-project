package com.berkemre.spotifyproject.business.dtos.album.requests;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AlbumUpdateRequest {
  private String name;
  private LocalDate releaseDate;
}
