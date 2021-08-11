

import java.util.ArrayList;

public class Person {

	private String name;
	private Person mom;
	private Person dad;
	
	Person(String name, Person mm, Person md) {
		this.name = name;
		this.mom  = mm;
		this.dad = md;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person mm = new Person("Mom's-mom", null, null);
		Person md = new Person("Mom's- da",null, null);
		Person mom = new Person("Mom", mm, md);
		Person dm = new Person("Dad's-Mom", null, null);
		Person dd = new Person("Dad's- dad", null, null);
		Person dad = new Person("dad", dm, dd);
		Person kid = new Person("kid", mom, dad);
		
		ArrayList<String>  nameList = ancestors(kid);
		
		for(String name: nameList) {
			System.out.println(name);
		}
	}
	
	public static  ArrayList<String> ancestors(Person persons) {			
		
		ArrayList<String> nameList = new ArrayList<String>();
		recurse(persons, nameList);
		return nameList;
		
	}
	
	public static void recurse(Person persons, ArrayList<String> nameList) {
		
		if(persons.mom != null) {
			nameList.add(persons.mom.name);
			recurse(persons.mom, nameList);	
		}
			
		if(persons.dad!=null) {		
			nameList.add(persons.dad.name);
			recurse(persons.dad, nameList);
		}
	}

}
