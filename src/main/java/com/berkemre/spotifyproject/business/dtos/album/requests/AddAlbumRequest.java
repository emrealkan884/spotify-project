package com.berkemre.spotifyproject.business.dtos.album.requests;

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
public class AddAlbumRequest {
  private String name;
  private LocalDate releaseDate;
  private UUID artistId;
}
