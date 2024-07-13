package com.example.music.repos;

import com.example.music.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    boolean existsByTitle(String title);

    List<Song> getSongsByAlbumId(Long albumId);
}


