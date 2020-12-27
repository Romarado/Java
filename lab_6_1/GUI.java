package lab_6_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
	private JTextField input = new JTextField("", 5);
	private JLabel label = new JLabel("Enter the text:");
	private JLabel labelun = new JLabel("Begin entering!");
	public int k = 0;
	static boolean press = false;

	public GUI() {
		super("Measuring print speed");
		setResizable(false);  
		this.setBounds(500, 100, 500, 500);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3, 2, 2, 2));
		container.add(label);
		container.add(input);
		container.add(labelun);

		input.addKeyListener(new KeyAdapter() {
			Timer timer = new Timer(1000, new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					System.out.println();
					labelun.setText((int)(k*60/(tAll/1000)) + " chars per min");
				}
			});

			double time = 0;
			double time1 = 0;
			double tAll = 0;
			
			public void keyReleased(KeyEvent e) {
				timer.start();
				time = System.currentTimeMillis(); // засекаем время
                time1 = System.currentTimeMillis() - time1;
                if (time1>60000)
					time1 = 100;
				k += 1;
				press = true;
				tAll += time1;
			}

			public void keyPressed(KeyEvent e) {
				if (press) {
					time = System.currentTimeMillis() - time;// находим его
					if (time>60000)
						time = 100;
					System.out.println(time );
					time1 = System.currentTimeMillis(); // засекаем время
					tAll += time;
				}
			}
		});

	}
}