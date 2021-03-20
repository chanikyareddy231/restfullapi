package mypack;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Test30 {

	public static void main(String[] args) 
	{
		//Register end-point of Rest-full web service
		RestAssured.baseURI="http://ergast.com/api/f1/2011";
		Response res=RestAssured.given().get();
		XmlPath xp=res.xmlPath();
        //1.Get root node's attribute value
		String v1=xp.get("MRData.@limit");
		System.out.println(v1);
		//2.using**,find and get one node value
		String v2=xp.getString("**.find{it.@season=='2011' && it.@round=='1'}");
		System.out.println(v2);
		//3.using**,find and get one node's attribute value
		String v3=xp.get("**.find{it.@season=='2011' && it.@round=='1'}.@url");
		System.out.println(v3);
		//4.using**,find and get child node value
		String v4=xp.get("**.find{it.@season=='2011' && it.@round=='1'}.RaceName");
		System.out.println(v4);
		//5.using**,find and get child nodes attribute value
		String v5=xp.get("**.find{it.@season=='2011' && it.@round=='1'}.Circuit.@circuitId");
		System.out.println(v5);
		//6.using**,findAll with one condition on node name,and size()
		int c1=xp.get("**.findAll{it.name()=='Race'}.size()");
		System.out.println(c1);
		//7.using**,findAll with one condition on attribute and size()
		int c2=xp.get("**.findAll{it.@season=='2011'}.size()");
		System.out.println(c2);
		//8.using**,findAll with more than one condition and size()
		int c3=xp.get("**.findAll{it.name()=='Race' && it.@round=='1'}.size()");
		System.out.println(c3);
		//9.using**,findAll and child node with size()
		int c4=xp.get("**.findAll{it.name()=='Race' && it.@season=='2011'}.RaceName.size()");
		System.out.println(c4);
		//10.using**,findAll nodes and get value of those nodes
		List<String> nv1=xp.get("**.findAll{it.name()=='Race' && it.@season=='2011'}");
		System.out.println(nv1);
		//11.using**,findAll nodes and get required attribute values of those nodes
		List<String> av1=xp.get("**.findAll{it.name()=='Race' && it.@season=='2011'}.@round");
		System.out.println(av1);
		
	}

}
