package com.core.java.v2.v2ch06. splitPane;

import javax.swing.*;

/**
 * The type Planet.
 */
public class Planet
{
   private String name;
   private double radius;
   private int moons;
   private ImageIcon image;

   /**
    * Instantiates a new Planet.
    *
    * @param n the n
    * @param r the r
    * @param m the m
    */
   public Planet(String n, double r, int m)
   {
      name = n;
      radius = r;
      moons = m;
      image = new ImageIcon(getClass().getResource(name + ".gif"));
   }

   public String toString()
   {
      return name;
   }

   /**
    * Gets description.
    *
    * @return the description
    */
   public String getDescription()
   {
      return "Radius: " + radius + "\nMoons: " + moons + "\n";
   }

   /**
    * Gets image.
    *
    * @return the image
    */
   public ImageIcon getImage()
   {
      return image;
   }
}
