package mypack;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test20 {

	public static void main(String[] args) 
	{
		//Create a request and submiit a request to Restful service resource
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		//Logic-2(jsonpath expression with parameterization
		JsonPath jp=res.jsonPath();
		Map<String,Object> m1=jp.getMap("data[0]"); //first record
		for(Map.Entry<String,Object> e:m1.entrySet())
		{
			System.out.println(e.getKey()+":"+e.getValue());
		}
		Map<String,Object> m2=jp.getMap("data[-1]"); //first record
		for(Map.Entry<String,Object> e:m2.entrySet())
		{
			System.out.println(e.getKey()+":"+e.getValue());
		}
        
	}

}
