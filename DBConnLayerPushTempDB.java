package calculatorPlayoff;

public class DBConnLayerPushTempDB {

	public String[] teamName = new String[12];
	public String[] wins = new String[12];
	public String[] loses = new String[12];
	public String[] pointsForced = new String[12];
	public String[] pointsAllowed = new String[12];
	public String team1, wins1, loses1, pointsForced1, pointsAllowed1;
	static DBConnectionLayerOpenConnection openConn = new DBConnectionLayerOpenConnection();
	
	public static void query() {
		openConn.openConnection(
				"select s.teamName, sum(s.wins + t.wins) as totalWins, "
				+ "sum(s.loses + t.loses) as totalLoses, "
				+ "sum(s.pointsForced + t.pointsForced) as totalPF"
				+ " from standings s inner join tempStandings t on s.teamName = t.teamName group by s.teamName order by totalWins desc, totalPF desc;");
	}

	public String[] updateTeamName() {
		try {
			DBConnLayerPushTempDB.query();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				team1 = openConn.rs.getString(1);
				teamName[i] = team1;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return teamName;
	}

	public String[] updateWin() {
		try {
			openConn.rs.beforeFirst();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				wins1 = openConn.rs.getString(2);
				wins[i] = wins1;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return wins;
	}

	public String[] updateLose() {
		try {
			openConn.rs.beforeFirst();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				loses1 = openConn.rs.getString(3);
				loses[i] = loses1;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return loses;
	}

	public String[] updatePF() {
		try {
			openConn.rs.beforeFirst();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				pointsForced1 = openConn.rs.getString(4);
				pointsForced[i] = pointsForced1;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return pointsForced;
	}

	public String[] updatePA() {

		return pointsAllowed;
	}

}
