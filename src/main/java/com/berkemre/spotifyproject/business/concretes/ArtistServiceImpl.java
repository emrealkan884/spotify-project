package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.entities.Artist;
import com.berkemre.spotifyproject.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    @Override
    public Artist add(Artist request) {
        return null;
    }

    @Override
    public Artist update(UUID id, Artist request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Artist getById(UUID id) {
        return null;
    }

    @Override
    public List<Artist> getAll() {
        return null;
    }
}
