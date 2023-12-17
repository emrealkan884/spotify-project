package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.entities.Album;

import java.util.List;
import java.util.UUID;

public interface AlbumService {
    Album add(Album request);

    Album update(UUID id, Album request);

    void delete(UUID id);

    Album getById(UUID id);

    List<Album> getAll();
}
