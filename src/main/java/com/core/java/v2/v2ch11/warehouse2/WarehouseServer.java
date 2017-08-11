package com.core.java.v2.v2ch11.warehouse2;
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
      System.setProperty("java.encrypt.policy", "server.policy");
      System.setSecurityManager(new SecurityManager());
      
      System.out.println("Constructing server implementation...");
      WarehouseImpl backupWarehouse = new WarehouseImpl(null);
      WarehouseImpl centralWarehouse = new WarehouseImpl(backupWarehouse);
      
      centralWarehouse.add("toaster", new Product("Blackwell Toaster", 23.95));
      backupWarehouse.add("java", new Book("Core Java vol. 2", "0132354799", 44.95));

      System.out.println("Binding server implementation to registry...");
      Context namingContext = new InitialContext();
      namingContext.bind("rmi:central_warehouse", centralWarehouse);

      System.out.println("Waiting for invocations from clients...");
   }
}
