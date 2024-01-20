package com.berkemre.spotifyproject.core.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity<T> {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private T id;

  @Column(name = "createdDate")
  private LocalDateTime createdDate;

  @Column(name = "updatedDate")
  private LocalDateTime updatedDate;

  @Column(name = "deletedDate")
  private LocalDateTime deletedDate;
}
