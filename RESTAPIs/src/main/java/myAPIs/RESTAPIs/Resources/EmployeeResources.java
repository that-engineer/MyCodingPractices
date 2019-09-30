package myAPIs.RESTAPIs.Resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import myAPIs.RESTAPIs.Models.*;
import myAPIs.RESTAPIs.Services.*;;

@Path("/employee")
public class EmployeeResources {
	EmployeeServices service = new EmployeeServices();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeesList() {
		return service.getEmployeeList();
	}

	@GET
	@Path("{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("id") int id) {
		return service.getEmployeeById(id);

	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public int addEmployeeDetails(Employee e) {
		return service.addEmployee(e);
	}

}