package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.entities.Music;

import java.util.List;
import java.util.UUID;

public interface MusicService {
    Music add(Music request);

    Music update(UUID id, Music request);

    void delete(UUID id);

    Music getById(UUID id);

    List<Music> getAll();
}
