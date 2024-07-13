import {Routes} from '@angular/router';
import {ArtistListComponent} from './components/artist-list/artist-list.component';
import {AlbumListComponent} from "./components/album-list/album-list.component";

export const routes: Routes = [
  { path: '', redirectTo: '/artists', pathMatch: 'full' },
  { path: 'artists', component: ArtistListComponent },
  { path: 'albums/:artistId', component: AlbumListComponent },
  // Add other routes as needed
];
