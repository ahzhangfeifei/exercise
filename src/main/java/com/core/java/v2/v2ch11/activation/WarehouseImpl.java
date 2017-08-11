package com.core.java.v2.v2ch11.activation;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.rmi.RemoteException;
import java.rmi.activation.Activatable;
import java.rmi.activation.ActivationID;
import java.util.Map;

/**
 * The type Warehouse.
 */
public class WarehouseImpl extends Activatable implements Warehouse
{
   private Map<String, Double> prices;

   /**
    * Instantiates a new Warehouse.
    *
    * @param id    the id
    * @param param the param
    * @throws RemoteException        the remote exception
    * @throws ClassNotFoundException the class not found exception
    * @throws IOException            the io exception
    */
   public WarehouseImpl(ActivationID id, MarshalledObject<Map<String, Double>> param)
         throws RemoteException, ClassNotFoundException, IOException
   {
      super(id, 0);
      prices = param.get();
      System.out.println("Warehouse implementation constructed.");
   }

   public double getPrice(String description) throws RemoteException
   {
      Double price = prices.get(description);
      return price == null ? 0 : price;
   }
}
