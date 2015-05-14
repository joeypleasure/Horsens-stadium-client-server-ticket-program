package ticket.domain.mediator;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import ticket.domain.model.FootballTicket;
import ticket.domain.model.Purchase;
import ticket.domain.model.PurchaseList;

public class ServerManager extends Observable implements RemoteServerInterface,
      Serializable
{

   private static final long serialVersionUID = -1717430339739518548L;
   private PurchaseList purchaselist;
   private TicketDbInterface dataBase;
   private RemoteServerInterface server;
   private ArrayList<FootballTicket> ticketList;

   public ServerManager() throws RemoteException
   {
      try
      {
         dataBase = new TicketDbAdapter();
         dataBase.setDebugMode(true);

         purchaselist = dataBase.getAllPurchases();

         if (purchaselist == null)
         {
            purchaselist = PurchaseList.getInstance();
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      server = new RemoteServer(this);
   }

   // Add Purchase Method
   public void addPurchase(Purchase p)
   {
      purchaselist.addPurchase(p);
      super.setChanged();
      super.notifyObservers(p);
      dataBase.addPurchase(p);

   }

  /* public boolean isNewPurchase()
   {
      return false;
   }
*/
   public int getLastSoldTicket()
   {
      return dataBase.getLastSoldTicket();
   }

   @Override
   public ArrayList<FootballTicket> getAvailableTickets()
   {
      ticketList = dataBase.getAvailableTickets();
      return ticketList;
   }

   @Override
   public ArrayList<Purchase> searchClientByCPR(int number)
   {
      return dataBase.searchClientByCPR(number);
   }

   @Override
   public ArrayList<Purchase> searchClientByName(String name)
   {

      return dataBase.searchClientByName(name);
   }

   @Override
   public int getTotalIncome()
   {

      return dataBase.getTotalIncome();
   }

   @Override
   public boolean cancelPurchase(int number) throws SQLException
   {

      return dataBase.cancelPurchase(number);
   }

   @Override
   public ArrayList<Purchase> getAllSoldTickets()
   {
      // TODO Auto-generated method stub
      return dataBase.getAllSoldTickets();
   }

}
