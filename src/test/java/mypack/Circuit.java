package mypack;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Circuit
{
	@JacksonXmlProperty(isAttribute=true)
	public String circuitId;
	
	@JacksonXmlProperty(isAttribute=true)
	public String url;
	
	public String CircuitName;
	
	public Location Location;
	 
	
}
