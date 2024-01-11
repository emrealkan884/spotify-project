package com.berkemre.spotifyproject.business.dtos.album.requests;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateAlbumRequest {
  private String name;
  private LocalDate releaseDate;
}
