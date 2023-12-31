package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.UserService;
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.User;
import com.berkemre.spotifyproject.repositories.UserRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public User add(User request) {
    return null;
  }

  @Override
  public User update(UUID id, User request) {
    return null;
  }

  @Override
  public void delete(UUID id) {}

  @Override
  public User getById(UUID id) {
    return null;
  }

  @Override
  public List<User> getAll() {
    return null;
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
