import { TestBed } from '@angular/core/testing';

import { MainSceneService } from './main-scene.service';

describe('MainSceneService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MainSceneService = TestBed.get(MainSceneService);
    expect(service).toBeTruthy();
  });
});
