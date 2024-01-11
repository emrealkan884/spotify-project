package com.berkemre.spotifyproject.business.dtos.like.responses;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateLikeResponse {
  private LocalDate date;
  private String userUsername;
  private String musicName;
}
