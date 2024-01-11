package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.business.dtos.artist.requests.AddArtistRequest;
import com.berkemre.spotifyproject.business.dtos.artist.requests.UpdateArtistRequest;
import com.berkemre.spotifyproject.business.dtos.artist.responses.AddArtistResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.GetAllArtistsResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.GetArtistResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.UpdateArtistResponse;
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.Artist;
import com.berkemre.spotifyproject.repositories.ArtistRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
  private final ArtistRepository artistRepository;
  private final ModelMapper modelMapper;

  @Override
  public AddArtistResponse add(AddArtistRequest request) {
    Artist artist = modelMapper.map(request, Artist.class);
    artist.setId(UUID.randomUUID());
    Artist createdArtist = artistRepository.save(artist);
    AddArtistResponse response = modelMapper.map(createdArtist, AddArtistResponse.class);
    return response;
  }

  @Override
  public UpdateArtistResponse update(UUID id, UpdateArtistRequest request) {
    checkIfArtistExists(id);
    Artist artist = modelMapper.map(request, Artist.class);
    artist.setId(id);
    Artist updatedArtist = artistRepository.save(artist);
    UpdateArtistResponse response = modelMapper.map(updatedArtist, UpdateArtistResponse.class);
    return response;
  }

  @Override
  public void delete(UUID id) {
    checkIfArtistExists(id);
    artistRepository.deleteById(id);
  }

  @Override
  public GetArtistResponse getById(UUID id) {
    checkIfArtistExists(id);
    Artist artist = artistRepository.findById(id).orElseThrow();
    GetArtistResponse response = modelMapper.map(artist, GetArtistResponse.class);
    return response;
  }

  @Override
  public List<GetAllArtistsResponse> getAll() {
    List<Artist> artists = artistRepository.findAll();
    List<GetAllArtistsResponse> response =
        artists.stream()
            .map(artist -> modelMapper.map(artist, GetAllArtistsResponse.class))
            .toList();
    return response;
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
