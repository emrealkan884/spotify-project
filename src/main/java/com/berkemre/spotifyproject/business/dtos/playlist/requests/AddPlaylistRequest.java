package com.berkemre.spotifyproject.business.dtos.playlist.requests;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddPlaylistRequest {
  private String name;
  private UUID userId;
}
