package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.business.abstracts.GenreService;
import com.berkemre.spotifyproject.business.dtos.artist.requests.ArtistAddRequest;
import com.berkemre.spotifyproject.business.dtos.artist.requests.ArtistUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistAddResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistGetResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistUpdateResponse;
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
  public ArtistAddResponse add(ArtistAddRequest request) {
    Artist artist =
        Artist.builder()
            .name(request.getName())
            .genre(genreService.getForByIdNative(request.getGenreId()))
            .build();
    artist = artistRepository.save(artist);
    ArtistAddResponse artistAddResponse =
        ArtistAddResponse.builder().id(artist.getId()).name(artist.getName()).build();
    return artistAddResponse;
  }

  @Override
  public ArtistUpdateResponse update(UUID id, ArtistUpdateRequest request) {
    checkIfArtistExists(id);
    Artist artist = artistRepository.getReferenceById(id);
    artist.setName(request.getName());
    artist = artistRepository.save(artist);
    ArtistUpdateResponse artistUpdateResponse =
        ArtistUpdateResponse.builder().id(artist.getId()).name(artist.getName()).build();
    return artistUpdateResponse;
  }

  @Override
  public void delete(UUID id) {
    checkIfArtistExists(id);
    artistRepository.deleteById(id);
  }

  @Override
  public ArtistGetResponse getById(UUID id) {
    checkIfArtistExists(id);
    Artist artist = artistRepository.getReferenceById(id);
    ArtistGetResponse artistGetResponse =
        ArtistGetResponse.builder().name(artist.getName()).albums(artist.getAlbums()).build();
    return artistGetResponse;
  }

  @Override
  public List<ArtistGetResponse> getAll() {
    List<ArtistGetResponse> responses = new ArrayList<>();
    ArtistGetResponse artistGetResponse = new ArtistGetResponse();
    List<Artist> artists = artistRepository.findAll();
    for (Artist artist : artists) {
      artistGetResponse.setName(artist.getName());
      artistGetResponse.setAlbums(artist.getAlbums());
      responses.add(artistGetResponse);
    }
    return responses;
  }

  @Override
  public Artist getForByIdNative(UUID id) {
    checkIfArtistExists(id);
    return artistRepository.getForByIdNative(id);
  }

  private void checkIfArtistExists(UUID id) {
    if (!artistRepository.existsById(id))
      throw new RuntimeException("Boyle bir artist mevcut degil");
  }
}
