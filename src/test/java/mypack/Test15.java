package mypack;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test15 {

	public static void main(String[] args)
	{
		//https://restcountries.eu/rest/v2/name/india?fullText=true
		//create a request and submit request to Restful service resource
		RestAssured.baseURI="https://restcountries.eu/rest/v2/name/india";
		Response res=RestAssured.given().queryParam("fullText",true).get();
		JsonPath jp=res.andReturn().jsonPath();
		//1.Get specific field value
		String x=jp.getString("region");
		System.out.println(x);
		//2.Get an array of values of a field
		List<String> y=jp.getList("borders");
		System.out.println(y);
		//3.Get values of multiple fields
		List<String> z=jp.getList("languages.name");
		System.out.println(z);
	}

}
