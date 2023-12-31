package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.Album;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {
  @Query(value = "Select * from albums WHERE id = :id", nativeQuery = true)
  Album getForByIdNative(@Param("id") UUID id);
}
