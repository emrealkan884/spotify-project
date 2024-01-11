package com.berkemre.spotifyproject.business.dtos.like.responses;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLikeResponse {
  private LocalDate date;
  private String userName;
  private String musicName;
}
