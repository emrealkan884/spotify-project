package com.berkemre.spotifyproject.business.dtos.album.requests;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlbumAddRequest {
  private String name;
  private LocalDate releaseDate;
  private UUID artistId;
  private List<UUID> musicsId;
}
