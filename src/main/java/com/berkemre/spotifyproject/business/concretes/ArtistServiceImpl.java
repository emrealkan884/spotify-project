package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.business.abstracts.GenreService;
import com.berkemre.spotifyproject.business.dtos.artist.requests.AddArtistRequest;
import com.berkemre.spotifyproject.business.dtos.artist.requests.UpdateArtistRequest;
import com.berkemre.spotifyproject.business.dtos.artist.responses.AddArtistResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.GetArtistResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.UpdateArtistResponse;
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.Artist;
import com.berkemre.spotifyproject.repositories.ArtistRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
  private final ArtistRepository artistRepository;
  private final GenreService genreService;

  @Override
  public AddArtistResponse add(AddArtistRequest request) {
    Artist artist =
        Artist.builder()
            .name(request.getName())
            .genre(genreService.getForByIdNative(request.getGenreId()))
            .build();
    artist = artistRepository.save(artist);
    AddArtistResponse addArtistResponse =
        AddArtistResponse.builder().id(artist.getId()).name(artist.getName()).build();
    return addArtistResponse;
  }

  @Override
  public UpdateArtistResponse update(UUID id, UpdateArtistRequest request) {
    checkIfArtistExists(id);
    Artist artist = artistRepository.getReferenceById(id);
    artist.setName(request.getName());
    artist = artistRepository.save(artist);
    UpdateArtistResponse updateArtistResponse =
        UpdateArtistResponse.builder().id(artist.getId()).name(artist.getName()).build();
    return updateArtistResponse;
  }

  @Override
  public void delete(UUID id) {
    checkIfArtistExists(id);
    artistRepository.deleteById(id);
  }

  @Override
  public GetArtistResponse getById(UUID id) {
    checkIfArtistExists(id);
    Artist artist = artistRepository.getReferenceById(id);
    GetArtistResponse getArtistResponse =
        GetArtistResponse.builder().name(artist.getName()).albums(artist.getAlbums()).build();
    return getArtistResponse;
  }

  @Override
  public List<GetArtistResponse> getAll() {
    List<GetArtistResponse> responses = new ArrayList<>();
    GetArtistResponse getArtistResponse = new GetArtistResponse();
    List<Artist> artists = artistRepository.findAll();
    for (Artist artist : artists) {
      getArtistResponse.setName(artist.getName());
      getArtistResponse.setAlbums(artist.getAlbums());
      responses.add(getArtistResponse);
    }
    return responses;
  }

  @Override
  public List<Artist> getForByIdsNative(List<UUID> ids) {
    return artistRepository.getForByIdsNative(ids);
  }

  @Override
  public Artist getForByIdNative(UUID id) {
    checkIfArtistExists(id);
    return artistRepository.getForByIdNative(id);
  }

  private void checkIfArtistExists(UUID id) {
    if (!artistRepository.existsById(id))
      throw new BusinessException("Boyle bir artist mevcut degil");
  }
}
