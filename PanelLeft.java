package calculatorPlayoff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelLeft extends JPanel {

	JComboBox<String> comboWeek;
	JLabel vs;
	JButton calculate, reset;
	private String[] matchup = new String[] { "Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7",
			"Week 8", "Week 9", "Week 10", "Week 11", "Week 12", "Week 13" };
	private JTextField[] homeTeam = new JTextField[6];
	private JTextField[] awayTeam = new JTextField[6];
	public JTextField[] homeScore = new JTextField[6];
	private JTextField[] awayScore = new JTextField[6];

	public PanelLeft() {
		JPanel panelLeft = new JPanel();

		GridLayout gridTest = new GridLayout(0, 5, 10, 10);
		panelLeft.setLayout(gridTest);

		panelLeft.add(comboWeek = new JComboBox<String>(matchup));
		panelLeft.add(vs = new JLabel());
		panelLeft.add(vs = new JLabel());
		panelLeft.add(vs = new JLabel());
		panelLeft.add(vs = new JLabel());

		DBConnectionLayerMatchup matchupClass = new DBConnectionLayerMatchup();

		matchupClass.n = comboWeek.getSelectedIndex();

		String[] homeTeamName = matchupClass.DBConnectionLayerHomeTeam(matchupClass.n);
		String[] awayTeamName = matchupClass.DBConnectionLayerAwayTeam(matchupClass.n);

		for (int i = 0; i < 6; i++) {
			panelLeft.add(homeTeam[i] = new JTextField(homeTeamName[i]));
			panelLeft.add(homeScore[i] = new JTextField());
			panelLeft.add(vs = new JLabel("vs"));
			vs.setHorizontalAlignment(JLabel.CENTER);
			panelLeft.add(awayScore[i] = new JTextField());
			panelLeft.add(awayTeam[i] = new JTextField(awayTeamName[i]));
		}
		

		comboWeek.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				DBConnectionLayerMatchup matchupClass = new DBConnectionLayerMatchup();
				matchupClass.n = comboWeek.getSelectedIndex();
				String[] homeTeamName1 = matchupClass.DBConnectionLayerHomeTeam(matchupClass.n);
				String[] awayTeamName1 = matchupClass.DBConnectionLayerAwayTeam(matchupClass.n);

				for (int i = 0; i < 6; i++) {
					homeTeam[i].setText(homeTeamName1[i]);
					awayTeam[i].setText(awayTeamName1[i]);
				}
			}
		});

		panelLeft.add(calculate = new JButton("Calculate"));
		panelLeft.add(reset = new JButton("Reset"));

		calculate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DBConnectionLayerUpdateStandings tester = new DBConnectionLayerUpdateStandings();
				String[] homeTeamDB = new String[6];
				int[] homeScoreDB = new int[6];
				String[] awayTeamDB = new String[6];
				int[] awayScoreDB = new int[6];
				
				for(int i = 0; i < 6; i++) {
					homeTeamDB[i] = homeTeam[i].getText();
					homeScoreDB[i] = Integer.parseInt(homeScore[i].getText());
					awayTeamDB[i] = awayTeam[i].getText();
					awayScoreDB[i] = Integer.parseInt(awayScore[i].getText());
				}
				tester.UpdateTempTeamStandings(homeTeamDB, homeScoreDB, awayTeamDB, awayScoreDB);
			}
			
		});
		
		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				DBConnectionLayerUpdateStandings tester = new DBConnectionLayerUpdateStandings();
				tester.resetTempStandings();
			}
			
		});

		add(panelLeft);

	}
}
