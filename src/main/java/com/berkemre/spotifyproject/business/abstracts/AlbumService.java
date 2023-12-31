package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.album.requests.AlbumAddRequest;
import com.berkemre.spotifyproject.business.dtos.album.requests.AlbumUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumAddResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumGetResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumUpdateResponse;
import com.berkemre.spotifyproject.entities.Album;
import java.util.List;
import java.util.UUID;

public interface AlbumService {
  AlbumAddResponse add(AlbumAddRequest request);

  AlbumUpdateResponse update(UUID id, AlbumUpdateRequest request);

  void delete(UUID id);

  AlbumGetResponse getById(UUID id);

  List<AlbumGetResponse> getAll();

  Album getForByIdNative(UUID id);
}
