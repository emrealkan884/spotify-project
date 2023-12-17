package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.Music;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, UUID> {}
