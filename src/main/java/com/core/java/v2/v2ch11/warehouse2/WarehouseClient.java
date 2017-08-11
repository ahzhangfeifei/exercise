package com.core.java.v2.v2ch11.warehouse2;
import javax.naming.*;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
      System.setProperty("java.encrypt.policy", "client.policy");
      System.setSecurityManager(new SecurityManager());
      Context namingContext = new InitialContext();
      
      System.out.print("RMI registry bindings: ");
      NamingEnumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
      while (e.hasMore())
         System.out.println(e.next().getName());
      
      String url = "rmi://localhost/central_warehouse";      
      Warehouse centralWarehouse = (Warehouse) namingContext.lookup(url);
      
      Scanner in = new Scanner(System.in);
      System.out.print("Enter keywords: ");
      List<String> keywords = Arrays.asList(in.nextLine().split("\\s+"));
      Product prod = centralWarehouse.getProduct(keywords);
      
      System.out.println(prod.getDescription() + ": " + prod.getPrice());
   }
}
