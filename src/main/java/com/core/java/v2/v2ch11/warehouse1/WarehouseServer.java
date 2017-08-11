package com.core.java.v2.v2ch11.warehouse1;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * The type Warehouse server.
 */
public class WarehouseServer
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws RemoteException the remote exception
    * @throws NamingException the naming exception
    */
   public static void main(String[] args) throws RemoteException, NamingException
   {
      System.out.println("Constructing server implementation...");
      WarehouseImpl centralWarehouse = new WarehouseImpl();

      System.out.println("Binding server implementation to registry...");
      Context namingContext = new InitialContext();
      namingContext.bind("rmi:central_warehouse", centralWarehouse);

      System.out.println("Waiting for invocations from clients...");
   }
}
