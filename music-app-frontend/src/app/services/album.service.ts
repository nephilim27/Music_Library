import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Album} from "../models/album";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  private apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getAlbumsByArtist(artistId: number): Observable<Album[]> {
    const url = `${this.apiUrl}/albums/${artistId}`;
    return this.http.get<Album[]>(url);
  }
}
