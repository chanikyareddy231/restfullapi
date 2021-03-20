package mypack;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class MRData
{
	@JacksonXmlProperty(isAttribute=true)
	public String Xmlns;
	
	
	@JacksonXmlProperty(isAttribute=true)
	public String series;
	
	
	@JacksonXmlProperty(isAttribute=true)
	public String url;
	
	
	@JacksonXmlProperty(isAttribute=true)
	public int limit;
	
	
	@JacksonXmlProperty(isAttribute=true)
	public int offset;
	
	
	
	@JacksonXmlProperty(isAttribute=true)
	public int total;
	
	
	public  RaceTable RaceTable;	
}