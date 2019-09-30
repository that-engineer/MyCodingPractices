package myAPIs.RESTAPIs.FileReadWrite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import myAPIs.RESTAPIs.Models.Employee;

public class JSONReadWrite {
	
	@SuppressWarnings("unchecked")
	public void JSONWrite() {
		//System.out.println( "Hello World!" );
	    JSONObject employeeDetails = new JSONObject();
	    employeeDetails.put("firstName", "Lokesh");
	    employeeDetails.put("lastName", "Gupta");
	    employeeDetails.put("website", "new.com");
	     
	    JSONObject employeeObject = new JSONObject();
	    employeeObject.put("employee", employeeDetails);
	     
	    //Second Employee
	    JSONObject employeeDetails2 = new JSONObject();
	    employeeDetails2.put("firstName", "Brian");
	    employeeDetails2.put("lastName", "Schultz");
	    employeeDetails2.put("website", "example.com");
	     
	    JSONObject employeeObject2 = new JSONObject();
	    employeeObject2.put("employee", employeeDetails2);
	     
	    //Add Employee to list
	    JSONArray employeeList = new JSONArray();
	    employeeList.add(employeeObject);
	    employeeList.add(employeeObject2);
	    
	    try (FileWriter file = new FileWriter("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")) {
	    	 
	        file.write(employeeList.toJSONString());
	        file.flush();
	       // System.out.println(new File(".").getAbsolutePath());
	       // System.out.println(System.getProperty("user.dir"));

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void JSONRead() {
		JSONParser parser = new JSONParser();
		try(FileReader file = new FileReader("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")){
			JSONArray ja = (JSONArray) parser.parse(file);
			
			//System.out.println(ja.toJSONString());
			
			ListIterator itr = ja.listIterator();
			while(itr.hasNext()) {
				JSONObject jo = (JSONObject) itr.next();
				//System.out.println(jo);
				JSONObject eo = (JSONObject) jo.get("employee");
				String web = (String) eo.get("website");
				System.out.println(web);
				if(((String)eo.get("website")).equals("howtodoinjava.com")) {
					System.out.println("YaY !");
				}
			}
			System.out.println(ja);
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		}
	
	public Employee readEmployeeByID(int id) {
		JSONParser parser = new JSONParser();
		Employee emp = null;
		try (FileReader file = new FileReader("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")) {
			JSONArray ja = (JSONArray) parser.parse(file);
			ListIterator<?> itr = ja.listIterator();
			while (itr.hasNext()) {
				JSONObject eo = (JSONObject) itr.next();
				if ((eo.get("id")) == (Long.valueOf(id))) {
					Gson g = new Gson();
					emp = g.fromJson(eo.toJSONString(), Employee.class);
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public List<Employee> readEmployeesFromJSON() {
		JSONParser parser = new JSONParser();
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = null;
		try (FileReader file = new FileReader("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")) {
			JSONArray ja = (JSONArray) parser.parse(file);
			ListIterator<?> itr = ja.listIterator();
			while (itr.hasNext()) {
				JSONObject eo = (JSONObject) itr.next();
				Gson g = new Gson();
				emp = g.fromJson(eo.toJSONString(), Employee.class);
				list.add(emp);
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return list;

	}

	@SuppressWarnings("unchecked")
	public int addEmployeeToJSON(Employee e) {
		JSONParser parser = new JSONParser();
		JSONArray ja = new JSONArray();
		JSONObject obj = new JSONObject();
		obj.put("id", e.getId());
		obj.put("name", e.getName());
		obj.put("age", e.getAge());
		obj.put("salary", e.getSalary());
		int id = -1;
		try (FileReader file = new FileReader("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")) {
			ja = (JSONArray) parser.parse(file);
			if (!ja.contains(obj)) {
				ja.add(obj);
				id = e.getId();
			} else {
				id = -1;
			}
		} catch (IOException | ParseException ex) {
			ex.printStackTrace();
		}
		try (FileWriter file = new FileWriter("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")) {
	        file.write(ja.toJSONString());
	        file.flush();
	      } catch (IOException ex) {
	        ex.printStackTrace();
	    }
		return id;
	}
	public int deleteEmployeeFromJSON(int id) {
		JSONParser parser = new JSONParser();
		Employee emp = null;
		int delId = -1;
		try (FileReader file = new FileReader("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")) {
			JSONArray ja = (JSONArray) parser.parse(file);
			ListIterator<?> itr = ja.listIterator();
			while (itr.hasNext()) {
				JSONObject eo = (JSONObject) itr.next();
				if ((eo.get("id")) == (Long.valueOf(id))) {
					delId=(Integer)eo.get("id");
					itr.remove();
				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return delId;
	}
	@SuppressWarnings("unchecked")
	public boolean updateEmployeeInJSON(Employee e) {
		JSONParser parser = new JSONParser();
		JSONObject obj = new JSONObject();
		obj.put("id", e.getId());
		obj.put("name", e.getName());
		obj.put("age", e.getAge());
		obj.put("salary", e.getSalary());
		boolean flag = false;
		try (FileReader file = new FileReader("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")) {
			JSONArray ja = (JSONArray) parser.parse(file);
			ListIterator<?> itr = ja.listIterator();
			while (itr.hasNext()) {
				JSONObject eo = (JSONObject) itr.next();
				if ((eo.get("id")) == (Long.valueOf(e.getId()))) {
					itr.remove();
					flag=true;
				}
			}
			ja.add(obj);
		} catch (IOException | ParseException ex) {
			ex.printStackTrace();
		}
		return flag;
	}

}


