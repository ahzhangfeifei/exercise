package com.core.java.v2.v2ch02. transform;

import org.xml.sax.*;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * The type Transform test.
 */
public class TransformTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws Exception the exception
    */
   public static void main(String[] args) throws Exception
   {
      Path path;
      if (args.length > 0) path = Paths.get(args[0]);
      else path = Paths.get("transform", "makehtml.xsl");
      try (InputStream styleIn = Files.newInputStream(path))
      {
         StreamSource styleSource = new StreamSource(styleIn);
   
         Transformer t = TransformerFactory.newInstance().newTransformer(styleSource);     
         t.setOutputProperty(OutputKeys.INDENT, "yes");
         t.setOutputProperty(OutputKeys.METHOD, "xml");      
         t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

         try (InputStream docIn = Files.newInputStream(Paths.get("transform", "employee.dat")))
         {
            t.transform(new SAXSource(new EmployeeReader(), new InputSource(docIn)), 
               new StreamResult(System.out));
         }
      }
   }
}

/**
 * The type Employee reader.
 */
class EmployeeReader implements XMLReader
{
   private ContentHandler handler;

   public void parse(InputSource source) throws IOException, SAXException
   {
      InputStream stream = source.getByteStream();
      BufferedReader in = new BufferedReader(new InputStreamReader(stream));
      String rootElement = "staff";
      AttributesImpl atts = new AttributesImpl();

      if (handler == null) throw new SAXException("No content handler");

      handler.startDocument();
      handler.startElement("", rootElement, rootElement, atts);
      String line;
      while ((line = in.readLine()) != null)
      {
         handler.startElement("", "employee", "employee", atts);
         StringTokenizer t = new StringTokenizer(line, "|");

         handler.startElement("", "name", "name", atts);
         String s = t.nextToken();
         handler.characters(s.toCharArray(), 0, s.length());
         handler.endElement("", "name", "name");

         handler.startElement("", "salary", "salary", atts);
         s = t.nextToken();
         handler.characters(s.toCharArray(), 0, s.length());
         handler.endElement("", "salary", "salary");

         atts.addAttribute("", "year", "year", "CDATA", t.nextToken());
         atts.addAttribute("", "month", "month", "CDATA", t.nextToken());
         atts.addAttribute("", "day", "day", "CDATA", t.nextToken());
         handler.startElement("", "hiredate", "hiredate", atts);
         handler.endElement("", "hiredate", "hiredate");
         atts.clear();

         handler.endElement("", "employee", "employee");
      }

      handler.endElement("", rootElement, rootElement);
      handler.endDocument();
   }

   public void setContentHandler(ContentHandler newValue)
   {
      handler = newValue;
   }

   public ContentHandler getContentHandler()
   {
      return handler;
   }

   // the following methods are just do-nothing implementations
   public void parse(String systemId) throws IOException, SAXException
   {
   }

   public void setErrorHandler(ErrorHandler handler)
   {
   }

   public ErrorHandler getErrorHandler()
   {
      return null;
   }

   public void setDTDHandler(DTDHandler handler)
   {
   }

   public DTDHandler getDTDHandler()
   {
      return null;
   }

   public void setEntityResolver(EntityResolver resolver)
   {
   }

   public EntityResolver getEntityResolver()
   {
      return null;
   }

   public void setProperty(String name, Object value)
   {
   }

   public Object getProperty(String name)
   {
      return null;
   }

   public void setFeature(String name, boolean value)
   {
   }

   public boolean getFeature(String name)
   {
      return false;
   }
}
