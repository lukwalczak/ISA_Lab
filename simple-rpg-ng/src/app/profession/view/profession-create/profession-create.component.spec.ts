import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessionCreateComponent } from './profession-create.component';

describe('ProfessionCreateComponent', () => {
  let component: ProfessionCreateComponent;
  let fixture: ComponentFixture<ProfessionCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProfessionCreateComponent]
    });
    fixture = TestBed.createComponent(ProfessionCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
