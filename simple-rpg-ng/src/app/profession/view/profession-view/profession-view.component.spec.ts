import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionViewComponent } from './profession-view.component';

describe('ProfessionViewComponent', () => {
  let component: ProfessionViewComponent;
  let fixture: ComponentFixture<ProfessionViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfessionViewComponent]
    });
    fixture = TestBed.createComponent(ProfessionViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
