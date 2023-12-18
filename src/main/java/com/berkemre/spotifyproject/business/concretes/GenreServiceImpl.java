package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.GenreService;
import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.dtos.genre.requests.GenreAddRequest;
import com.berkemre.spotifyproject.business.dtos.genre.requests.GenreUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreAddResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreGetResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GenreUpdateResponse;
import com.berkemre.spotifyproject.entities.Genre;
import com.berkemre.spotifyproject.repositories.GenreRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
  private final GenreRepository genreRepository;
  private final MusicService musicService;

  @Override
  public GenreAddResponse add(GenreAddRequest request) {
    Genre genre = Genre.builder().name(request.getName()).build();
    genre = genreRepository.save(genre);
    GenreAddResponse genreAddResponse =
        GenreAddResponse.builder()
            .musics(genre.getMusics())
            .id(genre.getId())
            .name(genre.getName())
            .build();
    return genreAddResponse;
  }

  @Override
  public GenreUpdateResponse update(UUID id, GenreUpdateRequest request) {
    return null;
  }

  @Override
  public void delete(UUID id) {}

  @Override
  public GenreGetResponse getById(UUID id) {
    return null;
  }

  @Override
  public List<GenreGetResponse> getAll() {
    return null;
  }

  @Override
  public Genre getForByIdNative(UUID id) {
    checkIfGenreExists(id);
    return genreRepository.getForByIdNative(id);
  }

  private void checkIfGenreExists(UUID id) {
    if (!genreRepository.existsById(id)) throw new RuntimeException("Boyle bir tarz mevcut degil");
  }
}
