package mypack;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test26 {

	public static void main(String[] args) 
	{
		///Register end-point of Rest-full web service
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
		Response res=RestAssured.given().get();
		JsonPath jp=res.jsonPath();
		//get all employee details via way-3(using deserialization via pojo class)
		Employee[] el=jp.getObject("data",Employee[].class);
		int i=1;
		for(Employee e:el)
		{
			System.out.println("Employee:"+i);
			System.out.println(e.id);
			System.out.println(e.employee_name);
			System.out.println(e.employee_salary);
			System.out.println(e.employee_age);
			System.out.println(e.profile_image);
			i=i+1;
		}

	}

}
