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
@Table(name = "genres")
public class Genre extends BaseEntity<UUID> {

  private String name;

  @OneToMany(mappedBy = "genre")
  private List<Music> musics;

  @OneToMany(mappedBy = "genre")
  private List<Artist> artists;
}
