package mypack;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Test4 {

	public static void main(String[] args) 
	{
		//enter a word into keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a value");
		String x=sc.nextLine();
		sc.close();
		//create a request  and submit request to restful services resource
		RestAssured.baseURI="https://petstore.swagger.io/v2/store/order";
		Response res=RestAssured.given().get(x);
		//display responce came from restful service resource
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	}

}
