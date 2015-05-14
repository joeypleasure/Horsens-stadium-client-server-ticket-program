package ticket.domain.mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import ticket.domain.model.FootballTicket;
import ticket.domain.model.Purchase;
import ticket.domain.model.Ticket;

public interface RemoteServerInterface extends Remote
{
   public void addPurchase(Purchase p) throws RemoteException;

   public int getLastSoldTicket() throws RemoteException;

   public ArrayList<FootballTicket> getAvailableTickets()
         throws RemoteException;

   public ArrayList<Purchase> searchClientByCPR(int number)
         throws RemoteException;

   public ArrayList<Purchase> searchClientByName(String name)
         throws RemoteException;

   public ArrayList<Purchase> getAllSoldTickets() throws RemoteException;

   public int getTotalIncome() throws RemoteException;

   public boolean cancelPurchase(int number) throws RemoteException,
         SQLException;
}
