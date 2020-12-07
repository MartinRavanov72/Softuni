import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BandListItemComponent } from './band-list-item.component';

describe('BandListItemComponent', () => {
  let component: BandListItemComponent;
  let fixture: ComponentFixture<BandListItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BandListItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BandListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
