import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {SongService} from "../../services/song.service";
import {Song} from "../../models/song";
import {CommonModule} from "@angular/common";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {Observable} from "rxjs";
import { map, startWith } from 'rxjs/operators';


@Component({
  selector: 'app-songs-list',
  standalone: true,
  imports: [CommonModule, MatAutocompleteModule, MatInputModule, MatFormFieldModule, ReactiveFormsModule],
  templateUrl: './songs-list.component.html',
  styleUrl: './songs-list.component.css'
})
export class SongListComponent implements OnInit {
  songs: Song[] = [];
  filteredSongs!: Observable<Song[]>;
  searchControl = new FormControl();

  constructor(
    private route: ActivatedRoute,
    private songService: SongService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const albumId = params['albumId'];
      this.fetchSongs(albumId);
    });

    this.filteredSongs = this.searchControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filterSongs(value))
    );
  }

  fetchSongs(albumId: number): void {
    this.songService.getSongsByAlbum(albumId)
      .subscribe((songs: Song[]) => {
        this.songs = songs;
        // Update the filteredSongs after fetching the songs
        this.filteredSongs = this.searchControl.valueChanges.pipe(
          startWith(''),
          map(value => this._filterSongs(value))
        );
      });
  }

  private _filterSongs(value: string): Song[] {
    const filterValue = value.toLowerCase();
    return this.songs.filter(song => song.title.toLowerCase().includes(filterValue));
  }
}
