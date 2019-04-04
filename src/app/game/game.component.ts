import { Component, OnInit } from '@angular/core';

Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
});

const config: GameConfig = {
  title: 'CodeQuest',
  width: 800,
  height: 600,
  parent: 'game',
  backgroundColor: '#18216D',
};

export class GameComponent {
}
