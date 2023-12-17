package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.PlaylistService;
import com.berkemre.spotifyproject.entities.Playlist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/playlists")
@RestController
@RequiredArgsConstructor
public class PlaylistsController {
    private final PlaylistService playlistService;

    @GetMapping
    public List<Playlist> getAll() {
        return playlistService.getAll();
    }

    @GetMapping("/{id}")
    public Playlist getById(@PathVariable UUID id) {
        return playlistService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Playlist add(@RequestBody Playlist request) {
        return playlistService.add(request);
    }

    @PutMapping("/{id}")
    public Playlist update(
            @PathVariable UUID id, @RequestBody Playlist request) {
        return playlistService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        playlistService.delete(id);
    }
}
