package mypack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test19 {

	public static void main(String[] args) throws Exception
	{
		//Create a request and submiit a request to Restful service resource
		RestAssured.baseURI="https://restcountries.eu/rest/v2/all";
		Response res=RestAssured.given().get();
		//Logic-2(jsonpath expression with parameterization
		JsonPath jp=res.jsonPath();
		//Write responce values into a text file
		int count=jp.getList("name").size();
		System.out.println(count);
	    File f=new File("countriesresponce.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		for(int i=0;i<count;i++)
		{
		    String n=jp.getString("name["+i+"]");
		    String s=jp.getString("capital["+i+"]");
		    List<String> bs=jp.getList("borders["+i+"]");
		    bw.write(n+":"+s+":"+bs);
		    bw.newLine();
		}
		bw.close();
		fw.close();

	}

}
