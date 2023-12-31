package com.berkemre.spotifyproject.entities;

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
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;
  private LocalDate releaseDate;

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  @OneToMany(mappedBy = "album")
  private List<Music> musics;
}
