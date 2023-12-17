package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.Album;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {}
