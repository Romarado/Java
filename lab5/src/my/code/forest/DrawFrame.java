package my.code.forest;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import my.code.forest.GrafDataTitle;


/**
 * A frame that contains a panel with drawings
 */
class DrawFrame extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawFrame() {
		
		//Формируем заголовок-описание графика
		GrafDataTitle GTitle = new GrafDataTitle("Проверка", "", 0, 0, 0, 0, "ед", "нс");
		
		//Формируем данные для построения графика
		ArrayList <Float> X = new ArrayList();
		X.add(0F);
		X.add(10F);
		X.add(100F);
		X.add(1000F);
		X.add(10000F);

		ArrayList <Float> Y = new ArrayList();
		Y.add(0F);
		Y.add(2F);
		Y.add(4F);
		Y.add(9F);
		Y.add(16F);	
						
		DrawGraf DG = new DrawGraf(new GrafData(GTitle, X, Y), true, false, new Color(255, 0, 0));
		add(DG);
		pack();
	}
	
	public DrawFrame(ArrayList<Float> total, ArrayList<Float> average, String title1,String title2, Color color1, Color color2){
		//Формируем заголовок-описание графика
				GrafDataTitle GTitle1 = new GrafDataTitle(title1, "", 0, 0, 0, 0, "ед", "нс");
				GrafDataTitle GTitle2 = new GrafDataTitle(title2, "", 0, 0, 0, 0, "ед", "нс");
				//Формируем данные для построения графика
				ArrayList <Float> X = new ArrayList();
				X.add(0F);
				X.add(10F);
				X.add(100F);
				X.add(1000F);
				X.add(10000F);
				
				ArrayList <Float> Y = new ArrayList();
				Y.add(0F);
				Y.add(2F);
				Y.add(4F);
				
							
				DrawGraf DG2 = new DrawGraf(new GrafData(GTitle2, X, average), true, false, color2);
				add(DG2);
				pack();
				DrawGraf DG1 = new DrawGraf(new GrafData(GTitle1, X, total), true, false,  color1);
				add(DG1);
				pack();
				
	}

}
