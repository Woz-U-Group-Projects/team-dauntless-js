import { Component, OnInit } from '@angular/core';

import { Game } from 'phaser';

import { MainSceneService } from '../services/main-scene.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent {
  private readonly config: GameConfig = {
    title: 'CodeQuest',
    type: Phaser.AUTO,
    width: 800,
    height: 600,
    parent: 'game',
    backgroundColor: '#18216D',
  };

  public readonly phaser = Phaser;

  constructor(public mainScene : MainSceneService) {}

  onGameReady(game : Game) {
    game.scene.add('main', this.mainScene, true)
  }
}
