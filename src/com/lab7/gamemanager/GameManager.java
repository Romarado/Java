/**
 * 
 */
package com.lab7.gamemanager;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.lab7.buttonrace.GameFrame;
import com.lab7.player.Racer;


/**
 * @author alexandr
 *
 */
public class GameManager {
	GameFrame gf;
	ArrayList<Racer> rs= new ArrayList<Racer>();
	ArrayList<Thread> thrs= new ArrayList<Thread>();
	Boolean status = true;
	
	public GameManager() {
		gf = new GameFrame(this, 800);
		for (int i =0; i < 10; i++) {
			Racer r = new Racer(this, 800);
			Thread th = new Thread(r);
			thrs.add(th);
			th.start();
			rs.add(r);
			gf.addRacer(r);
		}
		gf.updateWindow();
	}
	
	public synchronized void OnFinish() {
		gf.OnFinish();
		OnStop();
	}
	
	public synchronized void OnStop() {
		for (Racer r: rs) {
			synchronized (r) {
				r.Deactivate();
//			r.Reset();				
			}
		}
	}
	
	public synchronized void OnStart() {
		for (Racer r: rs) {
			synchronized (r) {
				r.Activate();				
			}
		}
	}
	
	public synchronized void OnRestAll() {
		for (Racer r: rs) {
			synchronized (r) {
				r.Reset();				
			}
		}
	}
	
	public void Quit() {
		synchronized (status) {
			status = false;
		}
		for (Thread t : thrs) {
			t.interrupt();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("All threads finished!");
	}
	
	public synchronized Boolean getStatus() {
		/*atomic*/ return status;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GameManager gm = new GameManager();
	}
}
