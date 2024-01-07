package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.album.requests.AddAlbumRequest;
import com.berkemre.spotifyproject.business.dtos.album.requests.UpdateAlbumRequest;
import com.berkemre.spotifyproject.business.dtos.album.responses.AddAlbumResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.GetAlbumResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.GetAllAlbumsResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.UpdateAlbumResponse;
import com.berkemre.spotifyproject.entities.Album;
import com.berkemre.spotifyproject.entities.Artist;
import java.util.List;
import java.util.UUID;

public interface AlbumService {

  AddAlbumResponse add(AddAlbumRequest request);

  UpdateAlbumResponse update(UUID id, UpdateAlbumRequest request);

  void delete(UUID id);

  GetAlbumResponse getById(UUID id);

  List<GetAllAlbumsResponse> getAll();

  Album getForByIdNative(UUID id);

  List<GetAllAlbumsResponse> getForByArtist(Artist artist);
}
