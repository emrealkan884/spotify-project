package com.berkemre.spotifyproject.entities;

import com.berkemre.spotifyproject.core.entities.BaseEntity;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "musics")
public class Music extends BaseEntity<UUID> {

  private String name;

  private String link;

  private String photo;

  private float duration;

  @OneToMany(mappedBy = "music")
  private List<Like> likes;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "playlist_musics",
      joinColumns = @JoinColumn(name = "playlist_id"),
      inverseJoinColumns = @JoinColumn(name = "music_id"))
  // @JsonManagedReference // Playlistin icinde music var music in icinde playlist var. Donguye
  // girmesin diye kullandik.Request Response olmasa donguyu kirmak icin kullanacaktik.
  private List<Playlist> playlists;

  //  @ManyToOne
  //  @JoinColumn(name = "artist_id")
  //  private Artist artist;

  @ManyToOne
  @JoinColumn(name = "album_id")
  private Album album;

  @ManyToOne
  @JoinColumn(name = "genre_id")
  private Genre genre;

  public int getLikeCount() {
    return likes.size();
  }
}
