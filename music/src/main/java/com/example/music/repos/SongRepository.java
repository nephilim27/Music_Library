package com.example.music.repos;

import com.example.music.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    boolean existsByTitle(String title);
}


