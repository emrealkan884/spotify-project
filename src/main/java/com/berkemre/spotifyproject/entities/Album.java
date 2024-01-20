package com.berkemre.spotifyproject.entities;

import com.berkemre.spotifyproject.core.entities.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDate;
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
@Table(name = "albums")
public class Album extends BaseEntity<UUID> {

  private String name;

  private LocalDate releaseDate;

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  @OneToMany(mappedBy = "album")
  private List<Music> musics;
}
