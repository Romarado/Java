package my.code.forest;

public class Animal extends Forest{
	
	
	int size;
	String name;
		
	Animal(Animal_type type, int size, String name){
		super(type);
		this.size = size;
		this.name = name;
	}
	
	public String toString() {
		return super.animal + " " + name + " " + size;
	}
	
	public void findFood(Forest forest){
		if (this.animal == Animal_type.PREDATOR) {
			super.eatAnimal(name, size, forest);
		}
		else if(this.animal == Animal_type.HERBIVOROUS) {
			super.eatPlant(name, forest);
		}
		
	}
}
