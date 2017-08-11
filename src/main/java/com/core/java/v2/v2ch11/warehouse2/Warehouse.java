package com.core.java.v2.v2ch11.warehouse2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

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

   /**
    * Gets product.
    *
    * @param keywords the keywords
    * @return the product
    * @throws RemoteException the remote exception
    */
   Product getProduct(List<String> keywords) throws RemoteException;
}
