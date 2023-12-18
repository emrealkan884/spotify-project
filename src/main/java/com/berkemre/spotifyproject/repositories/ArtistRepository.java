package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.Artist;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, UUID> {

  @Query(value = "Select * from artists WHERE id = :id", nativeQuery = true)
  Artist getForByIdNative(@Param("id") UUID id);
}
