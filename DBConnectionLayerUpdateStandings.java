package calculatorPlayoff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Hashtable;

public class DBConnectionLayerUpdateStandings {
	String[] homeTeam = new String[6];
	int[] homeScore = new int[6];
	String[] awayTeam = new String[6];
	int[] awayScore = new int[6];
	String getHomeTeam, getAwayTeam;
	int getHomeScore, getAwayScore;
	Hashtable<String, Integer> backDB = new Hashtable<String, Integer>();
	DBConnectionLayerOpenConnection winnerOpenConn = new DBConnectionLayerOpenConnection();
	DBConnectionLayerOpenConnection loserOpenConn = new DBConnectionLayerOpenConnection();
	DBConnectionLayerOpenConnection openConn = new DBConnectionLayerOpenConnection();

	public String[] UpdateTempTeamStandings(String[] homeTeam, int[] homeScore, String[] awayTeam, int[] awayScore) {

		backDB.put("GBE Dope Boys", 1);
		backDB.put("Hebrew Hamburgers", 2);
		backDB.put("SuckMySmitDoc", 3);
		backDB.put("SCLSU Muddogs", 4);
		backDB.put("Fair Lawn Fat Bastards", 5);
		backDB.put("Johnny 8 Ball", 6);
		backDB.put("Alberto Z", 7);
		backDB.put("Kaepernick Lives Matter", 8);
		backDB.put("A Mazzella", 9);
		backDB.put("Belligerent Boomers", 10);
		backDB.put("Team Zaloga", 11);
		backDB.put("A Jay of Green", 12);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ffc?user=root&password=Football31*");
			Statement query = conn.createStatement();

			// add the query to update the points forced and points allowed
			for (int i = 0; i < 6; i++) {
				if (homeScore[i] > awayScore[i]) {
					int loser = backDB.get(awayTeam[i]);
					int winner = backDB.get(homeTeam[i]);

					query.executeUpdate("Update tempStandings Set wins = wins + 1, pointsForced = pointsForced + "
							+ String.valueOf(homeScore[i]) + ", pointsAllowed = pointsAllowed + "
							+ String.valueOf(awayScore[i]) + " Where teamID = " + String.valueOf(winner));

					query.executeUpdate("Update tempStandings Set loses = loses  + 1, pointsForced = pointsForced + "
							+ String.valueOf(awayScore[i]) + ", pointsAllowed = pointsAllowed + "
							+ String.valueOf(homeScore[i]) + " Where teamID = " + String.valueOf(loser));
				} else if (awayScore[i] > homeScore[i]) {
					int loser = backDB.get(homeTeam[i]);
					int winner = backDB.get(awayTeam[i]);
					query.executeUpdate("Update tempStandings Set wins = wins + 1, pointsForced = pointsForced + "
							+ String.valueOf(awayScore[i]) + ", pointsAllowed = pointsAllowed + "
							+ String.valueOf(homeScore[i]) + " Where teamID = " + String.valueOf(winner));
					query.executeUpdate("Update tempStandings Set loses = loses + 1, pointsForced = pointsForced + "
							+ String.valueOf(homeScore[i]) + ", pointsAllowed = pointsAllowed + "
							+ String.valueOf(awayScore[i]) + " Where teamID = " + String.valueOf(loser));
				}
			}

		} catch (Exception x) {
			System.out.println(x);
		}
		return null;
	}

	public String resetTempStandings() {

		try {

			for (int i = 0; i < 12; i++) {
				openConn.updateQuery(
						"update tempStandings set wins = 0, loses = 0, pointsForced = 0, pointsAllowed = 0 where teamID = "
								+ String.valueOf(i + 1));
			}
		} catch (Exception d) {
			System.out.println(d);
		}
		return null;
	}

}
