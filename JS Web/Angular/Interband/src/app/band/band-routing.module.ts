import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../core/guards/auth-guard';
import { BandListComponent } from './band-list/band-list.component';
import { BandDetailComponent } from './band-detail/band-detail.component';

const routes: Routes = [
  {
    path: 'band',
    canActivateChild: [AuthGuard],
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: BandListComponent,
        data: {
          title: 'Bands'
        }
      },
      {
        path: ':id',
        component: BandDetailComponent,
        data: {
          title: 'Band detail',
          isLogged: true
        }
      }
    ]
  }
];

export const BandRoutingModule = RouterModule.forChild(routes);