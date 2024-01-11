package com.berkemre.spotifyproject.business.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserResponse {
  private String username;
  private String firstName;
  private String lastName;
}
