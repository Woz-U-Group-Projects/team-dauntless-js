import { Component, OnInit } from '@angular/core';

import { LeaderboardService } from '../services/http_methods/leaderboard.service';

import { User } from '../models/user';
import { Leaderboard } from '../models/leaderboard';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {
  public Leaderboards : Observable<any>;

  public LeaderboardList : any;

  constructor(private leaderboard : LeaderboardService) { }

  ngOnInit() {
    this.Leaderboards = this.leaderboard.getLeaderboardList();
  }


}
