package mypack;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 {

	public static void main(String[] args) 
	{
		//create a request
		RestAssured.baseURI="https://petstore.swagger.io/v2/store/order";
		RequestSpecification req=RestAssured.given();
        //submit request to restful services resource
		Response res=req.request(Method.GET,"1");
		//display responce came from restful service resource
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asPrettyString());
	}
}
