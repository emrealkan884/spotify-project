package com.berkemre.spotifyproject.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
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
@Table(name = "likes")
public class Like {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private LocalDate date = LocalDate.now();

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "music_id")
  private Music music;
}
