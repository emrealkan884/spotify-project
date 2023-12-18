package com.berkemre.spotifyproject.business.dtos.like.responses;

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
public class LikeAddResponse {
  private LocalDate date;
  private UUID userId;
  private UUID musicId;
}
