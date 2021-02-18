import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShowLessTextPipe } from './show-less-text.pipe';
import { TimePassedPipe } from './time-passed.pipe';

@NgModule({
  declarations: [
    ShowLessTextPipe,
    TimePassedPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ShowLessTextPipe,
    TimePassedPipe
  ]
})
  
export class SharedModule { }
