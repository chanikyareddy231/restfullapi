package mypack;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test27 {

	public static void main(String[] args)
	{
		//Register end-point of Rest-full web service
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		Response res=RestAssured.given().get();
		JsonPath jp=res.jsonPath();
		//get all empoloyee details via way-3(using pojo class) 
		List<User> ul=jp.getList("",User.class); //jsonpath of root is null (or) "$" or "."
		int i=0;
		for(User u:ul)
		{
			System.out.println("user:"+1);
			System.out.println(u.id);
			System.out.println(u.name);
		    System.out.println(u.email);
		    System.out.println(u.address.street);
		    System.out.println(u.address.city);
		    System.out.println(u.address.suite);
		    System.out.println(u.address.zipcode);
		    System.out.println(u.address.geo.lat);
		    System.out.println(u.address.geo.lng);
		    System.out.println(u.phone);
		    System.out.println(u.website);
		    System.out.println(u.company.name);
		    System.out.println(u.company.catchPhrase);
		    System.out.println(u.company.bs);
		    i=i+1;
		}

	}

}
