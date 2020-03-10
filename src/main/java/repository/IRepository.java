package repository;

import entities.Person;

import java.util.Comparator;
import java.util.List;

public interface IRepository {
	
	public void add(Person person);
	
	public Person get(int index);
	
	public Person remove(int index);

	public void set(int index, Person person);
	
	public void add(int index, Person person);
	
	public List<Person> toList();

	public void sortBy(Comparator<Person> comparator);

	//Should not use toList method
	//public IRepository searchBy(Predicate<Person> filter);

}
