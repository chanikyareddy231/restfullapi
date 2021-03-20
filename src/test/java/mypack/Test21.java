package mypack;



import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test21 {

	public static void main(String[] args) 
	{
		//Register end-point of Rest-full web service
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		JsonPath jp=res.jsonPath();
		//get all employee details via Way-1(without parametarization)
		List<Map<String, Object>> ml=jp.getList("data");
		for(int i=0;i<ml.size();i++) //on list of maps
		{
			System.out.println("Employee:"+(+i+1));
			System.out.println(ml.get(i).get("id"));
			System.out.println(ml.get(i).get("employee_name"));
			System.out.println(ml.get(i).get("employee_salary"));
			System.out.println(ml.get(i).get("employee_age"));
			System.out.println(ml.get(i).get("profile_image"));
		}
				
		
	}

}
