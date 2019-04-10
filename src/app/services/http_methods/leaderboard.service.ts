import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Leaderboard } from '../../models/leaderboard';

@Injectable({
  providedIn: 'root'
})
export class LeaderboardService {

  constructor(private http : HttpClient) { }

  getLeaderboardList() : Observable<any> {
    let header = new HttpHeaders({"Authorization": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InJ5YW4ifQ.tYg449BU5dDH-PlnRftoDxWAfkfA-6kAe6MxWsoyiB8"});

    return this.http.get("http://localhost:8080/leaderboard", {headers: header});
  }
}
