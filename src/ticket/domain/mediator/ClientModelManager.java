package ticket.domain.mediator;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import ticket.domain.model.FootballTicket;
import ticket.domain.model.Purchase;

public class ClientModelManager implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -1404311760105753518L;
   private Proxy proxy;

   public ClientModelManager()
   {
      this.proxy = new Proxy();
   }

   public void addPurchase(Purchase p) throws RemoteException
   {
      proxy.addPurchase(p);
   }

   public int getLastSoldTicket() throws RemoteException
   {
      return proxy.getLastSoldTicket();

   }

   public ArrayList<FootballTicket> getAvailableTickets()
         throws RemoteException
   {

      return proxy.getAvailableTickets();
   }

   public ArrayList<Purchase> searchClientByCPR(int number)
         throws RemoteException
   {

      return proxy.searchClientByCPR(number);
   }

   public ArrayList<Purchase> searchClientByName(String name)
         throws RemoteException
   {

      return proxy.searchClientByName(name);
   }

   public int getTotalIncome() throws RemoteException
   {

      return proxy.getTotalIncome();
   }

   public boolean cancelPurchase(int number) throws SQLException,
         RemoteException
   {
      return proxy.cancelPurchase(number);

   }

   public ArrayList<Purchase> getAllSoldTickets() throws RemoteException
   {
      return proxy.getAllSoldTickets();
   }

}
