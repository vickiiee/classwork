package javaTheHardWay;

public class Environment {

	private int plants;
	private int growthRate;

	public static void main(String[] args) {
		Environment farm = new Environment(10);
		System.out.println(farm);
		farm.growPlants();

	}
	
	public Environment(int plants) {
		this.plants = plants;
		this.growthRate = plants/2;
	}
	private void growPlants() {
		plants += growthRate;
		System.out.println("\nThere are plants" +plants+ " plants");
		
	}
	
	public boolean eatPlants() {
		if(plants >0) {
			plants--;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "A vast field";
	}
}