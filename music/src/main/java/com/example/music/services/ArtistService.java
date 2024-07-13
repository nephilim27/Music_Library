package com.example.music.services;

import com.example.music.models.Artist;
import com.example.music.repos.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Iterable<Artist> list(){
        return artistRepository.findAll();
    }

    public Artist save(Artist artist){
        return artistRepository.save(artist);
    }

    public Iterable<Artist> save (List<Artist> artists){
        return artistRepository.saveAll(artists);
    }

    public boolean existsByName(String name) {
        return artistRepository.existsByName(name);
    }
    

}
