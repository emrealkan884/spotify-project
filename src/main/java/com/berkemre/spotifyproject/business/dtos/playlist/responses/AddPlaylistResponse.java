package com.berkemre.spotifyproject.business.dtos.playlist.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddPlaylistResponse {
  private UUID id;
  private String name;
}
