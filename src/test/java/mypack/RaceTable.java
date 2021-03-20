package mypack;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RaceTable 
{
	@JacksonXmlProperty(isAttribute=true)
	public int season;
	
	@JacksonXmlElementWrapper(useWrapping=false)
	public ArrayList<Race> Race=new ArrayList<Race>();
}
