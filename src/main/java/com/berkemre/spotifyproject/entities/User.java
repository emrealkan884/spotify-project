package com.berkemre.spotifyproject.entities;

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
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String username;
  private String firstName;
  private String lastName;
  private String password;

  @OneToMany(mappedBy = "user")
  private List<Playlist> playlists;

  @OneToMany(mappedBy = "user")
  private List<Like> likes;
}
