package com.core.java.v2.v2ch08. damageReporter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.beans.*;
import java.util.ArrayList;

/**
 * The type Damage report.
 */
public class DamageReport
{
   private String rentalRecord;
   private CarType carType;
   private boolean removeMode;
   private java.util.List<Point2D> points = new ArrayList<>();

   private static final int MARK_SIZE = 5;

   /**
    * The enum Car type.
    */
   public enum CarType
   {
      /**
       * Sedan car type.
       */
      SEDAN, /**
    * Wagon car type.
    */
   WAGON, /**
    * Suv car type.
    */
   SUV
   }

   /**
    * Sets rental record.
    *
    * @param newValue the new value
    */
// this property is saved automatically
   public void setRentalRecord(String newValue)
   {
      rentalRecord = newValue;
   }

   /**
    * Gets rental record.
    *
    * @return the rental record
    */
   public String getRentalRecord()
   {
      return rentalRecord;
   }

   /**
    * Sets car type.
    *
    * @param newValue the new value
    */
// this property is saved automatically
   public void setCarType(CarType newValue)
   {
      carType = newValue;
   }

   /**
    * Gets car type.
    *
    * @return the car type
    */
   public CarType getCarType()
   {
      return carType;
   }

   /**
    * Sets remove mode.
    *
    * @param newValue the new value
    */
// this property is set to be transient
   public void setRemoveMode(boolean newValue)
   {
      removeMode = newValue;
   }

   /**
    * Gets remove mode.
    *
    * @return the remove mode
    */
   public boolean getRemoveMode()
   {
      return removeMode;
   }

   /**
    * Click.
    *
    * @param p the p
    */
   public void click(Point2D p)
   {
      if (removeMode)
      {
         for (Point2D center : points)
         {
            Ellipse2D circle = new Ellipse2D.Double(center.getX() - MARK_SIZE, center.getY()
                  - MARK_SIZE, 2 * MARK_SIZE, 2 * MARK_SIZE);
            if (circle.contains(p))
            {
               points.remove(center);
               return;
            }
         }
      }
      else points.add(p);
   }

   /**
    * Draw damage.
    *
    * @param g2 the g 2
    */
   public void drawDamage(Graphics2D g2)
   {
      g2.setPaint(Color.RED);
      for (Point2D center : points)
      {
         Ellipse2D circle = new Ellipse2D.Double(center.getX() - MARK_SIZE, center.getY()
               - MARK_SIZE, 2 * MARK_SIZE, 2 * MARK_SIZE);
         g2.draw(circle);
      }
   }

   /**
    * Configure encoder.
    *
    * @param encoder the encoder
    */
   public void configureEncoder(XMLEncoder encoder)
   {
      // this step is necessary to save Point2D.Double objects
      encoder.setPersistenceDelegate(Point2D.Double.class, new DefaultPersistenceDelegate(
            new String[] { "x", "y" }));

      // this step is necessary because the array list of points is not
      // (and should not be) exposed as a property
      encoder.setPersistenceDelegate(DamageReport.class, new DefaultPersistenceDelegate()
         {
            protected void initialize(Class<?> type, Object oldInstance, Object newInstance,
                  Encoder out)
            {
               super.initialize(type, oldInstance, newInstance, out);
               DamageReport r = (DamageReport) oldInstance;

               for (Point2D p : r.points)
                  out.writeStatement(new Statement(oldInstance, "click", new Object[] { p }));
            }
         });
   }

   // this step is necessary to make the removeMode property transient
   static
   {
      try
      {
         BeanInfo info = Introspector.getBeanInfo(DamageReport.class);
         for (PropertyDescriptor desc : info.getPropertyDescriptors())
            if (desc.getName().equals("removeMode")) desc.setValue("transient", Boolean.TRUE);
      }
      catch (IntrospectionException e)
      {
         e.printStackTrace();
      }
   }
}
