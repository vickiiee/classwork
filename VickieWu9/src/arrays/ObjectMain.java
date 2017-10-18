package arrays;

public class ObjectMain {

	public ObjectMain() {
		Object[] people = new Object[12];
		populate(people);
		people[0] = new Thing("toaster oven");
		for(Object p: people)
		{
			System.out.println(p);
		}
		
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

}
