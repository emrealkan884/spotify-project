package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.entities.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
  User add(User request);

  User update(UUID id, User request);

  void delete(UUID id);

  User getById(UUID id);

  List<User> getAll();

  User getForByIdNative(UUID id);
}
