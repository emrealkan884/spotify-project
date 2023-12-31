package com.berkemre.spotifyproject.business.dtos.genre.responses;

import com.berkemre.spotifyproject.entities.Music;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreGetResponse {
  private UUID id;
  private String name;
  private List<Music> musics;
}
