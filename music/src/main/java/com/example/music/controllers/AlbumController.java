package com.example.music.controllers;

import com.example.music.models.Album;
import com.example.music.models.Artist;
import com.example.music.services.AlbumService;
import com.example.music.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/list")
    public Iterable<Album> getAllArtists() {
        return albumService.list();
    }
}
