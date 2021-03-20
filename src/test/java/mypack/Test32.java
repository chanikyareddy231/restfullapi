package mypack;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Test32 {

	public static void main(String[] args) throws Exception
	{
		//Deserialize
		XmlMapper xm=new XmlMapper();
        Sample obj=xm.readValue("<Sample><x>10</x><y>25</y></Sample>",Sample.class);
        System.out.println(obj.x);
        System.out.println(obj.y);
	}

}
