package mypack;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test12 {

	public static void main(String[] args)
	{
		//Using request header parameters for authentication
        //Register base URI of the RESTFUL web service
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		//create and submit HTTP request
		Response res=RestAssured.given().auth().basic("ToolsQA","Testpassword").get();
		//Display response came from Restful service resource
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	}

}
