import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JoinTestComponent } from './join-test.component';

describe('JoinTestComponent', () => {
  let component: JoinTestComponent;
  let fixture: ComponentFixture<JoinTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JoinTestComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(JoinTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
