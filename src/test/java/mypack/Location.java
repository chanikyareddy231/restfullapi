package mypack;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Location 
{
   @JacksonXmlProperty(isAttribute=true)
   public double lat;
   
   @JacksonXmlProperty(isAttribute=true,localName="long") //alter native name to "long" because "long" is reserved word in java
   public double langitude;
   
   public String Locality;
   
   public String Country;
}
