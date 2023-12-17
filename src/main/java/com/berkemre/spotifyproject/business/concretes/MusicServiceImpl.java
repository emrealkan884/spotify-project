package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.business.dtos.music.requests.MusicAddRequest;
import com.berkemre.spotifyproject.business.dtos.music.requests.MusicUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicAddResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicGetResponse;
import com.berkemre.spotifyproject.business.dtos.music.responses.MusicUpdateResponse;
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
    public MusicAddResponse add(MusicAddRequest request) {
        return null;
    }

    @Override
    public MusicUpdateResponse update(UUID id, MusicUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public MusicGetResponse getById(UUID id) {
        return null;
    }

    @Override
    public List<MusicGetResponse> getAll() {
        return null;
    }
}
