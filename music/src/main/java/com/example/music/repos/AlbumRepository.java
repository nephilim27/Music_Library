package com.example.music.repos;


import com.example.music.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    boolean existsByTitle(String title);

    List<Album> findByArtistId(Long artistId);

}

