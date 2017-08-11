package com.core.java.v1.v1ch11. eventTracer;

import javax.swing.*;
import java.awt.*;

/**
 * The type Event tracer test.
 */
public class EventTracerTest
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new EventTracerFrame();
               frame.setTitle("EventTracerTest");      
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The type Event tracer frame.
 */
class EventTracerFrame extends JFrame
{
   /**
    * Instantiates a new Event tracer frame.
    */
   public EventTracerFrame()
   {
      // add a slider and a button
      add(new JSlider(), BorderLayout.NORTH);
      add(new JButton("Test"), BorderLayout.SOUTH);

      // trap all events of components inside the frame
      EventTracer tracer = new EventTracer();
      tracer.add(this);
      pack();
   }
}
