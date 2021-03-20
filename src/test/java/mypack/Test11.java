package mypack;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test11 {

	public static void main(String[] args) 
	{
		//Register end-point(URI)
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
        //Packing request body parameters with values
		JSONObject jo=new JSONObject();
		jo.put("userId",10); //1 to 10 in db
		jo.put("id",100);
		jo.put("tittle","wishes");
		jo.put("body","All is well");
		//create and submit HTTP request
		Response res=RestAssured.given().header("Content-Type","application/json").body(jo.toString()).post();
		//Display response came from Restful service resource
		System.out.println(res.getStatusLine());
		System.out.println(res.getContentType());
		System.out.println(res.getBody().asString());
	}
}
