package com.berkemre.spotifyproject.api.controllers;

import com.berkemre.spotifyproject.business.abstracts.MusicService;
import com.berkemre.spotifyproject.entities.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/musics")
@RestController
@RequiredArgsConstructor
public class MusicsController {
    private final MusicService musicService;

    @GetMapping
    public List<Music> getAll() {
        return musicService.getAll();
    }

    @GetMapping("/{id}")
    public Music getById(@PathVariable UUID id) {
        return musicService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Music add(@RequestBody Music request) {
        return musicService.add(request);
    }

    @PutMapping("/{id}")
    public Music update(
            @PathVariable UUID id, @RequestBody Music request) {

        return musicService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {

        musicService.delete(id);
    }
}
