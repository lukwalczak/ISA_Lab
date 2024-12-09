import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionListComponent } from './profession-list.component';

describe('ProfessionListComponent', () => {
  let component: ProfessionListComponent;
  let fixture: ComponentFixture<ProfessionListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfessionListComponent]
    });
    fixture = TestBed.createComponent(ProfessionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
