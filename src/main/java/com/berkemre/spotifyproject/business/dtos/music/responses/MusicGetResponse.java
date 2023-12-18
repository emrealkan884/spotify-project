package com.berkemre.spotifyproject.business.dtos.music.responses;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicGetResponse {

  private String name;

  private LocalDate createdDate;

  private String link;

  private int numberOfLikes;

  private String photo;

  private float duration;

  private String artistName;

  private String genreName;
}
