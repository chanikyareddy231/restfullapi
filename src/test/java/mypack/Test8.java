package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Test8 {

	public static void main(String[] args) 
	{
		//using Query parameters
		//create a request  and submit request to restful services resource
		RestAssured.baseURI="https://api.weatherapi.com/v1/current.xml";
		Response res=RestAssured.given()
				.queryParam("key","e9c3b0195be341c795281747202311")
				.queryParam("q","Hyderabad")
				.get();
		//display responce came from restful service resource
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	}

}
