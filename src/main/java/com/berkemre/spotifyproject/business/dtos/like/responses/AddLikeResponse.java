package com.berkemre.spotifyproject.business.dtos.like.responses;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddLikeResponse {
  private UUID id;
  private LocalDate date;
  private String userUsername; // Like'in icindeki user'in userName i.
  private String musicName;
}
