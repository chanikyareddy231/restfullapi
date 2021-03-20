package mypack;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Test13 {

	public static void main(String[] args) 
	{
		// Create a request and submiit a request to Restful service resource
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		//Display response came from restful service resource
		String sl=res.getStatusLine();
		String[] p=sl.split(" ");
		System.out.println(p[1]);
		Headers hs=res.getHeaders();
		for(Header h:hs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
	     System.out.println(res.getBody().asString());
	}

}
