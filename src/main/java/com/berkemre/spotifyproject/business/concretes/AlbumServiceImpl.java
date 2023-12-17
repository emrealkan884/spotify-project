package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.business.dtos.album.requests.AlbumAddRequest;
import com.berkemre.spotifyproject.business.dtos.album.requests.AlbumUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumAddResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumGetResponse;
import com.berkemre.spotifyproject.business.dtos.album.responses.AlbumUpdateResponse;
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
    public AlbumAddResponse add(AlbumAddRequest request) {
        return null;
    }

    @Override
    public AlbumUpdateResponse update(UUID id, AlbumUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public AlbumGetResponse getById(UUID id) {
        return null;
    }

    @Override
    public List<AlbumGetResponse> getAll() {
        return null;
    }
}
