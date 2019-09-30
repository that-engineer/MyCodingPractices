package com.practice.java.JSONDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ListIterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	     
	    //Add employees to list
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
	
	/*
	 * public void JSONRead() { JSONParser parser = new JSONParser(); try(FileReader
	 * file = new
	 * FileReader("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")){ JSONArray
	 * ja = (JSONArray) parser.parse(file);
	 * 
	 * //System.out.println(ja.toJSONString());
	 * 
	 * ListIterator itr = ja.listIterator(); while(itr.hasNext()) { JSONObject jo =
	 * (JSONObject) itr.next(); //System.out.println(jo); JSONObject eo =
	 * (JSONObject) jo.get("employee"); String web = (String) eo.get("website");
	 * System.out.println(web);
	 * if(((String)eo.get("website")).equals("howtodoinjava.com")) {
	 * System.out.println("YaY !"); } } System.out.println(ja); }catch
	 * (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); } catch (ParseException e) { e.printStackTrace(); } }
	 */
	
	public void JSONRead() {

		JSONParser parser = new JSONParser();
		//Employees emp = null;
		try (FileReader file = new FileReader("C:\\Users\\rahul\\Desktop\\myFolder\\employees.json")) {
			JSONArray ja = (JSONArray) parser.parse(file);
			int id = 1;

			// System.out.println(ja.toJSONString());

			ListIterator itr = ja.listIterator();
			while (itr.hasNext()) {
				JSONObject eo = (JSONObject) itr.next();
				// System.out.println(eo);
				if ((eo.get("id"))==(Long.valueOf(id))) {
					System.out.println("YaY !");
					System.out.println(eo.get("name"));
					/*
					 * Gson g = new Gson(); emp = g.fromJson(eo.toJSONString(), Employees.class);
					 */
				}
			}
			System.out.println(ja);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
	}

	

}
