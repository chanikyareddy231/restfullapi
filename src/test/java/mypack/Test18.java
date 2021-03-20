package mypack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test18 {

	public static void main(String[] args) throws Exception
	{
		//Create a request and submiit a request to Restful service resource
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		//Logic-2(jsonpath expression with parameterization
		JsonPath jp=res.jsonPath();
		//Write responce values into a text file
	    File f=new File("employeesresponces.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		int count=jp.getList("data.id").size();
		for(int i=0;i<count;i++)
		{
		    String n=jp.getString("data["+i+"].employee_name");
		    String s=jp.getString("data["+i+"].employee_salary");
		    bw.write(n+":"+s);
		    bw.newLine();
		}
		bw.close();
		fw.close();

	}

}
