import { Component, OnInit } from '@angular/core';

import { LeaderboardService } from '../services/http_methods/leaderboard.service';

import { User } from '../models/user';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {
  user: User;

  constructor(leaderboard : LeaderboardService) { }

  ngOnInit() {
    
  }


}
