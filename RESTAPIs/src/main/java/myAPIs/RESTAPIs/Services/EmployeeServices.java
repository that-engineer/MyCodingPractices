package myAPIs.RESTAPIs.Services;

import java.util.ArrayList;
import java.util.List;

import myAPIs.RESTAPIs.FileReadWrite.FileIO;
import myAPIs.RESTAPIs.Models.Employee;

public class EmployeeServices {
	FileIO io = new FileIO();
	public List<Employee> getEmployeeList(){
		return io.getEmployeeList();
		}
	
	public Employee getEmployeeById(int id) {
		return io.getEmployeeByIdJSONRead(id);
	}
	public int addEmployee(Employee e) {
		return io.addEmployeeDetails(e);
	}
	public int deleteEmployee(int id) {
		return io.deleteEmployee(id);
	}
	public boolean updateEmployee(Employee e) {
		return io.updateEmployee(e);
	}
}

