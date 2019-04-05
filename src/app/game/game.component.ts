import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent {
  private readonly config: GameConfig = {
    title: 'CodeQuest',
    width: 800,
    height: 600,
    parent: 'game',
    backgroundColor: '#18216D',
  };

  constructor() {}
}
