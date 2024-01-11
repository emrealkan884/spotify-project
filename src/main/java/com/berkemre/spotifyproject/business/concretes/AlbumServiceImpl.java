package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.business.dtos.album.requests.AddAlbumRequest;
import com.berkemre.spotifyproject.business.dtos.album.requests.UpdateAlbumRequest;
import com.berkemre.spotifyproject.business.dtos.album.responses.AddAlbumResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.GetAlbumResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.GetAllAlbumsResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.UpdateAlbumResponse;
import com.berkemre.spotifyproject.core.exceptions.BusinessException;
import com.berkemre.spotifyproject.entities.Album;
import com.berkemre.spotifyproject.entities.Artist;
import com.berkemre.spotifyproject.repositories.AlbumRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
  private final AlbumRepository albumRepository;
  private final ArtistService artistService;

  @Override
  public AddAlbumResponse add(AddAlbumRequest request) {
    Album album =
        Album.builder()
            .name(request.getName())
            .artist(artistService.getForByIdNative(request.getArtistId()))
            .releaseDate(LocalDate.now())
            .build();
    album = albumRepository.save(album);
    AddAlbumResponse addAlbumResponse =
        AddAlbumResponse.builder()
            .id(album.getId())
            .name(album.getName())
            .musics(album.getMusics())
            .artistName(album.getArtist().getName())
            .releaseDate(album.getReleaseDate())
            .build();
    return addAlbumResponse;
  }

  @Override
  public UpdateAlbumResponse update(UUID id, UpdateAlbumRequest request) {
    checkIfAlbumExists(id);
    Album album = albumRepository.getReferenceById(id);
    album.setName(request.getName());
    album.setReleaseDate(request.getReleaseDate());
    album = albumRepository.save(album);
    UpdateAlbumResponse albumUpdateResponse =
        UpdateAlbumResponse.builder()
            .id(album.getId())
            .name(album.getName())
            .releaseDate(album.getReleaseDate())
            .build();
    return albumUpdateResponse;
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
    GetAlbumResponse getAlbumResponse =
        GetAlbumResponse.builder()
            .releaseDate(album.getReleaseDate())
            .name(album.getName())
            .id(album.getId())
            .build();
    return getAlbumResponse;
  }

  @Override
  public List<GetAllAlbumsResponse> getAll() {
    List<Album> albums = albumRepository.findAll();
    List<GetAllAlbumsResponse> responses = new ArrayList<>();

    for (Album album : albums) {
      responses.add(
          new GetAllAlbumsResponse(album.getId(), album.getName(), album.getReleaseDate()));
    }
    return responses;
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
