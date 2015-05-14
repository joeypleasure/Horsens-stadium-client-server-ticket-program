package ticket.domain.mediator;

import java.sql.SQLException;
import java.util.ArrayList;

import ticket.domain.model.FootballTicket;
import ticket.domain.model.Purchase;
import ticket.domain.model.PurchaseList;
import ticket.domain.model.Ticket;

public interface TicketDbInterface
{
   public boolean connect();

   public boolean disconect();

   public PurchaseList getAllPurchases();

   public void addPurchase(Purchase p);

   public int getLastSoldTicket();

   public ArrayList<FootballTicket> getAvailableTickets();

   public ArrayList<Purchase> getAllSoldTickets();

   public void setDebugMode(boolean mode);

   public ArrayList<Purchase> searchClientByCPR(int cpr);

   public ArrayList<Purchase> searchClientByName(String name);

   public int getTotalIncome();

   public boolean cancelPurchase(int number) throws SQLException;
}
