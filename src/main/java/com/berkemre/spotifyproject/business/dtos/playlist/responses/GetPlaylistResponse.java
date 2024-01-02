package com.berkemre.spotifyproject.business.dtos.playlist.responses;

import com.berkemre.spotifyproject.entities.Music;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPlaylistResponse {
  private String name;
  private List<Music> musics;
}
