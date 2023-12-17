package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.entities.Artist;

import java.util.List;
import java.util.UUID;

public interface ArtistService {
    Artist add(Artist request);

    Artist update(UUID id, Artist request);

    void delete(UUID id);

    Artist getById(UUID id);

    List<Artist> getAll();
}
