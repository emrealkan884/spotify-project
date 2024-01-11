package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.UserService;
import com.berkemre.spotifyproject.business.dtos.user.requests.AddUserRequest;
import com.berkemre.spotifyproject.business.dtos.user.requests.UpdateUserRequest;
import com.berkemre.spotifyproject.business.dtos.user.responses.AddUserResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.GetAllUsersResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.GetUserResponse;
import com.berkemre.spotifyproject.business.dtos.user.responses.UpdateUserResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {
  private final UserService userService;

  @GetMapping
  public List<GetAllUsersResponse> getAll() {
    return userService.getAll();
  }

  @GetMapping("/{id}")
  public GetUserResponse getById(@PathVariable UUID id) {
    return userService.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AddUserResponse add(@RequestBody @Valid AddUserRequest request) {
    return userService.add(request);
  }

  @PutMapping("/{id}")
  public UpdateUserResponse update(
      @PathVariable UUID id, @RequestBody @Valid UpdateUserRequest request) {

    return userService.update(id, request);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID id) {

    userService.delete(id);
  }

}
