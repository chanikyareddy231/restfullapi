package mypack;



import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Test10 {

	public static void main(String[] args) 
	{
		//Using Matrix parameters and query paremeters
		//create and submit HTTP request
		RestAssured.urlEncodingEnabled=false;
		RestAssured.baseURI="https://petstore.swagger.io/v2/pet/findByStatus;matrixParm=test";
		Response res=RestAssured.given().queryParam("offset","0").queryParam("pageSize","20").get();
		//Display response came from Restful service resource
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());

	}

}
