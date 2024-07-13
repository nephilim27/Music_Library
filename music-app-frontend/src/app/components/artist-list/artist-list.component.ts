import {Component, OnInit} from '@angular/core';
import {Artist} from "../../models/artist";
import {ArtistService} from "../../services/artist.service";
import {HttpClient} from "@angular/common/http";
import {CommonModule, NgFor, NgIf} from "@angular/common";
import {BrowserModule} from "@angular/platform-browser";

@Component({
  selector: 'app-artist-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './artist-list.component.html',
  styleUrl: './artist-list.component.css'
})
export class ArtistListComponent implements OnInit {
  artists: Artist[] = [];

  constructor(private artistService: ArtistService) {}

  ngOnInit(): void {
    this.fetchArtists();
  }

  fetchArtists(): void {
    this.artistService.getArtists()
      .subscribe((artists: Artist[]) => {
        this.artists = artists;
      });
  }
}
