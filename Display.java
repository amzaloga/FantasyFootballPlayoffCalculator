package calculatorPlayoff;

import javax.swing.*;
import java.awt.*;

public class Display {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fantasy Football Playoff Calculator");
		frame.setSize(1500, 650);
		GridLayout gridTest = new GridLayout(0, 2);
		frame.setLayout(gridTest);

		PanelLeft leftPanel = new PanelLeft();
		PanelRight rightPanel = new PanelRight();

		frame.add(leftPanel);
		frame.add(rightPanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
