package mypack;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Race 
{
	@JacksonXmlProperty(isAttribute=true)
	public int season;
	
	@JacksonXmlProperty(isAttribute=true)
	public int round;
	
	@JacksonXmlProperty(isAttribute=true)
    public String url;

	public String RaceName;
	
	public Circuit Circuit;
	
	public String Date;
	
	
	public String Time;
	
	
}
