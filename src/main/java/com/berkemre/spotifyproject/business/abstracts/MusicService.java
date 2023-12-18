package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.music.requests.MusicAddRequest;
import com.berkemre.spotifyproject.business.dtos.music.requests.MusicUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicAddResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicGetResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicUpdateResponse;
import com.berkemre.spotifyproject.entities.Music;
import java.util.List;
import java.util.UUID;

public interface MusicService {
  MusicAddResponse add(MusicAddRequest request);

  MusicUpdateResponse update(UUID id, MusicUpdateRequest request);

  void delete(UUID id);

  MusicGetResponse getById(UUID id);

  List<MusicGetResponse> getAll();

  List<Music> getForByIdsNative(List<UUID> ids);

  Music getForByIdNative(UUID id);
}
