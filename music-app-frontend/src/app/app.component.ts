import { Component } from '@angular/core';
import {RouterModule, RouterOutlet} from '@angular/router';
import {ArtistListComponent} from "./components/artist-list/artist-list.component";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
    imports: [RouterOutlet, ArtistListComponent, RouterModule, CommonModule  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'music-app-frontend';
}
