package application;

import application.AdresBook;
import application.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class CollectionAdresBook implements AdresBook {
	//private ArrayList<Person> personList = new ArrayList<Person>();
	private ObservableList<Person> personList = FXCollections.observableArrayList();
	
	@Override
	public void add(Person person) { personList.add(person); }
	
	@Override
	public void update(Person person) { }
	
	@Override
	public void delete(Person person) { personList.remove(person); }
	
	public ObservableList<Person> getPersonList() { return personList; }
	
	public void Print() {
		int count = 0;
		System.out.println();
		
		for (Person person : personList) {
			count++;
			String outResult = count + ") FIO: " + person.getFio() + ", Phone number: " + person.getPhone() + ";";
			
			System.out.println(outResult);
		}
	}
	
	public void FillTestData() {
		personList.add(new Person("Alex", "123456"));
		personList.add(new Person("Timur", "897453"));
		personList.add(new Person("Sasha", "123324"));
	}
	
}
