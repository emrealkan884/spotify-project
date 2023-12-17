package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.ArtistService;
import com.berkemre.spotifyproject.entities.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/artists")
@RestController
@RequiredArgsConstructor
public class ArtistsController {
    private final ArtistService artistService;

    @GetMapping
    public List<Artist> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable UUID id) {
        return artistService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artist add(@RequestBody Artist request) {
        return artistService.add(request);
    }

    @PutMapping("/{id}")
    public Artist update(
            @PathVariable UUID id, @RequestBody Artist request) {

        return artistService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        artistService.delete(id);
    }
}
