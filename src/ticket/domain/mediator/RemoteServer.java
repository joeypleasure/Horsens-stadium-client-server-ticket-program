package ticket.domain.mediator;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import ticket.domain.model.FootballTicket;
import ticket.domain.model.Purchase;

public class RemoteServer extends UnicastRemoteObject implements
      RemoteServerInterface, Serializable
{
   
   private static final long serialVersionUID = 8237349550965897463L;
   private ServerManager manager;

   public RemoteServer(ServerManager manager) throws RemoteException
   {
      this.manager = manager;

      try
      {
         Registry reg = LocateRegistry.createRegistry(1099);

         reg.rebind("Server", this);
         System.out.println("Starting server !");
      }
      catch (RemoteException e)
      {

         e.printStackTrace();
      }
   }

   @Override
   public void addPurchase(Purchase p)
   {
      manager.addPurchase(p);
   }

   @Override
   public int getLastSoldTicket()
   {
      return manager.getLastSoldTicket();

   }

   @Override
   public ArrayList<FootballTicket> getAvailableTickets()
   {
      return manager.getAvailableTickets();
   }

   @Override
   public ArrayList<Purchase> searchClientByCPR(int number)
   {

      return manager.searchClientByCPR(number);
   }

   @Override
   public ArrayList<Purchase> searchClientByName(String name)
   {

      return manager.searchClientByName(name);
   }

   @Override
   public int getTotalIncome()
   {

      return manager.getTotalIncome();
   }

   @Override
   public boolean cancelPurchase(int number) throws SQLException
   {
      return manager.cancelPurchase(number);
      // TODO Auto-generated method stub

   }

   @Override
   public ArrayList<Purchase> getAllSoldTickets()
   {
      // TODO Auto-generated method stub
      return manager.getAllSoldTickets();
   }

}
