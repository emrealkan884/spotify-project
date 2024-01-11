package com.berkemre.spotifyproject.business.dtos.user.responses;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateUserResponse {
  private UUID id;
  private String username;
  private String firstName;
  private String lastName;
}
