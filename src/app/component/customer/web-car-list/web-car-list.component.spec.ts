import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebCarListComponent } from './web-car-list.component';

describe('WebCarListComponent', () => {
  let component: WebCarListComponent;
  let fixture: ComponentFixture<WebCarListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WebCarListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WebCarListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
