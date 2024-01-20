package com.berkemre.spotifyproject.entities;

import com.berkemre.spotifyproject.core.entities.BaseEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playlists")
@Builder
public class Playlist extends BaseEntity<UUID> {

  private String name;

  @ManyToMany(mappedBy = "playlists", fetch = FetchType.LAZY)
  // @JsonBackReference , Request Response olmasa donguyu kirmak icin kullanacaktik.
  private List<Music> musics = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
