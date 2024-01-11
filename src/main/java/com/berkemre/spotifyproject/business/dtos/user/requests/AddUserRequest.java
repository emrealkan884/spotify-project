package com.berkemre.spotifyproject.business.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserRequest {
  private String username;
  private String firstName;
  private String lastName;
  private String password;
}
