package com.berkemre.spotifyproject.business.dtos.playlist.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaylistAddResponse {
  private UUID id;
  private String name;
}