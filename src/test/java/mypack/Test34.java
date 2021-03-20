package mypack;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test34 {

	public static void main(String[] args) throws Exception
	{
		//specify the base url to the restful webservice including a path parameter
		RestAssured.baseURI="http://ergast.com/api/f1/2011";
		Response res=RestAssured.given().get();
		String output=res.getBody().asString();
		//Deserialization
		XmlMapper xm=new XmlMapper();
		MRData value=xm.readValue(output,MRData.class);
		System.out.println(value.total);
		System.out.println(value.RaceTable.season);
		System.out.println(value.RaceTable.Race.get(3).Date);
		System.out.println(value.RaceTable.Race.get(3).Circuit.CircuitName);
		System.out.println(value.RaceTable.Race.get(3).Circuit.Location.langitude);
	}

}
