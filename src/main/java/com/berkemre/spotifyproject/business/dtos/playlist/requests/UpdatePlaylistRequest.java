package com.berkemre.spotifyproject.business.dtos.playlist.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdatePlaylistRequest {
  private String name;
}
