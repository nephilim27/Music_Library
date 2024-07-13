import {Artist} from "./artist";
import {Song} from "./song";

export interface Album {
  albumId: number;
  title: string;
  description: string;
  artistId: number;
}
