package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.business.dtos.album.responses.GetAllAlbumsResponse;
import com.berkemre.spotifyproject.entities.Album;
import com.berkemre.spotifyproject.entities.Artist;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {
  @Query(value = "Select * from albums WHERE id = :id", nativeQuery = true)
  Album getForByIdNative(@Param("id") UUID id);

  @Query(
      value =
          "Select new com.berkemre.spotifyproject.business.dtos.album.responses.GetAllAlbumsResponse"
              + "(a.id,a.name,a.releaseDate) from Album a "
              + "Where a.artist = :artist")
  List<GetAllAlbumsResponse> getForByArtist(Artist artist);
}
