package calculatorPlayoff;

public class DBConnectionLayerOriginalStandings {
	
	String[] teams = new String[12];
	String[] wins = new String[12];
	String[] loses = new String[12];
	String[] pointsForced = new String[12];
	String[] pointsAllowed = new String[12];
	String team, win, lose, pf, pa;
	static DBConnectionLayerOpenConnection openConn = new DBConnectionLayerOpenConnection();
	
	public static void getQuery() {
		openConn.openConnection("Select * from standings order by wins DESC, pointsForced desc");
	}
	
	public String[] pushTeams() {
		try {
			DBConnectionLayerOriginalStandings.getQuery();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				team = openConn.rs.getString(2);
				teams[i] = team;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return teams;
	}
	
	public String[] pushWins() {
		try {
			openConn.rs.beforeFirst();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				win = openConn.rs.getString(3);
				wins[i] = win;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return wins;
	}
	
	public String[] pushLoses() {
		try {
			openConn.rs.beforeFirst();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				lose = openConn.rs.getString(4);
				loses[i] = lose;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return loses;
	}
	
	public String[] pushPF() {
		try {
			openConn.rs.beforeFirst();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				pf = openConn.rs.getString(5);
				pointsForced[i] = pf;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return pointsForced;
	}
	
	public String[] pushPA() {
		try {
			openConn.rs.beforeFirst();
			for (int i = 0; i < 12; i++) {
				openConn.rs.next();
				pa = openConn.rs.getString(6);
				pointsAllowed[i] = pa;
			}
		} catch (Exception e) {
			System.out.println("Messege " + e.getMessage());
		}
		return pointsAllowed;
	}

}
