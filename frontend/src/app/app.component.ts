import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TopHeaderComponent } from './top-header/top-header.component';
import {MainComponent} from './main/main.component';
import {ProfileComponent} from './profile/profile.component';
import {EditorComponent} from './editor/editor.component';
import {TestPageComponent} from './test-page/test-page.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TopHeaderComponent, MainComponent, ProfileComponent, EditorComponent, TestPageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
