package com.core.java.v2.v2ch11.warehouse1;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Warehouse.
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse
{
   private Map<String, Double> prices;

   /**
    * Instantiates a new Warehouse.
    *
    * @throws RemoteException the remote exception
    */
   public WarehouseImpl() throws RemoteException
   {
      prices = new HashMap<>();
      prices.put("Blackwell Toaster", 24.95);
      prices.put("ZapXpress Microwave Oven", 49.95);
   }

   public double getPrice(String description) throws RemoteException
   {
      Double price = prices.get(description);
      return price == null ? 0 : price;
   }
}
