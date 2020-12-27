package my.code.forest;

import java.util.Random;

import my.code.forest.Forest.Animal_type;
import my.code.forest.Forest.Plant_type;

public class Plant extends Forest {

	enum Sort { KIND1, KIND2, KIND3;
		private static Sort[] sorts = Sort.values();	
		private static Random random = new Random();
		final static Sort random() {
			return sorts[random.nextInt(sorts.length)];
		}
	};
	Sort sort;
	String name;
	Plant(Plant_type type, Sort sort, String name){
		super(type);
		this.sort = sort;
		this.name = name;
	}
	
	public String toString() {
		return super.plant + " " + name + " " + sort;
	}
}
