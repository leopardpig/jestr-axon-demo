package com.mangomagma.jestr.axondemo.repository;

import com.mangomagma.jestr.axondemo.entity.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.UUID;

public interface JokeRepository extends JpaRepository<Joke, UUID> {
    @Modifying(clearAutomatically = true)
    @Query("""
         UPDATE Joke j SET j.status = :newStatus, j.owner = :owner, j.statusTime = :statusTime
         WHERE j.id = :jokeId AND j.status = :status
       """)
    int updateJoke(
      @Param("jokeId") UUID jokeId,
      @Param("owner") String owner,
      @Param("status") String status,
      @Param("newStatus") String newStatus,
      @Param("statusTime") LocalDateTime statusTime);
}
