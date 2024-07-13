import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {SongService} from "../../services/song.service";
import {Song} from "../../models/song";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-songs-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './songs-list.component.html',
  styleUrl: './songs-list.component.css'
})
export class SongListComponent implements OnInit {
  songs: Song[] = [];

  constructor(
    private route: ActivatedRoute,
    private songService: SongService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const albumId = params['albumId'];
      this.fetchSongs(albumId);
    });
  }

  fetchSongs(albumId: number): void {
    this.songService.getSongsByAlbum(albumId)
      .subscribe((songs: Song[]) => {
        this.songs = songs;
      });
  }
}
