package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test9 {

	public static void main(String[] args) 
	{
		//using Query parameters
		//create HTTP request
		RestAssured.baseURI="https://www.amazon.com/s";
		RequestSpecification req=RestAssured.given();
		Response res=req.queryParam("k","beer")
				.queryParam("ref","nb_sb_noss_2")
				.get();
		//display responce came from restful service resource
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	}

}
