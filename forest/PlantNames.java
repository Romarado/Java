package my.code.forest;

import java.util.Random;

public enum PlantNames {
	
	Asoka("Asoka"), Baobab("Baobab"), Sequoia("Sequoia");
	private static PlantNames[] names = PlantNames.values();	
	private static Random random = new Random();
	private final String name;
	PlantNames(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	final static String random() {
		return names[random.nextInt(names.length)].getName();
	}
}
