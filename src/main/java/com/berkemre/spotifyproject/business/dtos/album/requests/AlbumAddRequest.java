package com.berkemre.spotifyproject.business.dtos.album.requests;

import com.berkemre.spotifyproject.entities.Artist;
import com.berkemre.spotifyproject.entities.Music;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AlbumAddRequest {
  private String name;
  private LocalDate releaseDate;
  private long numberOfLikes;
  private Artist artist;
  private List<Music> musics;
}
