package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.PlaylistService;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.PlaylistAddRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.PlaylistUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistAddResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistGetResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistUpdateResponse;
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
    public PlaylistAddResponse add(PlaylistAddRequest request) {
        return null;
    }

    @Override
    public PlaylistUpdateResponse update(UUID id, PlaylistUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public PlaylistGetResponse getById(UUID id) {
        return null;
    }

    @Override
    public List<PlaylistGetResponse> getAll() {
        return null;
    }
}
