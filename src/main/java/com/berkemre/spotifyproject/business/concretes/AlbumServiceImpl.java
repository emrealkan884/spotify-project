package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.business.dtos.album.requests.AlbumAddRequest;
import com.berkemre.spotifyproject.business.dtos.album.requests.AlbumUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumAddResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumGetResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumUpdateResponse;
import com.berkemre.spotifyproject.entities.Album;
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
  public AlbumAddResponse add(AlbumAddRequest request) {
    Album album =
        Album.builder()
            .name(request.getName())
            .artist(artistService.getForByIdNative(request.getArtistId()))
            .releaseDate(LocalDate.now())
            .build();
    album = albumRepository.save(album);
    AlbumAddResponse albumAddResponse =
        AlbumAddResponse.builder()
            .id(album.getId())
            .name(album.getName())
            .musics(album.getMusics())
            .artistName(album.getArtist().getName())
            .releaseDate(album.getReleaseDate())
            .build();
    return albumAddResponse;
  }

  @Override
  public AlbumUpdateResponse update(UUID id, AlbumUpdateRequest request) {
    checkIfAlbumExists(id);
    Album album = albumRepository.getReferenceById(id);
    album.setName(request.getName());
    album.setReleaseDate(request.getReleaseDate());
    album = albumRepository.save(album);
    AlbumUpdateResponse albumUpdateResponse =
        AlbumUpdateResponse.builder()
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
  public AlbumGetResponse getById(UUID id) {
    checkIfAlbumExists(id);
    Album album = albumRepository.getReferenceById(id);
    AlbumGetResponse albumGetResponse =
        AlbumGetResponse.builder()
            .releaseDate(album.getReleaseDate())
            .name(album.getName())
            .id(album.getId())
            .build();
    return albumGetResponse;
  }

  @Override
  public List<AlbumGetResponse> getAll() {
    List<Album> albums = albumRepository.findAll();
    AlbumGetResponse albumGetResponse = new AlbumGetResponse();
    List<AlbumGetResponse> responses = new ArrayList<>();
    for (Album album : albums) {
      albumGetResponse.setId(album.getId());
      albumGetResponse.setName(album.getName());
      albumGetResponse.setReleaseDate(album.getReleaseDate());
      responses.add(albumGetResponse);
    }
    return responses;
  }

  @Override
  public Album getForByIdNative(UUID id) {
    checkIfAlbumExists(id);
    return albumRepository.getForByIdNative(id);
  }

  private void checkIfAlbumExists(UUID id) {
    if (!albumRepository.existsById(id)) throw new RuntimeException("Boyle bir album mevcut degil");
  }
}
