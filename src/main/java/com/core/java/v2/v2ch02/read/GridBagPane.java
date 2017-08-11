package com.core.java.v2.v2ch02. read;

import org.w3c.dom.*;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Field;

/**
 * The type Grid bag pane.
 */
public class GridBagPane extends JPanel
{
   private GridBagConstraints constraints;

   /**
    * Instantiates a new Grid bag pane.
    *
    * @param file the file
    */
   public GridBagPane(File file)
   {
      setLayout(new GridBagLayout());
      constraints = new GridBagConstraints();

      try
      {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         factory.setValidating(true);

         if (file.toString().contains("-schema"))
         {
            factory.setNamespaceAware(true);
            final String JAXP_SCHEMA_LANGUAGE = 
               "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
            final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
            factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
         }

         factory.setIgnoringElementContentWhitespace(true);

         DocumentBuilder builder = factory.newDocumentBuilder();
         Document doc = builder.parse(file);
         parseGridbag(doc.getDocumentElement());         
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   /**
    * Get component.
    *
    * @param name the name
    * @return the component
    */
   public Component get(String name)
   {
      Component[] components = getComponents();
      for (int i = 0; i < components.length; i++)
      {
         if (components[i].getName().equals(name)) return components[i];
      }
      return null;
   }

   private void parseGridbag(Element e)
   {
      NodeList rows = e.getChildNodes();
      for (int i = 0; i < rows.getLength(); i++)
      {
         Element row = (Element) rows.item(i);
         NodeList cells = row.getChildNodes();
         for (int j = 0; j < cells.getLength(); j++)
         {
            Element cell = (Element) cells.item(j);
            parseCell(cell, i, j);
         }
      }
   }

   private void parseCell(Element e, int r, int c)
   {
      // get attributes

      String value = e.getAttribute("gridx");
      if (value.length() == 0) // use default
      {
         if (c == 0) constraints.gridx = 0;
         else constraints.gridx += constraints.gridwidth;
      }
      else constraints.gridx = Integer.parseInt(value);

      value = e.getAttribute("gridy");
      if (value.length() == 0) // use default
      constraints.gridy = r;
      else constraints.gridy = Integer.parseInt(value);

      constraints.gridwidth = Integer.parseInt(e.getAttribute("gridwidth"));
      constraints.gridheight = Integer.parseInt(e.getAttribute("gridheight"));
      constraints.weightx = Integer.parseInt(e.getAttribute("weightx"));
      constraints.weighty = Integer.parseInt(e.getAttribute("weighty"));
      constraints.ipadx = Integer.parseInt(e.getAttribute("ipadx"));
      constraints.ipady = Integer.parseInt(e.getAttribute("ipady"));

      // use reflection to get integer values of static fields
      Class<GridBagConstraints> cl = GridBagConstraints.class;

      try
      {
         String name = e.getAttribute("fill");
         Field f = cl.getField(name);
         constraints.fill = f.getInt(cl);

         name = e.getAttribute("anchor");
         f = cl.getField(name);
         constraints.anchor = f.getInt(cl);
      }
      catch (Exception ex) // the reflection methods can throw various exceptions
      {
         ex.printStackTrace();
      }

      Component comp = (Component) parseBean((Element) e.getFirstChild());
      add(comp, constraints);
   }

   private Object parseBean(Element e)
   {
      try
      {
         NodeList children = e.getChildNodes();
         Element classElement = (Element) children.item(0);
         String className = ((Text) classElement.getFirstChild()).getData();

         Class<?> cl = Class.forName(className);

         Object obj = cl.newInstance();

         if (obj instanceof Component) ((Component) obj).setName(e.getAttribute("id"));

         for (int i = 1; i < children.getLength(); i++)
         {
            Node propertyElement = children.item(i);
            Element nameElement = (Element) propertyElement.getFirstChild();
            String propertyName = ((Text) nameElement.getFirstChild()).getData();

            Element valueElement = (Element) propertyElement.getLastChild();
            Object value = parseValue(valueElement);
            BeanInfo beanInfo = Introspector.getBeanInfo(cl);
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            boolean done = false;
            for (int j = 0; !done && j < descriptors.length; j++)
            {
               if (descriptors[j].getName().equals(propertyName))
               {
                  descriptors[j].getWriteMethod().invoke(obj, value);
                  done = true;
               }
            }
         }
         return obj;
      }
      catch (Exception ex) // the reflection methods can throw various exceptions
      {
         ex.printStackTrace();
         return null;
      }
   }

   private Object parseValue(Element e)
   {
      Element child = (Element) e.getFirstChild();
      if (child.getTagName().equals("bean")) return parseBean(child);
      String text = ((Text) child.getFirstChild()).getData();
      if (child.getTagName().equals("int")) return new Integer(text);
      else if (child.getTagName().equals("boolean")) return new Boolean(text);
      else if (child.getTagName().equals("string")) return text;
      else return null;
   }
}
