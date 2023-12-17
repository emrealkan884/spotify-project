package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.Playlist;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, UUID> {}
