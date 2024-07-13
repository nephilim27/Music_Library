import {Component, OnInit} from '@angular/core';
import {Album} from "../../models/album";
import {ActivatedRoute, Router} from "@angular/router";
import {CommonModule} from "@angular/common";
import {AlbumService} from "../../services/album.service";

@Component({
  selector: 'app-album-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './album-list.component.html',
  styleUrl: './album-list.component.css'
})
export class AlbumListComponent implements OnInit {
  albums: Album[] = [];

  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const artistId = params['artistId'];
      this.fetchAlbums(artistId);
    });
  }

  fetchAlbums(artistId: number): void {
    this.albumService.getAlbumsByArtist(artistId)
      .subscribe((albums: Album[]) => {
        this.albums = albums;
      });
  }
}
