package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.artist.requests.AddArtistRequest;
import com.berkemre.spotifyproject.business.dtos.artist.requests.UpdateArtistRequest;
import com.berkemre.spotifyproject.business.dtos.artist.responses.AddArtistResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.GetAllArtistsResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.GetArtistResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.UpdateArtistResponse;
import com.berkemre.spotifyproject.entities.Artist;
import java.util.List;
import java.util.UUID;

public interface ArtistService {
  AddArtistResponse add(AddArtistRequest request);

  UpdateArtistResponse update(UUID id, UpdateArtistRequest request);

  void delete(UUID id);

  GetArtistResponse getById(UUID id);

  List<GetAllArtistsResponse> getAll();

  List<Artist> getForByIdsNative(List<UUID> ids);

  Artist getForByIdNative(UUID id);
}
