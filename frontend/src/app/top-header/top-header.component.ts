import {Component, inject} from '@angular/core';
import {Router} from '@angular/router';
import {GlobalService} from '../global.service';

@Component({
  selector: 'app-top-header',
  standalone: true,
  imports: [],
  templateUrl: './top-header.component.html',
  styleUrl: './top-header.component.css'
})
export class TopHeaderComponent {

  router = inject(Router)

  constructor(public globalService: GlobalService) {
  }

  navigate_to_main() {
    if (this.globalService.is_logged) {
      this.router.navigate(['/main'])
    }
  }
}
