package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test29 {

	public static void main(String[] args) 
	{
		//Register end-point of Rest-full web service
		RestAssured.baseURI="http://ergast.com/api/f1/2011";
		Response res=RestAssured.given().get();
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());

	}

}
