package my.code.forest;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

import my.code.forest.Forest.Animal_type;
import my.code.forest.Forest.Plant_type;
import my.code.forest.Plant.Sort;
import my.code.forest.Forest_collections;

public class Main {

	public static void main(String[] args)
	{
	EventQueue.invokeLater(new Runnable()
		{
		public void run()
		{
			msgLogging msg = new msgLogging();
			// общее врем€ дл€ arrayList
			ArrayList<Float> totalList = new ArrayList<>();	
			totalList.add(0F);
			totalList.add(Forest_collections.addToArray(10, msg).get(0));
			totalList.add(Forest_collections.addToArray(100, msg).get(0));
			totalList.add(Forest_collections.addToArray(1000, msg).get(0));
			totalList.add(Forest_collections.addToArray(10000, msg).get(0));
			Forest_collections.addToLinked(10, msg);
			// общее врем€ дл€ linkedList	
			
			ArrayList<Float> totalLinked = new ArrayList<>();	
			totalLinked.add(0F);
			totalLinked.add(Forest_collections.addToLinked(10, msg).get(0));
			totalLinked.add(Forest_collections.addToLinked(100, msg).get(0));
			totalLinked.add(Forest_collections.addToLinked(1000, msg).get(0));
			totalLinked.add(Forest_collections.addToLinked(10000, msg).get(0));	
			
			DrawFrame frameTotal = new DrawFrame(totalList, totalLinked, "Arraylist", "LinkedList", new Color(0, 255, 0),new Color(255, 0, 0));
			
			frameTotal.setTitle("ќбщее врем€ добавлени€");
			frameTotal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameTotal.setVisible(true);
			
			
			// среднее врем€ дл€ arrayList
			ArrayList<Float> averageList = new ArrayList<>();	
			averageList.add(0F);
			averageList.add(Forest_collections.addToArray(10, msg).get(1));
			averageList.add(Forest_collections.addToArray(100, msg).get(1));
			averageList.add(Forest_collections.addToArray(1000, msg).get(1));
			averageList.add(Forest_collections.addToArray(10000, msg).get(1));
			// среднее врем€ дл€ Linked
			ArrayList<Float> averageLinked = new ArrayList<>();	
			averageLinked.add(0F);
			averageLinked.add(Forest_collections.addToLinked(10, msg).get(1));
			averageLinked.add(Forest_collections.addToLinked(100, msg).get(1));
			averageLinked.add(Forest_collections.addToLinked(1000, msg).get(1));
			averageLinked.add(Forest_collections.addToLinked(10000, msg).get(1));	
			
			
			DrawFrame frameAverage = new DrawFrame(averageList, averageLinked, "Arraylist", "LinkedList", new Color(0, 255, 0),new Color(255, 0, 0));
			
			frameAverage.setTitle("—реднее врем€ добавлени€");
			
			frameAverage.setVisible(true);
			
			//общее врем€ удалени€
			ArrayList<Float> removeTotalList = new ArrayList<>();	
			removeTotalList.add(0F);
			removeTotalList.add(Forest_collections.removeFromArray(1, msg).get(0));
			removeTotalList.add(Forest_collections.removeFromArray(10, msg).get(0));
			removeTotalList.add(Forest_collections.removeFromArray(100, msg).get(0));
			removeTotalList.add(Forest_collections.removeFromArray(1000, msg).get(0));
			
			ArrayList<Float> removeTotalLinked = new ArrayList<>();	
			removeTotalLinked.add(0F);
			removeTotalLinked.add(Forest_collections.removeFromLinked(1, msg).get(0));
			removeTotalLinked.add(Forest_collections.removeFromLinked(10, msg).get(0));
			removeTotalLinked.add(Forest_collections.removeFromLinked(100, msg).get(0));
			removeTotalLinked.add(Forest_collections.removeFromLinked(1000, msg).get(0));	
			
			
			DrawFrame frameTotalRemove = new DrawFrame(removeTotalList, removeTotalLinked, "Arraylist", "LinkedList", new Color(0, 255, 0),new Color(255, 0, 0));
			
			frameTotalRemove.setTitle("ќбщее врем€ удалени€");
			
			frameTotalRemove.setVisible(true);
			
			
			//среднее врем€ удалени€
			ArrayList<Float> removeAverageList = new ArrayList<>();	
			removeAverageList.add(0F);
			removeAverageList.add(Forest_collections.removeFromArray(1, msg).get(1));
			removeAverageList.add(Forest_collections.removeFromArray(10, msg).get(1));
			removeAverageList.add(Forest_collections.removeFromArray(100, msg).get(1));
			removeAverageList.add(Forest_collections.removeFromArray(1000, msg).get(1));
			
			ArrayList<Float> removeAverageLinked = new ArrayList<>();	
			removeAverageLinked.add(0F);
			removeAverageLinked.add(Forest_collections.removeFromLinked(1, msg).get(1));
			removeAverageLinked.add(Forest_collections.removeFromLinked(10, msg).get(1));
			removeAverageLinked.add(Forest_collections.removeFromLinked(100, msg).get(1));
			removeAverageLinked.add(Forest_collections.removeFromLinked(1000, msg).get(1));	
			
			
			DrawFrame frameAverageRemove = new DrawFrame(removeAverageLinked,removeAverageList, "LinkedList", "Arraylist",
					new Color(255, 0, 0), new Color(0, 255, 0));
			
			frameAverageRemove.setTitle("—реднее врем€ удалени€");
			
			frameAverageRemove.setVisible(true);
			
			
			
			
			Forest_collections.removeFromLinked(1, msg);
		}
		}
	);
	}
}

