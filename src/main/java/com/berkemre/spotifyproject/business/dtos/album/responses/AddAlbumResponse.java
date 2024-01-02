package com.berkemre.spotifyproject.business.dtos.album.responses;

import com.berkemre.spotifyproject.entities.Music;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddAlbumResponse {
  private UUID id;
  private String name;
  private LocalDate releaseDate;
  private List<Music> musics;
  private String artistName;
}
