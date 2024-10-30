import {Routes} from '@angular/router';
import {StartComponent} from './start/start.component';
import {MainComponent} from './main/main.component';
import {RegistrationComponent} from './registration/registration.component';
import {EditorComponent} from './editor/editor.component';
import {ProfileComponent} from './profile/profile.component';
import {TestPageComponent} from './test-page/test-page.component';

export const routes: Routes = [
  {path: '', component: StartComponent, title: 'Platinum Forms'},
  {path: 'main', component: MainComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'editor', component: EditorComponent},
  {path: 'profile', component:ProfileComponent},
  {path: 'test-page', component:TestPageComponent}
];
