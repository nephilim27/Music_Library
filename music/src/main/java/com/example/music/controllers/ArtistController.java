package com.example.music.controllers;

import com.example.music.models.Album;
import com.example.music.models.Artist;
import com.example.music.services.AlbumService;
import com.example.music.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/list")
    public Iterable<Artist> getAllArtists() {
        return artistService.list();
    }

}