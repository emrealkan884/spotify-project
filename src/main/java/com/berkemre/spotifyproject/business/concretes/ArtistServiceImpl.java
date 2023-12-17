package com.berkemre.spotifyproject.business.concretes;

import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.business.dtos.artist.requests.ArtistAddRequest;
import com.berkemre.spotifyproject.business.dtos.artist.requests.ArtistUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistAddResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistGetResponse;
import com.berkemre.spotifyproject.business.dtos.artist.responses.ArtistUpdateResponse;
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
    public ArtistAddResponse add(ArtistAddRequest request) {
        return null;
    }

    @Override
    public ArtistUpdateResponse update(UUID id, ArtistUpdateRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public ArtistGetResponse getById(UUID id) {
        return null;
    }

    @Override
    public List<ArtistGetResponse> getAll() {
        return null;
    }
}
