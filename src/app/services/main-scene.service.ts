import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MainSceneService extends Phaser.Scene {

  constructor() {
    super({key: 'main', })
  }

  create() : void {
    this.cameras.main.centerOn(0, 0);
    this.add.text(0, 0, "Hello Code-Quest!");
  }
}
