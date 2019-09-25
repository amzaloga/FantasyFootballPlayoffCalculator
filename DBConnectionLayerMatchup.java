package calculatorPlayoff;

import java.util.Hashtable;
//I was here again

public class DBConnectionLayerMatchup {
	public String homeTeamName;
	String awayTeamName;
	String[] homeTeam = new String[6];
	String[] awayTeam = new String[6];
	Hashtable<Integer, String> names = new Hashtable<Integer, String>();
	int n, m;
	DBConnectionLayerOpenConnection openConn = new DBConnectionLayerOpenConnection();

	public String[] DBConnectionLayerHomeTeam(int n) {
		this.n = n;

		names.put(1, "GBE Dope Boys");
		names.put(2, "Hebrew Hamburgers");
		names.put(3, "SuckMySmitDoc");
		names.put(4, "SCLSU Muddogs");
		names.put(5, "Fair Lawn Fat Bastards");
		names.put(6, "Johnny 8 Ball");
		names.put(7, "Alberto Z");
		names.put(8, "Kaepernick Lives Matter");
		names.put(9, "A Mazzella");
		names.put(10, "Belligerent Boomers");
		names.put(11, "Team Zaloga");
		names.put(12, "A Jay of Green");

		openConn.openConnection("Select teamA from matchups where week=" + (n + 1));

		for (int i = 0; i < 6; i++) {
			try {
				openConn.rs.next();
				int result = Integer.parseInt(openConn.rs.getString(1));
				homeTeamName = names.get(result);
				homeTeam[i] = homeTeamName;

			} catch (Exception x) {
				System.out.println(x);
			}
		}
		return homeTeam;
	}

	public String[] DBConnectionLayerAwayTeam(int n) {
		this.n = n;

		names.put(1, "GBE Dope Boys");
		names.put(2, "Hebrew Hamburgers");
		names.put(3, "SuckMySmitDoc");
		names.put(4, "SCLSU Muddogs");
		names.put(5, "Fair Lawn Fat Bastards");
		names.put(6, "Johnny 8 Ball");
		names.put(7, "Alberto Z");
		names.put(8, "Kaepernick Lives Matter");
		names.put(9, "A Mazzella");
		names.put(10, "Belligerent Boomers");
		names.put(11, "Team Zaloga");
		names.put(12, "A Jay of Green");

		openConn.openConnection("Select teamB from matchups where week=" + (n + 1));

		for (int i = 0; i < 6; i++) {
			try {

				openConn.rs.next();
				int result = Integer.parseInt(openConn.rs.getString(1));
				awayTeamName = names.get(result);
				awayTeam[i] = awayTeamName;

			} catch (Exception x) {
				System.out.println(x);
			}
		}
		return awayTeam;
	}
}
