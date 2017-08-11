package com.core.java.v2.v2ch11.activation;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.File;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The type Warehouse activator.
 */
public class WarehouseActivator
{
   /**
    * The entry point of application.
    *
    * @param args the input arguments
    * @throws RemoteException     the remote exception
    * @throws NamingException     the naming exception
    * @throws ActivationException the activation exception
    * @throws IOException         the io exception
    */
   public static void main(String[] args) throws RemoteException, NamingException,
         ActivationException, IOException
   {
      System.out.println("Constructing activation descriptors...");

      Properties props = new Properties();
      // use the server.policy file in the current directory
      props.put("java.encrypt.policy", new File("server.policy").getCanonicalPath());
      ActivationGroupDesc group = new ActivationGroupDesc(props, null);
      ActivationGroupID id = ActivationGroup.getSystem().registerGroup(group);

      Map<String, Double> prices = new HashMap<>();
      prices.put("Blackwell Toaster", 24.95);
      prices.put("ZapXpress Microwave Oven", 49.95);

      MarshalledObject<Map<String, Double>> param = new MarshalledObject<Map<String, Double>>(
            prices);

      String codebase = "http://localhost:8080/";

      ActivationDesc desc = new ActivationDesc(id, "WarehouseImpl", codebase, param);

      Warehouse centralWarehouse = (Warehouse) Activatable.register(desc);

      System.out.println("Binding activable implementation to registry...");
      Context namingContext = new InitialContext();
      namingContext.bind("rmi:central_warehouse", centralWarehouse);
      System.out.println("Exiting...");
   }
}
