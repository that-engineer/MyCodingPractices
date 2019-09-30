package myAPIs.RESTAPIs.FileReadWrite;

import java.util.List;

import myAPIs.RESTAPIs.Models.Employee;

public class FileIO {

	JSONReadWrite jrw = new JSONReadWrite();
	
	public List<Employee> getEmployeeList(){
		return jrw.readEmployeesFromJSON();
	}
	public Employee getEmployeeByIdJSONRead(int id) {
		return jrw.readEmployeeByID(id);
	}
	public int addEmployeeDetails(Employee e) {
		return jrw.addEmployeeToJSON( e);
	}
	public int deleteEmployee(int id) {
		return jrw.deleteEmployeeFromJSON(id);
	}
	public boolean updateEmployee(Employee e) {
		return jrw.updateEmployeeInJSON(e);
	}
}

