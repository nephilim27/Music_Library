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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringBootApplication
//public class MusicApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(MusicApplication.class, args);
//    }
//
//    @Bean
//    CommandLineRunner runner(ArtistService artistService) {
//        return args -> {
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Artist>> typeReference = new TypeReference<List<Artist>>() {
//            };
//
//            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json")) {
//                if (inputStream != null) {
//                    List<Artist> artists = mapper.readValue(inputStream, typeReference);
//                    artistService.save(artists);
//                    System.out.println("Artists saved!");
//                } else {
//                    System.out.println("Unable to find data.json");
//                }
//            } catch (IOException e) {
//                System.out.println("Unable to save artists: " + e.getMessage());
//            }
//        };
//    }
//
//    @Bean
//    CommandLineRunner runner2(AlbumService albumService) {
//        return args -> {
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Album>> typeReference = new TypeReference<List<Album>>() {
//            };
//
//            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json")) {
//                if (inputStream != null) {
//                    List<Album> albums = mapper.readValue(inputStream, typeReference);
//                    albumService.save(albums);
//                    System.out.println("Albums saved!");
//                } else {
//                    System.out.println("Unable to find data.json");
//                }
//            } catch (IOException e) {
//                System.out.println("Unable to save albums: " + e.getMessage());
//            }
//        };
//    }
//
//    @Bean
//    CommandLineRunner runner3(SongService songService) {
//        return args -> {
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Song>> typeReference = new TypeReference<List<Song>>() {
//            };
//
//            try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json")) {
//                if (inputStream != null) {
//                    List<Song> songs = mapper.readValue(inputStream, typeReference);
//                    songService.save(songs);
//                    System.out.println("Songs saved!");
//                } else {
//                    System.out.println("Unable to find data.json");
//                }
//            } catch (IOException e) {
//                System.out.println("Unable to save songs: " + e.getMessage());
//            }
//        };
//    }
//}

//@SpringBootApplication
//public class MusicApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(MusicApplication.class, args);
//    }
//
//    @Bean
//    CommandLineRunner runner(ArtistService artistService, AlbumService albumService, SongService songService) {
//        return args -> {
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Artist>> typeReference = new TypeReference<List<Artist>>() {};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
//
//            try {
//                List<Artist> artists = mapper.readValue(inputStream, typeReference);
//
//                for (Artist artist : artists) {
//                    // Save artist if not already exists
//                    if (!artistService.existsByName(artist.getName())) {
//                        artistService.save(artist);
//                        System.out.println("Saved Artist: " + artist.getName());
//                    }
//
//                    // Process albums for the artist
//                    for (Album album : artist.getAlbums()) {
//                        album.setArtistId(artist.getArtistId()); // Set the artist for the album
//
//                        // Save album if not already exists
//                        if (!albumService.existsByTitle(album.getTitle())) {
//                            albumService.save(album);
//                            System.out.println("Saved Album: " + album.getTitle());
//                        }
//
//                        // Process songs for the album
//                        for (Song song : album.getSongs()) {
//                            song.setAlbumId(album.getAlbumId()); // Set the album for the song
//
//                            // Save song if not already exists
//                            if (!songService.existsByTitle(song.getTitle())) {
//                                songService.save(song);
//                                System.out.println("Saved Song: " + song.getTitle());
//                            }
//                        }
//                    }
//                }
//
//                System.out.println("Data loaded successfully!");
//
//            } catch (IOException e) {
//                System.out.println("Unable to save data: " + e.getMessage());
//            }
//        };
//    }
//}

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