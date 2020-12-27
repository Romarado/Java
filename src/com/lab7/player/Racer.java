/**
 * 
 */
package com.lab7.player;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.lab7.gamemanager.GameManager;

/**
 * @author alexandr
 *
 */
public class Racer extends JButton implements Runnable{
	private static final long serialVersionUID = 1L; // Чтобы не было warning-a
	private static int numOfRacers = 0;

	int pathLen;
	int speed;
	int xPos = 0;
	int yPos = 0;
	
	
	GameManager gm;

	Boolean isRunning = false;

	public Racer(GameManager gm, int pathLen) {
		super("Button " + (++numOfRacers));
		this.gm = gm;
		this.pathLen = pathLen-110;
		this.setBounds(0,0, 110, 40);
		this.addActionListener(new ResetListener());
		Reset();
	}

	public void SetStartPosition(int x, int y) {
		xPos = x;
		yPos = y;
	}

	public void SetPosition(int x, int y) {
		this.setBounds(x, y, this.getBounds().width, this.getBounds().height);
		System.out.println(this.getText() + " set pos: " + x + " " + y + " | " + this.getBounds().x + " " + this.getBounds().y);
	}

	public void Reset() {
		System.out.println(this.getText() + "reset");
		isRunning = false;
		this.speed = 1 + (int)(Math.random()*10);
		this.setBackground(Color.WHITE);
		this.setBounds(xPos, yPos, this.getBounds().width, this.getBounds().height);
	}
	
	public void Activate() {
		isRunning = true;
	}
	
	public void Deactivate() {
		isRunning = false;
	}
	
	class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			synchronized (this) {
				Reset();
				Activate();				
			}
		}
	}
	
	@Override
	public void run() {
		while(gm.getStatus()) {
			if (!isRunning)
				continue;
			System.out.println(this.getText() + " pos: " + this.getBounds().x + " " + this.getBounds().y + " speed:" + speed);
			synchronized (this) {
				SetPosition(this.getBounds().x + speed, yPos);
				if (this.getBounds().x >= xPos + pathLen) {
					this.setBackground(Color.BLUE);
					gm.OnFinish();
					break;
				}				
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
