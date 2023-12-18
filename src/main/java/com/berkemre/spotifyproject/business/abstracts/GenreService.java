package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.genre.requests.GenreAddRequest;
import com.berkemre.spotifyproject.business.dtos.genre.requests.GenreUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreAddResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreGetResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreUpdateResponse;
import com.berkemre.spotifyproject.entities.Genre;
import java.util.List;
import java.util.UUID;

public interface GenreService {
  GenreAddResponse add(GenreAddRequest request);

  GenreUpdateResponse update(UUID id, GenreUpdateRequest request);

  void delete(UUID id);

  GenreGetResponse getById(UUID id);

  List<GenreGetResponse> getAll();

  Genre getForByIdNative(UUID id);
}
