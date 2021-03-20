package mypack;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Test31 {

	public static void main(String[] args)
	{
		//Register end-point of Rest-full web service
		RestAssured.baseURI="https://www.lipsum.com/hindi";
		Response res=RestAssured.given().get();
		XmlPath xp=res.htmlPath(); 
		String n=xp.getString("html.@lang"); //get a node's attribute value via xmlpath expression
		System.out.println(n);
		String x=xp.getString("html.head.title"); //get child node value via xmlpath expression
		System.out.println(x);
		
	}

}
