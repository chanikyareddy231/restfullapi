package mypack;




import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test24 {

	public static void main(String[] args) 
	{
		//Register end-point of Rest-full web service
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		JsonPath jp=res.jsonPath();
		//get all employee details
		// Way-2(with parameterization)
		int noe=jp.getList("data").size();
		for(int i=0;i<noe;i++) //on list of maps
		{
			System.out.println("Employee:"+(+i+1));
			Map<String, Object> m=jp.getMap("data["+i+"]"); //parameterized json path
			for(Map.Entry<String, Object> e:m.entrySet()) //on list of entries in current map
			{
				System.out.println(e.getKey()+":"+e.getValue());
			}

		}
				
		
	}

}
