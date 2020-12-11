import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmailValidatorDirective } from './email-validator.directive';
import { ShowLessTextPipe } from './show-less-text.pipe';
import { TimePassedPipe } from './time-passed.pipe';

@NgModule({
  declarations: [
    ShowLessTextPipe,
    EmailValidatorDirective,
    TimePassedPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    ShowLessTextPipe,
    EmailValidatorDirective,
    TimePassedPipe
  ]
})
  
export class SharedModule { }
