package net.jesselockard.codegame.leaderboard;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeaderboardRepository extends MongoRepository<Leaderboard, String> {
	
}
