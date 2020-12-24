package my.code.forest;

import java.io.IOException;

import my.code.forest.Forest.Animal_type;
import my.code.forest.Forest.Plant_type;
import my.code.forest.Plant.Sort;
import my.code.forest.Forest_collections;

public class Main {

	public static void main(String[] args) {
		
		Forest tandle = new Forest();
		Animal lion = new Animal(Animal_type.PREDATOR, 200, "lion");
		tandle.addAnimal(lion);
		Animal shakal = new Animal(Animal_type.PREDATOR, 50, "shakal");
		tandle.addAnimal(shakal);
		Animal zebra = new Animal(Animal_type.HERBIVOROUS, 330, "zebra");
		tandle.addAnimal(zebra);
		tandle.showAnimals();
		Plant Asoka = new Plant(Plant_type.GRASS, Sort.KIND1, "Asoka");
		tandle.addPlant(Asoka);
		Plant Baobab = new Plant(Plant_type.TREE, Sort.KIND2, "Baobab");
		tandle.addPlant(Baobab);
		
		tandle.showPlants();
		
		lion.findFood(tandle);
		tandle.showAnimals();
		
		zebra.findFood(tandle);
		tandle.showPlants();
		
		msgLogging msg = new msgLogging();
		
		
		Forest_collections.addToArray(1000, msg);		
		Forest_collections.removeFromArray(100, msg);
		
		
		Forest_collections.addToLinked(1000, msg);
		Forest_collections.removeFromLinked(100, msg);
		
	}

}
