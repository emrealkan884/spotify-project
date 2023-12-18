package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.Genre;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, UUID> {
  @Query(value = "Select * from genres WHERE id = :id", nativeQuery = true)
  Genre getForByIdNative(@Param("id") UUID id);
}
