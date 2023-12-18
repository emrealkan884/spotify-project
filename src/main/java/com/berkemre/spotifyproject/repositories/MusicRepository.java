package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.Music;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, UUID> {

  @Query(value = "SELECT * FROM musics WHERE id IN :ids", nativeQuery = true)
  List<Music> getForByIdsNative(@Param("ids") List<UUID> ids);

  @Query(value = "Select * from musics WHERE id = :id", nativeQuery = true)
  Music getForByIdNative(@Param("id") UUID id);
}
