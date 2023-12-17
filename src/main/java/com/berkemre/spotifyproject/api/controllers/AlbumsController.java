package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.AlbumService;
import com.berkemre.spotifyproject.entities.Album;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/albums")
@RestController
@RequiredArgsConstructor
public class AlbumsController {
    private final AlbumService albumService;

    @GetMapping
    public List<Album> getAll() {
        return albumService.getAll();
    }

    @GetMapping("/{id}")
    public Album getById(@PathVariable UUID id) {
        return albumService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album add(@RequestBody Album request) {
        return albumService.add(request);
    }

    @PutMapping("/{id}")
    public Album update(
            @PathVariable UUID id, @RequestBody Album request) {

        return albumService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        albumService.delete(id);
    }
}
