package com.core.java.v2.v2ch10. runtimeAnnotations;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * The type Action listener installer.
 */
public class ActionListenerInstaller
{
   /**
    * Process annotations.
    *
    * @param obj the obj
    */
   public static void processAnnotations(Object obj)
   {
      try
      {
         Class<?> cl = obj.getClass();
         for (Method m : cl.getDeclaredMethods())
         {
            ActionListenerFor a = m.getAnnotation(ActionListenerFor.class);
            if (a != null)
            {
               Field f = cl.getDeclaredField(a.source());
               f.setAccessible(true);
               addListener(f.get(obj), obj, m);
            }
         }
      }
      catch (ReflectiveOperationException e)
      {
         e.printStackTrace();
      }
   }

   /**
    * Add listener.
    *
    * @param source the source
    * @param param  the param
    * @param m      the m
    * @throws ReflectiveOperationException the reflective operation exception
    */
   public static void addListener(Object source, final Object param, final Method m)
         throws ReflectiveOperationException
   {
      InvocationHandler handler = new InvocationHandler()
         {
            public Object invoke(Object proxy, Method mm, Object[] args) throws Throwable
            {
               return m.invoke(param);
            }
         };

      Object listener = Proxy.newProxyInstance(null,
            new Class[] { java.awt.event.ActionListener.class }, handler);
      Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);
      adder.invoke(source, listener);
   }
}
