package com.berkemre.spotifyproject.business.dtos.genre.responses;

import com.berkemre.spotifyproject.entities.Album;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreGetResponse {
  private List<Album> albums;
  private String username;
}
