import {Component, OnInit} from '@angular/core';
import {Artist} from "../../models/artist";
import {ArtistService} from "../../services/artist.service";
import {CommonModule} from "@angular/common";
import {Router, RouterModule} from "@angular/router";

@Component({
  selector: 'app-artist-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './artist-list.component.html',
  styleUrl: './artist-list.component.css'
})
export class ArtistListComponent implements OnInit {
  artists: Artist[] = [];

  constructor(private artistService: ArtistService, private router: Router) {}

  ngOnInit(): void {
    this.fetchArtists();
  }

  fetchArtists(): void {
    this.artistService.getArtists().subscribe((artists: Artist[]) => {
      this.artists = artists;
    });
  }

  onSelectArtist(artist: Artist): void {
    this.router.navigate(['/albums', artist.artistId]); // Navigate with artist's id
  }

}
