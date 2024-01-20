package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.GenreService;
import com.berkemre.spotifyproject.business.dtos.genre.requests.AddGenreRequest;
import com.berkemre.spotifyproject.business.dtos.genre.requests.UpdateGenreRequest;
import com.berkemre.spotifyproject.business.dtos.genre.responses.AddGenreResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GetAllGenresResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.GetGenreResponse;
import com.berkemre.spotifyproject.business.dtos.genre.responses.UpdateGenreResponse;
import com.berkemre.spotifyproject.core.exceptions.types.BusinessException;
import com.berkemre.spotifyproject.entities.Genre;
import com.berkemre.spotifyproject.repositories.GenreRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
  private final GenreRepository genreRepository;
  private final ModelMapper modelMapper;

  @Override
  public AddGenreResponse add(AddGenreRequest request) {
    checkIfGenreExistsByName(request.getName());
    Genre genre = modelMapper.map(request, Genre.class);
    genre.setId(UUID.randomUUID()); // Dto'muzda birden fazla id varsa mapper in kafasi karisiyor.
    genre.setCreatedDate(LocalDateTime.now());
    Genre createdGenre = genreRepository.save(genre);
    AddGenreResponse response = modelMapper.map(createdGenre, AddGenreResponse.class);
    return response;
  }

  @Override
  public UpdateGenreResponse update(UUID id, UpdateGenreRequest request) {
    checkIfGenreExists(id);
    Genre genre = modelMapper.map(request, Genre.class);
    genre.setId(id);
    genre.setUpdatedDate(LocalDateTime.now());
    Genre updatedGenre = genreRepository.save(genre);
    UpdateGenreResponse response = modelMapper.map(updatedGenre, UpdateGenreResponse.class);
    return response;
  }

  @Override
  public void delete(UUID id) {
    genreRepository.deleteById(id);
  }

  @Override
  public GetGenreResponse getById(UUID id) {
    checkIfGenreExists(id);
    Genre genre = genreRepository.findById(id).orElseThrow();
    GetGenreResponse response = modelMapper.map(genre, GetGenreResponse.class);
    return response;
  }

  @Override
  public List<GetAllGenresResponse> getAll() {
    List<Genre> genres = genreRepository.findAll();
    List<GetAllGenresResponse> response =
        genres.stream().map(genre -> modelMapper.map(genre, GetAllGenresResponse.class)).toList();

    return response;
  }

  @Override
  public Genre getForByIdNative(UUID id) {
    checkIfGenreExists(id);
    return genreRepository.getForByIdNative(id);
  }

  private void checkIfGenreExists(UUID id) {
    if (!genreRepository.existsById(id)) throw new BusinessException("Boyle bir tarz mevcut degil");
  }

  private void checkIfGenreExistsByName(String name) {
    if (genreRepository.existsByNameIgnoreCase(name)) {
      throw new BusinessException("Boyle bir tur sistemde zaten kayitli");
    }
  }
}
