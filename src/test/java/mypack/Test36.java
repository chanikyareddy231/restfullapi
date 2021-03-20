package mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Test36
{
	public static void main(String[] args) throws Exception
	{
		File f=new File("src\\test\\resources\\Book1.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=sh.getPhysicalNumberOfRows();
		for(int i=0;i<nour;i++)
		{
			DataFormatter df=new DataFormatter();
			String x=df.formatCellValue(sh.getRow(i).getCell(0));
			//create a request and submit request to Restful service resource
			RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
			Response res=RestAssured.given().get(x); //compound statement
			String t=res.jsonPath().getString("title");
			String b=res.jsonPath().getString("body");
			sh.getRow(i).createCell(1).setCellValue(t);
			sh.getRow(i).createCell(2).setCellValue(b);
		}
		sh.autoSizeColumn(1);
		sh.autoSizeColumn(2);
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		fi.close();	
	}
}
