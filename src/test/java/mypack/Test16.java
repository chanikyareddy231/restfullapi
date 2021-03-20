package mypack;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test16 {

	public static void main(String[] args) throws Exception
	{
		///create a request and submit request to Restful service resource
		RestAssured.baseURI="https://restcountries.eu/rest/v2/all";
		Response res=RestAssured.given().get();
		//Write responce body into text file
        File f=new File("countriesresponce.txt");
        FileWriter fw=new FileWriter(f);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(res.getBody().asString());
        bw.close();
        fw.close();
	}

}
