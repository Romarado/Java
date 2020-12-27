/**
 * 
 */
package com.lab7.buttonrace;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import com.lab7.gamemanager.GameManager;
import com.lab7.player.Racer;

/**
 * @author alexandr
 *
 */
public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L; // Чтобы не было warning-a

	String appName = "Button Race";

	JFrame frame;
	int raceWidth;
	JButton stopButton;
	JButton startButton;

	JScrollPane pane;
	JPanel mainPanel;

	Timer updateTimer;

	JTextArea textArea;
	JScrollPane textScrollPane;

	ArrayList<Racer> racerButtons;
	int numOfRacers;
	GameManager gm;

	public GameFrame(GameManager gameManager, int width) {
		raceWidth = width;
		gm = gameManager;

		frame = new JFrame(appName);
//		frame.setLayout(new BorderLayout());
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gm.Quit();
				System.exit(0);
			}
		});
		frame.setSize(raceWidth + 5, 600);
		frame.setResizable(false);

		stopButton = new JButton("Stop");
		StopListener stopBtnL = new StopListener();
		stopButton.addActionListener(stopBtnL);
		stopButton.setBounds(400+10, 15, 100, 40);
		frame.add(stopButton);

		startButton = new JButton("Start");
		StartListener startBtnL = new StartListener();
		startButton.addActionListener(startBtnL);
		startButton.setBounds(400 + 10 - 100, 15, 100, 40);
		frame.add(startButton);

		mainPanel = new JPanel();
		pane = new JScrollPane(mainPanel);
		frame.add(pane);
		pane.setBounds(1, 70, raceWidth + 10, 600 - 70 - 28);
		pane.setBackground(Color.GRAY);
		mainPanel.setLayout(null);

		racerButtons = new ArrayList<Racer>();
		numOfRacers = 0;

//		mainPanel.setPreferredSize(new Dimension(mainPanel.getSize().width-1, 0));

		frame.setVisible(true);
	}

	public void addRacer(Racer... rs) {
		for (Racer r : rs) {
			racerButtons.add(r);
			r.SetStartPosition(5, 5 + 45 * numOfRacers);
			r.Reset();
			mainPanel.add((JButton) r);
			numOfRacers++;
		}

	}

	public void updateWindow() {
		mainPanel.setPreferredSize(new Dimension(mainPanel.getBounds().x, 5 + numOfRacers * 45));
		mainPanel.setSize(new Dimension(mainPanel.getBounds().x, 5 + numOfRacers * 45));
		frame.setSize(raceWidth + 20, 600);
	}
	
	public void OnFinish() {
		stopButton.setText("ResetAll");
		isPaused = true;
		isStopped = true;
		startButton.setText("Continue");
	}

	Boolean isStopped = true;
	Boolean isPaused = false;

	class StopListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("stop button");
			
			if (!isStopped && !isPaused) {
				gm.OnStop();
				stopButton.setText("ResetAll");
				startButton.setText("Resume");
				isPaused=true;
				
			} else if (isPaused) {
				gm.OnRestAll();
				stopButton.setText("Pause");
				startButton.setText("Start");
				isStopped = true;				
			}
		}
	}

	class StartListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("start button");
			if (isStopped || isPaused) {
				gm.OnStart();
				stopButton.setText("Pause");
				startButton.setText("Start");
				isStopped = false;
				isPaused = false;
			}
		}
	}

}
