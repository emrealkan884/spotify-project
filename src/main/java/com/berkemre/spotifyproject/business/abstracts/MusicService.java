package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.music.requests.AddMusicRequest;
import com.berkemre.spotifyproject.business.dtos.music.requests.UpdateMusicRequest;
import com.berkemre.spotifyproject.business.dtos.music.responses.AddMusicResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.GetMusicResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.UpdateMusicResponse;
import com.berkemre.spotifyproject.entities.Music;
import java.util.List;
import java.util.UUID;

public interface MusicService {
  AddMusicResponse add(AddMusicRequest request);

  UpdateMusicResponse update(UUID id, UpdateMusicRequest request);

  void delete(UUID id);

  GetMusicResponse getById(UUID id);

  List<GetMusicResponse> getAll();

  List<Music> getForByIdsNative(List<UUID> ids);

  Music getForByIdNative(UUID id);
}
