package com.myPractice.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Employee implements Comparable{
	 String name;
	 int id;
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public int compareTo(Object obj) {
		Employee emp = (Employee) obj;
		return this.name.compareTo(emp.name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
public class ComparatorDemo {

	public static void main(String[] args) {
		
		LinkedList<Employee> ll = new LinkedList<>();
		ll.add(new Employee("Xyz", 10));
		ll.add(new Employee("Abc", 1));
		ll.add(new Employee("Pqr", 8));
		ll.add(new Employee("Efg", 4));
		ll.add(new Employee("Abc", 2));
		//Collections.sort(ll);
		Collections.sort(ll,new EmployeeComparator());
		for(Employee e: ll) {
			System.out.println(e.getName()+" "+e.getId());
		}
		
		
		/*Had we not implemented Comaparable interface in the Employee class, we would get the error
		 * Collections.sort(ls); //The method sort(List<T>) in the type Collections is
		 * not //applicable for the arguments (LinkedList<Employee>)
		 */	}

}

class EmployeeComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Employee emp1 = (Employee) arg0;
		Employee emp2 = (Employee) arg1;
		
		if (emp1.getName().compareTo(emp2.getName()) == 0)
			return (((Integer) emp1.getId()).compareTo((Integer) emp2.getId()));
		else
			return emp1.getName().compareTo(emp2.getName());
	}
	
}
