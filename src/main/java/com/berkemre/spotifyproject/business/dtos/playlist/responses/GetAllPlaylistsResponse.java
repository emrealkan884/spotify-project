package com.berkemre.spotifyproject.business.dtos.playlist.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllPlaylistsResponse {
  private String name;
  // private List<Music> musics;
}
