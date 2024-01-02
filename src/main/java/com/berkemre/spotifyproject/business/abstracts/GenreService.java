package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.genre.requests.AddGenreRequest;
import com.berkemre.spotifyproject.business.dtos.genre.requests.UpdateGenreRequest;
import com.berkemre.spotifyproject.business.dtos.genre.responses.AddGenreResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GetGenreResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.UpdateGenreResponse;
import com.berkemre.spotifyproject.entities.Genre;
import java.util.List;
import java.util.UUID;

public interface GenreService {
  AddGenreResponse add(AddGenreRequest request);

  UpdateGenreResponse update(UUID id, UpdateGenreRequest request);

  void delete(UUID id);

  GetGenreResponse getById(UUID id);

  List<GetGenreResponse> getAll();

  Genre getForByIdNative(UUID id);
}
