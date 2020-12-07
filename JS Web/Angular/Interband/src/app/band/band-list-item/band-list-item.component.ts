import { Component, Input, OnInit } from '@angular/core';
import { IUser } from 'src/app/shared/interfaces';

@Component({
  selector: 'app-band-list-item',
  templateUrl: './band-list-item.component.html',
  styleUrls: ['./band-list-item.component.css']
})
  
export class BandListItemComponent implements OnInit {

  @Input() band: IUser;

  constructor() { }

  ngOnInit(): void {
  }
}
