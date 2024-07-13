import {Album} from "./album";

export interface Artist {
  artistId: number;
  name: string;
  albums?: Album[]; // Optional, if you want to include albums
}
