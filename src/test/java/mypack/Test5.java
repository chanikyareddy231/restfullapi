package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test5
{

	public static void main(String[] args) 
	{
		//create a request  and submit request to restful services resource
		RestAssured.baseURI="https://petstore.swagger.io/v2/store/order/1";
		Response res=RestAssured.given().get();
		//display responce came from restful service resource
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	}

}
