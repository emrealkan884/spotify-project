package com.berkemre.spotifyproject.repositories;

import com.berkemre.spotifyproject.entities.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  @Query(value = "Select * from users WHERE id = :id", nativeQuery = true)
  User getForByIdNative(@Param("id") UUID id);

}
