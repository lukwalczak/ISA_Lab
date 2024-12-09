import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionEditComponent } from './profession-edit.component';

describe('ProfessionEditComponent', () => {
  let component: ProfessionEditComponent;
  let fixture: ComponentFixture<ProfessionEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfessionEditComponent]
    });
    fixture = TestBed.createComponent(ProfessionEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
