import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BandListComponent } from './band-list/band-list.component';
import { BandListItemComponent } from './band-list-item/band-list-item.component';
import { BandService } from './band.service';
import { SharedModule } from '../shared/shared.module';
import { BandRoutingModule } from './band-routing.module';
import { BandDetailComponent } from './band-detail/band-detail.component';

@NgModule({
  declarations: [
    BandListComponent,
    BandListItemComponent,
    BandDetailComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    BandRoutingModule
  ],
  providers: [
    BandService
  ],
  exports: [
    BandListComponent,
    BandListItemComponent
  ]
})
export class BandModule { }
