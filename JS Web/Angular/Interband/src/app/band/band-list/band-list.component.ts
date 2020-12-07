import { Component, OnInit } from '@angular/core';
import { IUser } from 'src/app/shared/interfaces';
import { BandService } from '../band.service';

@Component({
  selector: 'app-band-list',
  templateUrl: './band-list.component.html',
  styleUrls: ['./band-list.component.css']
})
  
export class BandListComponent implements OnInit {

  bandList: IUser[];

  constructor(private bandService: BandService) { }

  ngOnInit(): void {
    this.bandService.loadBandList().subscribe(bandList => {
      this.bandList = bandList;
    });
  }
}
