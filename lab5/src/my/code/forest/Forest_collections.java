package my.code.forest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import my.code.forest.Forest.Animal_type;
import my.code.forest.Forest.Plant_type;
import my.code.forest.Plant.Sort;

public abstract class Forest_collections {
	private static ArrayList<Forest> Forests_ArrayList = new ArrayList<Forest>();
	private static LinkedList<Forest> Forests_LinkedList = new LinkedList<Forest>();
	
	private static Forest randomForest() {
		Forest forest = new Forest();
		for(int i=0; i<10; i++) {
			Animal animal = new Animal(Animal_type.random(), randomInt(60,900), AnimalNames.random());
			forest.addAnimal(animal);
			
			Plant plant = new Plant(Plant_type.random(), Sort.random(), PlantNames.random());
			forest.addPlant(plant);
		}
		return forest;
	}
	protected static int randomInt(int min, int max) {
		int randValue;
		Random random = new Random();
		randValue = random.nextInt(max-min) + min;
		return randValue;
		
	}
	public static ArrayList<Float> addToArray(int number, msgLogging msg) {
		Timer timer = new Timer();
		msg.addLog("***********LOGGING *************");
		for(int i = 0; i<number; i++)
		{	
			Forest forest = randomForest();
			timer.startIter();
			Forests_ArrayList.add(forest);
			msg.addLog("Add, ID: " + i + ", time:" + (float)timer.iterTime()*100000000);
		}
		msg.addLog("Total time: " + timer.totalTime());
		msg.addLog("Average time: " + timer.totalTime()/number);
		
		ArrayList<Float> ret = new ArrayList<>(2);
		
		ret.add((float)timer.totalTime());
		ret.add((float)timer.totalTime()/number);
		return ret;
		
		
	}
	public static ArrayList<Float> removeFromArray(int number, msgLogging msg) {
		int startID = randomInt(0, Forests_ArrayList.size()-1-number);
		Timer timer = new Timer();
		msg.addLog("***********LOGGING *************");
		for(int i = startID; i< startID + number; i++) {
			
			Forests_ArrayList.remove(i);
			msg.addLog("Remove, ID: " + i + ", time:" + timer.iterTime());
		}
		msg.addLog("Total time: " + timer.totalTime());
		msg.addLog("Average time: " + timer.totalTime()/number);
		
		ArrayList<Float> ret = new ArrayList<>(2);
		
		ret.add((float)timer.totalTime());
		ret.add((float)timer.totalTime()/number);
		return ret;
	}
	
	public static ArrayList<Float> addToLinked(int number, msgLogging msg) {
		Timer timer = new Timer();
		msg.addLog("***********LOGGING *************");
		for(int i = 0; i<number; i++)
		{	Forest forest = randomForest();
			timer.startIter();
			Forests_LinkedList.add(forest);
			msg.addLog("Add, ID: " + i + ", time:" + timer.iterTime());
		}
		msg.addLog("Total time: " + timer.totalTime());
		msg.addLog("Average time: " + timer.totalTime()/number);
		ArrayList<Float> ret = new ArrayList<>(2);
		
		ret.add((float)timer.totalTime());
		ret.add((float)timer.totalTime()/number);
		return ret;
	}
	public static ArrayList<Float> removeFromLinked(int number, msgLogging msg) {
		int startID = randomInt(0, Forests_ArrayList.size()-1-number);
		Timer timer = new Timer();
		msg.addLog("***********LOGGING *************");
		for(int i = startID; i< startID + number; i++) {
			timer.startIter();
			
			Forests_LinkedList.remove(i);
			msg.addLog("Remove, ID: " + i + ", time:" + timer.iterTime());
		}
		msg.addLog("Total time: " + timer.totalTime());
		msg.addLog("Average time: " + timer.totalTime()/number);
		ArrayList<Float> ret = new ArrayList<>(2);
		
		ret.add((float)timer.totalTime());
		ret.add((float)timer.totalTime()/number);
		return ret;
	}
	public static void showArrayList() {
		System.out.println(Forests_ArrayList);
	}
	public static void showLinkedList() {
		System.out.println(Forests_LinkedList);
	}
	
}
