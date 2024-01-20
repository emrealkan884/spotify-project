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
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "artists")
public class Artist extends BaseEntity<UUID> {

  private String name;

  @ManyToOne
  @JoinColumn(name = "genre_id")
  private Genre genre;

  //    @OneToMany(mappedBy = "artist")
  //    private List<Music> musics;

  @OneToMany(mappedBy = "artist")
  private List<Album> albums;
}
