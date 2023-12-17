package com.berkemre.spotifyproject.business.dtos.playlist.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaylistAddRequest {
    private String name;
    private UUID userId;
}
