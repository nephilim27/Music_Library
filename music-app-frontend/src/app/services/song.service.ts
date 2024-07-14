import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Song} from "../models/song";

@Injectable({
  providedIn: 'root'
})
export class SongService {
  private apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getSongsByAlbum(albumId: number): Observable<Song[]> {
    const url = `${this.apiUrl}/songs/${albumId}`;
    return this.http.get<Song[]>(url);
  }

  searchSongs(query: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/search?query=${query}`);
  }
}
