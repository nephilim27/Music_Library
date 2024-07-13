import {Routes} from '@angular/router';
import {ArtistListComponent} from './components/artist-list/artist-list.component';
import {AlbumListComponent} from "./components/album-list/album-list.component";
import {SongListComponent} from "./components/songs-list/songs-list.component";

export const routes: Routes = [
  { path: '', redirectTo: '/artists', pathMatch: 'full' },
  { path: 'artists', component: ArtistListComponent },
  { path: 'albums/:artistId', component: AlbumListComponent },
  { path: 'songs/:albumId', component: SongListComponent}
];
