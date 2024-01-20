package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.business.dtos.album.requests.AddAlbumRequest;
import com.berkemre.spotifyproject.business.dtos.album.requests.UpdateAlbumRequest;
import com.berkemre.spotifyproject.business.dtos.album.responses.AddAlbumResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.GetAlbumResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.GetAllAlbumsResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.UpdateAlbumResponse;
import com.berkemre.spotifyproject.core.exceptions.types.BusinessException;
import com.berkemre.spotifyproject.entities.Album;
import com.berkemre.spotifyproject.entities.Artist;
import com.berkemre.spotifyproject.repositories.AlbumRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
  private final AlbumRepository albumRepository;
  private final ModelMapper modelMapper;

  @Override
  public AddAlbumResponse add(AddAlbumRequest request) {
    Album album = modelMapper.map(request, Album.class);
    album.setId(UUID.randomUUID());
    album.setReleaseDate(LocalDate.now());
    album.setCreatedDate(LocalDateTime.now());
    Album createdAlbum = albumRepository.save(album);
    AddAlbumResponse response = modelMapper.map(createdAlbum, AddAlbumResponse.class);
    return response;
  }

  @Override
  public UpdateAlbumResponse update(UUID id, UpdateAlbumRequest request) {
    checkIfAlbumExists(id);
    Album album = modelMapper.map(request, Album.class);
    album.setId(id);
    album.setUpdatedDate(LocalDateTime.now());
    Album updatedAlbum = albumRepository.save(album);
    UpdateAlbumResponse response = modelMapper.map(updatedAlbum, UpdateAlbumResponse.class);
    return response;
  }

  @Override
  public void delete(UUID id) {
    checkIfAlbumExists(id);
    albumRepository.deleteById(id);
  }

  @Override
  public GetAlbumResponse getById(UUID id) {
    checkIfAlbumExists(id);
    Album album = albumRepository.findById(id).orElseThrow();
    GetAlbumResponse response = modelMapper.map(album, GetAlbumResponse.class);
    return response;
  }

  @Override
  public List<GetAllAlbumsResponse> getAll() {
    List<Album> albums = albumRepository.findAll();
    List<GetAllAlbumsResponse> response =
        albums.stream().map(album -> modelMapper.map(album, GetAllAlbumsResponse.class)).toList();
    return response;
  }

  @Override
  public Album getForByIdNative(UUID id) {
    checkIfAlbumExists(id);
    return albumRepository.getForByIdNative(id);
  }

  @Override
  public List<GetAllAlbumsResponse> getForByArtist(Artist artist) {
    return albumRepository.getForByArtist(artist);
  }

  private void checkIfAlbumExists(UUID id) {
    if (!albumRepository.existsById(id))
      throw new BusinessException("Boyle bir album mevcut degil");
  }
}
