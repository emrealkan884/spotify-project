package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.entities.Playlist;

import java.util.List;
import java.util.UUID;

public interface PlaylistService {
    Playlist add(Playlist request);

    Playlist update(UUID id, Playlist request);

    void delete(UUID id);

    Playlist getById(UUID id);

    List<Playlist> getAll();

}
