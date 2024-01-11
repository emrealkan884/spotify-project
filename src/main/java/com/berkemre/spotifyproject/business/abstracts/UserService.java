package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.user.requests.AddUserRequest;
import com.berkemre.spotifyproject.business.dtos.user.requests.UpdateUserRequest;
import com.berkemre.spotifyproject.business.dtos.user.responses.AddUserResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.GetAllUsersResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.GetUserResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.UpdateUserResponse;
import com.berkemre.spotifyproject.entities.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
  AddUserResponse add(AddUserRequest request);

  UpdateUserResponse update(UUID id, UpdateUserRequest request);

  void delete(UUID id);

  GetUserResponse getById(UUID id);

  List<GetAllUsersResponse> getAll();

  User getForByIdNative(UUID id);

}
