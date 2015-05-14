package ticket.domain.mediator;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import ticket.domain.model.FootballTicket;
import ticket.domain.model.Purchase;
import ticket.view.MasterGUI;

public class Proxy implements RemoteServerInterface, Serializable
{

   private static final long serialVersionUID = 5108439394138688544L;
   private RemoteServerInterface server;

   protected Proxy()
   {
      super();
      try
      {
         this.server = (RemoteServerInterface) Naming
               .lookup("rmi://localhost/Server");
      }
      catch (MalformedURLException | RemoteException | NotBoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public void addPurchase(Purchase p) throws RemoteException
   {
      server.addPurchase(p);
   }

   public ArrayList<FootballTicket> getAvailableTickets()
         throws RemoteException
   {
      return server.getAvailableTickets();
   }

   public int getLastSoldTicket() throws RemoteException
   {
      return server.getLastSoldTicket();
   }

   @Override
   public ArrayList<Purchase> searchClientByCPR(int number)
         throws RemoteException
   {

      return server.searchClientByCPR(number);
   }

   @Override
   public ArrayList<Purchase> searchClientByName(String name)
         throws RemoteException
   {

      return server.searchClientByName(name);
   }

   @Override
   public int getTotalIncome() throws RemoteException
   {

      return server.getTotalIncome();
   }

   @Override
   public boolean cancelPurchase(int number) throws SQLException,
         RemoteException
   {
      return server.cancelPurchase(number);
      // TODO Auto-generated method stub

   }

   public static void main(String[] args)
   {
      try
      {
         MasterGUI gui = new MasterGUI();

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   @Override
   public ArrayList<Purchase> getAllSoldTickets() throws RemoteException
   {
      // TODO Auto-generated method stub
      return server.getAllSoldTickets();
   }

}
