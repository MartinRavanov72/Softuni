import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IUser } from 'src/app/shared/interfaces';
import { UserService } from 'src/app/user/user.service';
import { BandService } from '../band.service';

@Component({
  selector: 'app-band-detail',
  templateUrl: './band-detail.component.html',
  styleUrls: ['./band-detail.component.css']
})
  
export class BandDetailComponent implements OnInit {

  band: IUser = null;
  isCurrentUser = false;

  constructor(
    bandService: BandService,
    userService: UserService,
    activatedRoute: ActivatedRoute,
    router: Router
  ) {
    const id = activatedRoute.snapshot.params.id;

    if (id == userService.currentUser._id) {
      this.isCurrentUser = true;
    }

    bandService.loadBand(id).subscribe(band => {
      this.band = band;
    });
  }

  ngOnInit(): void {
  }
}
