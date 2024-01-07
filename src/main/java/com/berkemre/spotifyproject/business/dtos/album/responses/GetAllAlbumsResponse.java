package com.berkemre.spotifyproject.business.dtos.album.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetAllAlbumsResponse {
    private UUID id;
    private String name;
    private LocalDate releaseDate;
}

