package com.berkemre.spotifyproject.business.dtos.album.requests;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddAlbumRequest {
  private String name;
  private UUID artistId;
}
