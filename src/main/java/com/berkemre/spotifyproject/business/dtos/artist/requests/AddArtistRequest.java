package com.berkemre.spotifyproject.business.dtos.artist.requests;

import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddArtistRequest {
  @Size(min = 3, max = 25, message = "Artist adi minimum 3 maximum 20 haneli olmalidir.")
  private String name;

  private UUID genreId;
}
