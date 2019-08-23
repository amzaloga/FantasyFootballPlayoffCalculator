package calculatorPlayoff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRight extends JPanel {

	private int y = 1;
	JLabel placeNum, place;
	JTextField[] teamName = new JTextField[12];
	JTextField[] wins = new JTextField[12];
	JTextField[] loses = new JTextField[12];
	JTextField[] pointsForced = new JTextField[12];
	JButton updateStandings = new JButton("Update Standings");

	public PanelRight() {
		JPanel panelRight = new JPanel();

		GridLayout gridTest = new GridLayout(14, 5, 10, 15);
		panelRight.setLayout(gridTest);
		
		DBConnectionLayerOriginalStandings standings = new DBConnectionLayerOriginalStandings();
		String[] team = standings.pushTeams();
		String[] win = standings.pushWins();
		String[] lose = standings.pushLoses();
		String[] pf = standings.pushPF();

		panelRight.add(place = new JLabel("Place"));
		place.setHorizontalAlignment(JLabel.RIGHT);
		panelRight.add(new JLabel("Team Name"));
		panelRight.add(new JLabel("Wins"));
		panelRight.add(new JLabel("Loses"));
		panelRight.add(new JLabel("PF"));

		for (int i = 0; i < 12; i++) {
			panelRight.add(placeNum = new JLabel(Integer.toString(y)));
			placeNum.setHorizontalAlignment(JLabel.RIGHT);
			panelRight.add(teamName[i] = new JTextField(team[i]));
			panelRight.add(wins[i] = new JTextField(win[i]));
			panelRight.add(loses[i] = new JTextField(lose[i]));
			panelRight.add(pointsForced[i] = new JTextField(pf[i]));
			y++;
		}

		panelRight.add(new JLabel());
		panelRight.add(updateStandings);

		updateStandings.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DBConnLayerPushTempDB update = new DBConnLayerPushTempDB();
				String[] updatedName = update.updateTeamName();
				String[] updateWins = update.updateWin();
				String[] updateLoses = update.updateLose();
				String[] updatePF = update.updatePF();
				for(int i = 0; i < 12; i++) {
					teamName[i].setText(updatedName[i]);
					wins[i].setText(updateWins[i]);
					loses[i].setText(updateLoses[i]);
					pointsForced[i].setText(updatePF[i]);
				}
			
			}

		});

		add(panelRight);

	}

}
