package mypack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test35
{
	public static void main(String[] args) throws Exception
	{
		//Open existing fie in read mode
		File f1=new File("src\\test\\resources\\tessdata.txt");
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);
		//Create a new file or update an existing file for date writing
		File f2=new File("src\\test\\resources\\testresult.txt");
		FileWriter fw=new FileWriter(f2);
		BufferedWriter bw=new BufferedWriter(fw); 
		//Parameterized request format
		String x;
		while((x=br.readLine())!=null)
		{
			//create a request and submit request to Restful service resource
			RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
			Response res=RestAssured.given().get(x); //compound statement
			String t=res.jsonPath().getString("title");
			String b=res.jsonPath().getString("body");
			bw.write(t+"<----->"+b);
			bw.newLine();
		}
		bw.close();
		br.close();
		fr.close();
		fw.close();
		
	}

}
