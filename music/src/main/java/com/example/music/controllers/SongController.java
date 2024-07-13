package com.example.music.controllers;

import com.example.music.models.Song;
import com.example.music.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/list")
    public Iterable<Song> getAllSongs() {
        return songService.list();
    }

    @GetMapping("/{albumId}")
    public List<Song> getSongsByAlbumId(@PathVariable Long albumId){
        return songService.getSongsByAlbumId(albumId);
    }
}
