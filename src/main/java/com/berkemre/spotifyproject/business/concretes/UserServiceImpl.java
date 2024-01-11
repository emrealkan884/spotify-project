package com.berkemre.spotifyproject.business.concretes;

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
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Override
  public AddUserResponse add(AddUserRequest request) {
    User user = modelMapper.map(request, User.class);
    user.setId(UUID.randomUUID());
    User createdUser = userRepository.save(user);
    AddUserResponse response = modelMapper.map(createdUser, AddUserResponse.class);
    return response;
  }

  @Override
  public UpdateUserResponse update(UUID id, UpdateUserRequest request) {
    checkIfUserExists(id);
    User user = modelMapper.map(request, User.class);
    user.setId(id);
    User updatedUser = userRepository.save(user);
    UpdateUserResponse response = modelMapper.map(updatedUser, UpdateUserResponse.class);
    return response;
  }

  @Override
  public void delete(UUID id) {
    checkIfUserExists(id);
    userRepository.deleteById(id);
  }

  @Override
  public GetUserResponse getById(UUID id) {
    checkIfUserExists(id);
    User user = userRepository.findById(id).orElseThrow();
    GetUserResponse response = modelMapper.map(user, GetUserResponse.class);
    return response;
  }

  @Override
  public List<GetAllUsersResponse> getAll() {
    List<User> users = userRepository.findAll();
    List<GetAllUsersResponse> response =
        users.stream().map(user -> modelMapper.map(user, GetAllUsersResponse.class)).toList();
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
