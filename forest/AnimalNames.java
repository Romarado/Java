package my.code.forest;

import java.util.Random;



public enum AnimalNames {
	
	Lion("Lion"), Zebra("Zebra"), Zhakal("Zhakal"), Rabbit("Rabbit"), Elephant("Elephant"), Tiger("Tiger");
	private static AnimalNames[] names = AnimalNames.values();	
	private static Random random = new Random();
	private final String name;
	
	AnimalNames(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	final static String random() {
		return names[random.nextInt(names.length)].getName();
	}
}
