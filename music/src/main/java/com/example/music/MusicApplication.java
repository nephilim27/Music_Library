package com.example.music;

import com.example.music.models.Album;
import com.example.music.models.Artist;
import com.example.music.models.Song;
import com.example.music.services.AlbumService;
import com.example.music.services.ArtistService;
import com.example.music.services.SongService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class MusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ArtistService artistService, AlbumService albumService, SongService songService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Artist>> typeReference = new TypeReference<List<Artist>>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");

            try {
                List<Artist> artists = mapper.readValue(inputStream, typeReference);

                for (Artist artist : artists) {
                    // Save artist if not already exists
                    if (!artistService.existsByName(artist.getName())) {
                        artistService.save(artist);
                        System.out.println("Saved Artist: " + artist.getName());
                    }

                    // Process albums for the artist
                    for (Album album : artist.getAlbums()) {
//                        album.setArtist(artist); // Set the artist for the album
                        album.setArtistId(artist.getArtistId());

                        // Save album if not already exists
                        if (!albumService.existsByTitle(album.getTitle())) {
                            albumService.save(album);
                            System.out.println("Saved Album: " + album.getTitle());
                        }

                        // Process songs for the album
                        for (Song song : album.getSongs()) {
//                            song.setAlbum(album); // Set the album for the song
                            song.setAlbumId(album.getAlbumId());

                            // Save song if not already exists
                            if (!songService.existsByTitle(song.getTitle())) {
                                songService.save(song);
                                System.out.println("Saved Song: " + song.getTitle());
                            }
                        }
                    }
                }

                System.out.println("Data loaded successfully!");

            } catch (IOException e) {
                System.out.println("Unable to save data: " + e.getMessage());
            }
        };
    }
}