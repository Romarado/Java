package my.code.forest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import my.code.forest.Plant.Sort;

public class Forest {
	
	enum Animal_type { PREDATOR, HERBIVOROUS, NONE;
		private static Animal_type[] types = Animal_type.values();	
		private static Random random = new Random();
		final static Animal_type random() {
			return types[random.nextInt(types.length)];
		}
	};
	
	protected Animal_type animal;
	enum Plant_type { TREE, GRASS, NONE;
		private static Plant_type[] types = Plant_type.values();	
		private static Random random = new Random();
		final static Plant_type random() {
			return types[random.nextInt(types.length)];
		}
	};
	protected Plant_type plant;
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	private ArrayList<Plant> plants = new ArrayList<Plant>();
	
	Forest(){
		
	}
	Forest(Animal_type type){
		animal = type;
	}
	Forest(Plant_type type){
		plant = type;
	}
	void addAnimal(Animal animal) {
		animals.add(animal);
	}
	
	void addPlant(Plant plant) {
		plants.add(plant);
	}
	public  ArrayList<Animal> getAnimals() {
		return animals;
	}
	public ArrayList<Plant> getPlants() {
		return plants;
	}
	public void showAnimals() {
		System.out.println(animals);
	}
	public void showPlants() {
		System.out.println(plants);
	}
	
	
	protected void eatAnimal(String name, int size, Forest forest) {
		
		for(Animal animal : forest.getAnimals()) {
			if (animal.name != name && animal.size < size) {
				System.out.println(name + " סתוכ " + animal.name);
				forest.animals.remove(forest.animals.indexOf(animal));
				break;
			}
		}
	}
	protected void eatPlant(String name,  Forest forest) {
		for(Plant plant : forest.getPlants()) {
			System.out.println(name + " סתוכ " + plant.name);
			forest.plants.remove(forest.plants.indexOf(plant));
			break;
		}
	}
	
}
