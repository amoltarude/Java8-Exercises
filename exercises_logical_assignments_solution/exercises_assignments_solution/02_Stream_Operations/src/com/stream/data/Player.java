package com.stream.data;

public class Player {
		public String playerName;
		public  int matchesPlayed;
		public int runs;
		public int highestScore;
		public Country country;
		
		public Player(String playerName, int matchesPlayed, int runs, int highestScore, Country country) {
			super();
			this.playerName = playerName;
			this.matchesPlayed = matchesPlayed;
			this.runs = runs;
			this.highestScore = highestScore;
			this.country = country;
		}

		public Player() {
		
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setCountry(Country country) {
			this.country = country;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public int getMatchesPlayed() {
			return matchesPlayed;
		}

		public void setMatchesPlayed(int matchesPlayed) {
			this.matchesPlayed = matchesPlayed;
		}

		public int getRuns() {
			return runs;
		}

		public void setRuns(int runs) {
			this.runs = runs;
		}

		public int getHighestScore() {
			return highestScore;
		}

		public void setHighestScore(int highestScore) {
			this.highestScore = highestScore;
		}

		public Country getCountry() {
			return country;
		}

		@Override
		public String toString() {
			return "Player [playerName=" + playerName + ", matchesPlayed=" + matchesPlayed + ", runs=" + runs
					+ ", highestScore=" + highestScore + ", country=" + country + "]";
		}




		
}
