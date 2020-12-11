import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'timePassed'
})
export class TimePassedPipe implements PipeTransform {

  transform(value: string): string {
    const dateNow: Date = new Date();
    const date = new Date();

    date.setFullYear(+value.substr(0, 4));
    date.setMonth(+value.substr(5, 2) - 1);
    date.setDate(+value.substr(8, 2));
    date.setHours(+value.substr(11, 2));
    date.setMinutes(+value.substr(14, 2));
    date.setSeconds(+value.substr(17, 2));

    const diffTime = Math.abs((date.getTime() + 2 * 60 * 60 * 1000) - dateNow.getTime());
    const diffDays = Math.floor(diffTime / (1000 * 60 * 60 * 24)); 
    const diffHours = Math.floor(diffTime / (1000 * 60 * 60)); 
    const diffMinutes = Math.floor(diffTime / (1000 * 60)); 
    const diffSeconds = Math.floor(diffTime / (1000)); 

    if (diffDays < 1) {
      if (diffHours < 1) {
        if (diffMinutes < 1) {
          if (diffSeconds < 3) {
            return "Now";
          }
          return `${diffSeconds} seconds ago`;
        }
        if (diffMinutes == 1) {
          return `${diffMinutes} minute ago`;
        }
        return `${diffMinutes} minutes ago`;
      }
      if (diffHours == 1) {
        return `${diffHours} hour ago`;
      }
      return `${diffHours} hours ago`;
    }
    return `${date.getDate()}.${date.getMonth()+1}.${date.getFullYear()}`;
  }
}
