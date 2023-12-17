package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.PlaylistService;
import com.berkemre.spotifyproject.entities.Playlist;
import com.berkemre.spotifyproject.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;

    @Override
    public Playlist add(Playlist request) {
        return null;
    }

    @Override
    public Playlist update(UUID id, Playlist request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Playlist getById(UUID id) {
        return null;
    }

    @Override
    public List<Playlist> getAll() {
        return null;
    }
}
