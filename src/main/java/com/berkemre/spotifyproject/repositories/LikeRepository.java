package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.Like;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
  // Derivered Query Method
  boolean existsByUserIdAndMusicId(UUID userId, UUID musicId);
}
