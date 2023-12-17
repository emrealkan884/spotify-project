package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.entities.Album;
import com.berkemre.spotifyproject.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    @Override
    public Album add(Album request) {
        return null;
    }

    @Override
    public Album update(Album request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Album getById(UUID id) {
        return null;
    }

    @Override
    public List<Album> getAll() {
        return null;
    }
}
