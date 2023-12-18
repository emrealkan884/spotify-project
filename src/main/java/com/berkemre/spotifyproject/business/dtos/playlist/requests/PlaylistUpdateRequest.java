package com.berkemre.spotifyproject.business.dtos.playlist.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaylistUpdateRequest {
  private String name;
}
