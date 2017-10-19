package arrays;

public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[120];
		populate(people);
		//people[0] = new Thing("toaster oven");
		Person[] group = selectGroup(people, 120);
		analyzecommonalities(people, group);
		/*for(Object p: group)
		{
			System.out.println(p);
		}*/
		
	}
	
	private void analyzecommonalities(Person[] people, Person[] group) {
		double averageCommonality = 0;
		double trials = 500;
		
		for(int i = 0; i < trials; i++) {
			group = selectGroup(people, people.length);
			countCommonalities(people, group);
			averageCommonality += countCommonalities(people, group);
			
		}
		averageCommonality = averageCommonality/500;
		
		System.out.println("After" + trials+ "trials, shuffling" + people.length + " people, on average, " + averageCommonality + 
				" people end up in the same position where they started.");
		
	}

	private int countCommonalities(Object[] arr1, Object[] arr2) {
		//returns the number of items that are the same in both arrays
		//and in the same location (index) too
		/*
		 * PRECONDITION:
		 * the arrays have the same length
		 */
		
		int count = 0;
		for(int i = 0; i<arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				count++;
			}
		}
		
		return count;
	}

	private void populate(Object[] people) {
		for (int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE,Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START,Person.LAST_MIDDLE,Person.LAST_END);
			Borough home = randomBourough();
			//people[i] = new Person(firstName, lastName, home);
			
			/*
			 * BIG IDEA:
			 * In an Object array, you can have multiple data types!
			 * (This is unlike a primitive array, like int[], boolean[], etc.
			 */
			
			if (Math.random() < .6)
			{
				//60% of the time
				int money = (int)(Math.random() *20 )*100000;
				people[i] = new Athlete(firstName, lastName, home, money);
			}else
			{
				//the other 40% of the time
				people[i] = new Person(firstName, lastName, home);
			}
		}
		
	}

	private Borough randomBourough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String [] b, String [] c) {
		return get(a)+ get(b) + get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random()*a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();

	}
	
	public Person[] selectGroup(Person[] population, int length)
	{
		/*
		 * returns a new Person[] group 
		 * that has length 'length' and every 
		 * element of 'group' is randomly selected from population
		 * with no repeats
		 */
		
		Person[] group = new Person[length];
		for (int i = 0; i < length; i++)
		{
			Person anotherRandomPerson = randomPerson(population);
			while(alreadyContains(population, anotherRandomPerson)) {
				anotherRandomPerson = randomPerson(population);
			}
			group[i] = anotherRandomPerson;
			
		}
		return group;
		
		
	}
	
	private Person randomPerson(Person[] population)
	{//returns a randomly selected Person from population
		
		int index = (int)(Math.random()* population.length);
		return population[index];
		
	}
	
	private boolean alreadyContains(Person[] population, Person p)
	{//returns true if population already has p in it
		
		for (int i = 0; i < population.length; i++)
		{
			if (population[i] == p)
			{
				return true;
			}
				
			
		}
		//String is a class
		
		return false;
	}

}
