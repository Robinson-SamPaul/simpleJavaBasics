package simple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AfhAggregateOperation {

	public static void main(String[] args) {

		Collection<Pupil> collection = new ArrayList<>();
		
		collection.add(new Pupil(1, "Austin"));
		collection.add(new Pupil(2, "Bert"));
		collection.add(new Pupil(3, "Carla"));
		collection.add(new Pupil(4, "Desmond"));
		collection.add(new Pupil(5, "Emily"));
		collection.add(new Pupil(6, "Fred"));
		
		List<String> citiesList = collection.stream()
				.filter(person -> person.rollNo % 2 == 0)
				.map(p -> p.name)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		System.out.println("List of names : " + citiesList);
		
		Set<String> citiesSet = collection.stream()
				.filter(person -> person.rollNo % 2 == 0)
				.map(p -> p.name)
				.collect(HashSet::new, HashSet::add, HashSet::addAll);

		System.out.println("\nSet of names : " + citiesSet);
		
		Averager averageCollect = collection.stream()
				.filter(person -> person.rollNo % 2 == 0)
				.map(p -> p.rollNo)
				.collect(Averager::new, Averager::accumulate, Averager::combine);

		System.out.println("\nAverage age of makes: " + averageCollect.average());
	}

	private static class Averager {

		private int total = 0;
	    private int count = 0;
	    
	    public double average() {
	        return count > 0 ? ((double) total)/count : 0;
	    }
	        
	    public void accumulate(int i) { 
	    	total += i; 
	    	count++; 
	    }

	    public void combine(Averager other) {
	        total += other.total;
	        count += other.count;
	    }
	}
}
