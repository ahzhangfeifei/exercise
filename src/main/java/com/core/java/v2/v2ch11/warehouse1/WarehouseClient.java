package com.core.java.v2.v2ch11.warehouse1;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

/**
 * The type Warehouse client.
 */
public class WarehouseClient
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws NamingException the naming exception
    * @throws RemoteException the remote exception
    */
   public static void main(String[] args) throws NamingException, RemoteException
   {
      Context namingContext = new InitialContext();
      
      System.out.print("RMI registry bindings: ");
      Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
      while (e.hasMoreElements())
         System.out.println(e.nextElement().getName());
      
      String url = "rmi://localhost/central_warehouse";      
      Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);
      
      String descr = "Blackwell Toaster";
      double price = centralWarehouse.getPrice(descr);
      System.out.println(descr + ": " + price);
   }
}
