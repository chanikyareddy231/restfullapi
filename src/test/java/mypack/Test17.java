package mypack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test17 {

	public static void main(String[] args) throws Exception
	{
		//Create a request and submiit a request to Restful service resource
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		JsonPath jp=res.jsonPath();
		//Logic-1(jsonpath expression eithout parameterization
		List<String> empnames=jp.getList("data.employee_name");
		List<String> empsals=jp.getList("data.employee_salary");
		//Write responce values into a text file
		File f=new File("employeesresponce.txt");
        FileWriter fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);
		for(int i=0;i<empnames.size();i++)
		{
		    bw.write(empnames.get(i)+":"+empsals.get(i));	
		    bw.newLine();
		}
		bw.close();
		fw.close();

	}

}
