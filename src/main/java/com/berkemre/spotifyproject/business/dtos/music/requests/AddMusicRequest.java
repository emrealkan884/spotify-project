package com.berkemre.spotifyproject.business.dtos.music.requests;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddMusicRequest {

  private String name;

  private String link;

  private String photo;

  private float duration;

  private UUID albumId; // Requestlerede birden fazla id olursa, mapper kullandigimizda cakisabilir.

  private UUID genreId;
}
