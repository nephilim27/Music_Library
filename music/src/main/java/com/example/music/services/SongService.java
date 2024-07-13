package com.example.music.services;

import com.example.music.models.Song;
import com.example.music.repos.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Iterable<Song> list(){
        return songRepository.findAll();
    }

    public Song save(Song song){
        return songRepository.save(song);
    }

    public Iterable<Song> save (List<Song> songs){
        return songRepository.saveAll(songs);
    }

    public boolean existsByTitle(String title) {
        return songRepository.existsByTitle(title);
    }

    public List<Song> getSongsByAlbumId (Long albumId){
        return songRepository.getSongsByAlbumId(albumId);
    }
}
