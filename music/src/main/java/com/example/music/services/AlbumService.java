package com.example.music.services;

import com.example.music.models.Album;
import com.example.music.repos.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public Iterable<Album> list(){
        return albumRepository.findAll();
    }

    public Album save(Album album){
        return albumRepository.save(album);
    }

    public Iterable<Album> save (List<Album> albums){
        return albumRepository.saveAll(albums);
    }

    public boolean existsByTitle(String title) {
        return albumRepository.existsByTitle(title);
    }


}
