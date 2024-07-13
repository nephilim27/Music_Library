package com.example.music.controllers;

import com.example.music.models.Album;
import com.example.music.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/{artistId}")
    public List<Album> getAlbumsByArtistId(@PathVariable Long artistId) {
        return albumService.getAlbumsByArtistId(artistId);
    }

}
