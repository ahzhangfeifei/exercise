package com.core.java.v2.v2ch02. stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.net.URL;

/**
 * The type St ax test.
 */
public class StAXTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws Exception the exception
    */
   public static void main(String[] args) throws Exception
   {
      String urlString;
      if (args.length == 0)
      {
         urlString = "http://www.w3c.org";
         System.out.println("Using " + urlString);
      }
      else urlString = args[0];
      URL url = new URL(urlString);
      InputStream in = url.openStream();
      XMLInputFactory factory = XMLInputFactory.newInstance();
      XMLStreamReader parser = factory.createXMLStreamReader(in);
      while (parser.hasNext())
      {
         int event = parser.next();
         if (event == XMLStreamConstants.START_ELEMENT)
         {
            if (parser.getLocalName().equals("a")) 
            {
               String href = parser.getAttributeValue(null, "href");
               if (href != null)
                  System.out.println(href);               
            }
         }
      }
   }
}
