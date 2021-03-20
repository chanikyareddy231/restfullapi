package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test14 {

	public static void main(String[] args)
	{
		//Create a request and submiit a request to Restful service resource
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		//Display response came from restful service resource
		String ct=res.getContentType();
		if(ct.contains("json"))
		{
			System.out.println("Responce body type is JSON format");
		}
		else if(ct.contains("xml"))
		{
			System.out.println("Responce body type is XML format");
		}
		else if(ct.contains("html"))
		{
			System.out.println("Responce body type is HTML format");
		}
		else
		{
			System.out.println("Responce body type is plain text");
		}
	}

}
