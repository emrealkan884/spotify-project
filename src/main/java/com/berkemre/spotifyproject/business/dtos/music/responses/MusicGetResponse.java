package com.berkemre.spotifyproject.business.dtos.music.responses;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicGetResponse {

  private UUID id;

  private String name;

  private LocalDate createdDate;

  private String link;

  private int numberOfLikes;

  private String photo;

  private float duration;
}
