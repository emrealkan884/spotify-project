package com.berkemre.spotifyproject.business.abstracts;

import com.berkemre.spotifyproject.business.dtos.playlist.requests.PlaylistAddRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.requests.PlaylistUpdateRequest;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistAddResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistGetResponse;
import com.berkemre.spotifyproject.business.dtos.playlist.responses.PlaylistUpdateResponse;

import java.util.List;
import java.util.UUID;

public interface PlaylistService {
    PlaylistAddResponse add(PlaylistAddRequest request);

    PlaylistUpdateResponse update(UUID id, PlaylistUpdateRequest request);

    void delete(UUID id);

    PlaylistGetResponse getById(UUID id);

    List<PlaylistGetResponse> getAll();

}
