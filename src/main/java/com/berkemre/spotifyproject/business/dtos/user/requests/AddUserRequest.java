package com.berkemre.spotifyproject.business.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddUserRequest {
  private String username;
  private String firstName;
  private String lastName;
  private String password;
}
