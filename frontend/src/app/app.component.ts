import {Component, inject} from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';
import { TopHeaderComponent } from './top-header/top-header.component';
import {MainComponent} from './main/main.component';
import {ProfileComponent} from './profile/profile.component';
import {EditorComponent} from './editor/editor.component';
import {TestPageComponent} from './test-page/test-page.component';
import {RegistrationComponent} from './registration/registration.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TopHeaderComponent, MainComponent, ProfileComponent, EditorComponent, TestPageComponent, RegistrationComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
}
