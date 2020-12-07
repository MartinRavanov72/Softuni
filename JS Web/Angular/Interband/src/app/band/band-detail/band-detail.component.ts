import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IUser } from 'src/app/shared/interfaces';
import { BandService } from '../band.service';

@Component({
  selector: 'app-band-detail',
  templateUrl: './band-detail.component.html',
  styleUrls: ['./band-detail.component.css']
})
  
export class BandDetailComponent implements OnInit {

  band: IUser = null;

  constructor(
    bandService: BandService,
    activatedRoute: ActivatedRoute
  ) {
    const id = activatedRoute.snapshot.params.id;

    bandService.loadBand(id).subscribe(band => {
      this.band = band;
    });
  }

  ngOnInit(): void {
  }
}
