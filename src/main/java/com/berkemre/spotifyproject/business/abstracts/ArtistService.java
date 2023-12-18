package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.artist.requests.ArtistAddRequest;
import com.berkemre.spotifyproject.business.dtos.artist.requests.ArtistUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistAddResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistGetResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistUpdateResponse;
import com.berkemre.spotifyproject.entities.Artist;
import java.util.List;
import java.util.UUID;

public interface ArtistService {
  ArtistAddResponse add(ArtistAddRequest request);

  ArtistUpdateResponse update(UUID id, ArtistUpdateRequest request);

  void delete(UUID id);

  ArtistGetResponse getById(UUID id);

  List<ArtistGetResponse> getAll();

  Artist getForByIdNative(UUID id);
}
