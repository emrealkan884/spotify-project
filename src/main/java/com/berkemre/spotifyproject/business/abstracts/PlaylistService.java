package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.playlist.requests.AddPlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.UpdatePlaylistRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.AddPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetAllPlaylistsResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.GetPlaylistResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.UpdatePlaylistResponse;
import java.util.List;
import java.util.UUID;

public interface PlaylistService {
  AddPlaylistResponse add(AddPlaylistRequest request);

  UpdatePlaylistResponse update(UUID id, UpdatePlaylistRequest request);

  void delete(UUID id);

  GetPlaylistResponse getById(UUID id);

  List<GetAllPlaylistsResponse> getAll();
}
