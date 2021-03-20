package mypack;



import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test23 {

	public static void main(String[] args) 
	{
		//Register end-point of Rest-full web service
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		JsonPath jp=res.jsonPath();
		//get all employee details
		// Way-1(without parametarization But with Extra condition/filters)
		List<Map<String, Object>> ml=jp.getList("data");
		for(int i=0;i<ml.size();i++) //on list of maps
		{
			//filter
			if(Integer.parseInt(ml.get(i).get("employee_salary").toString())<=100000 && ml.get(i).get("employee_name").toString().startsWith("A"))
			{
				for(Map.Entry e:ml.get(i).entrySet()) //on list of entries in current map
				{
					System.out.println(e.getKey()+":"+e.getValue());
				}
			}
			
		}
				
		
	}

}
