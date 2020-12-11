import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'showLessText'
})
export class ShowLessTextPipe implements PipeTransform {

  transform(value: string): string {
    if (value?.length > 23) {
      return `${value.substr(0, 23)}...`;
    }
    
    return value;
  }

}
