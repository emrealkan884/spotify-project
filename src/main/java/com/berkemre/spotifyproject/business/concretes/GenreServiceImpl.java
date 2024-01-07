package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.GenreService;
import com.berkemre.spotifyproject.business.dtos.genre.requests.AddGenreRequest;
import com.berkemre.spotifyproject.business.dtos.genre.requests.UpdateGenreRequest;
import com.berkemre.spotifyproject.business.dtos.genre.responses.AddGenreResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GetAllGenresResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GetGenreResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.UpdateGenreResponse;
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.Genre;
import com.berkemre.spotifyproject.entities.Music;
import com.berkemre.spotifyproject.repositories.GenreRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
  private final GenreRepository genreRepository;

  @Override
  public AddGenreResponse add(AddGenreRequest request) {
    Genre genre = Genre.builder().name(request.getName()).build();
    genre = genreRepository.save(genre);
    AddGenreResponse addGenreResponse =
        AddGenreResponse.builder().id(genre.getId()).name(genre.getName()).build();
    return addGenreResponse;
  }

  @Override
  public UpdateGenreResponse update(UUID id, UpdateGenreRequest request) {
    return null;
  }

  @Override
  public void delete(UUID id) {}

  @Override
  public GetGenreResponse getById(UUID id) {
    checkIfGenreExists(id);
    Genre genre = genreRepository.getReferenceById(id);
    GetGenreResponse getGenreResponse =
        GetGenreResponse.builder()
            .name(genre.getName())
            .musicsName(genre.getMusics().stream().map(Music::getName).collect(Collectors.toList()))
            .id(genre.getId())
            .build();
    return getGenreResponse;
  }

  @Override
  public List<GetAllGenresResponse> getAll() {
    List<Genre> genres = genreRepository.findAll();
    GetAllGenresResponse getAllGenreResponse;
    List<GetAllGenresResponse> responses = new ArrayList<>();
    for (Genre genre : genres) {
      getAllGenreResponse = new GetAllGenresResponse();
      getAllGenreResponse.setId(genre.getId());
      getAllGenreResponse.setName(genre.getName());
      getAllGenreResponse.setMusicsName(
          genre.getMusics().stream().map(Music::getName).collect(Collectors.toList()));
      responses.add(getAllGenreResponse);
    }
    return responses;
  }

  @Override
  public Genre getForByIdNative(UUID id) {
    checkIfGenreExists(id);
    return genreRepository.getForByIdNative(id);
  }

  private void checkIfGenreExists(UUID id) {
    if (!genreRepository.existsById(id)) throw new BusinessException("Boyle bir tarz mevcut degil");
  }
}
