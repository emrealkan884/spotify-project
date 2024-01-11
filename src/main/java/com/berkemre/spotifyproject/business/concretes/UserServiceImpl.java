package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.abstracts.UserService;
import com.berkemre.spotifyproject.business.dtos.user.requests.AddUserRequest;
import com.berkemre.spotifyproject.business.dtos.user.requests.UpdateUserRequest;
import com.berkemre.spotifyproject.business.dtos.user.responses.AddUserResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.GetAllUsersResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.GetUserResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.UpdateUserResponse;
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.User;
import com.berkemre.spotifyproject.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final MusicService musicService;

  @Override
  public AddUserResponse add(AddUserRequest request) {
    return null;
  }

  @Override
  public UpdateUserResponse update(UUID id, UpdateUserRequest request) {
    checkIfUserExists(id);
    return null;
  }

  @Override
  public void delete(UUID id) {
    checkIfUserExists(id);
    userRepository.deleteById(id);
  }

  @Override
  public GetUserResponse getById(UUID id) {
    checkIfUserExists(id);
    return null;
  }

  @Override
  public List<GetAllUsersResponse> getAll() {
    List<User> users = userRepository.findAll();
    List<GetAllUsersResponse> response = new ArrayList<>();

    for (User user : users) {
      response.add(
          new GetAllUsersResponse(
              user.getId(), user.getUsername(), user.getFirstName(), user.getLastName()));
    }
    return response;
  }

  @Override
  public User getForByIdNative(UUID id) {
    checkIfUserExists(id);
    return userRepository.getForByIdNative(id);
  }

  private void checkIfUserExists(UUID id) {
    if (!userRepository.existsById(id))
      throw new BusinessException("Boyle bir kullanici mevcut degil");
  }
}
