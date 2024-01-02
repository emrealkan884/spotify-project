package com.berkemre.spotifyproject.business.dtos.album.requests;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateAlbumRequest {
  private String name;
  private LocalDate releaseDate;
}
