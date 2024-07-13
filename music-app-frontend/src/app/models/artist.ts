import {Album} from "./album";

export interface Artist {
  artistId: number;
  name: string;
  showAlbums?: boolean;
  albums?: Album[];
}
