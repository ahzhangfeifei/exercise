package com.core.java.v2.v2ch11.activation;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The interface Warehouse.
 */
public interface Warehouse extends Remote
{
   /**
    * Gets price.
    *
    * @param description the description
    * @return the price
    * @throws RemoteException the remote exception
    */
   double getPrice(String description) throws RemoteException;
}
