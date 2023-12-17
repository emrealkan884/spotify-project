package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.entities.Music;
import com.berkemre.spotifyproject.repositories.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;

    @Override
    public Music add(Music request) {
        return null;
    }

    @Override
    public Music update(UUID id, Music request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public Music getById(UUID id) {
        return null;
    }

    @Override
    public List<Music> getAll() {
        return null;
    }
}
