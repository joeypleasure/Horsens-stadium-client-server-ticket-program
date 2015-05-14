package ticket.domain.mediator;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import ticket.domain.model.FootballTicket;
import ticket.domain.model.Purchase;
import ticket.domain.model.PurchaseList;
import ticket.domain.model.Ticket;
import utility.persistence.MyDatabase;

public class TicketDbAdapter implements TicketDbInterface, Serializable
{

  
   private static final long serialVersionUID = 2800952294142082092L;
   private static final String DATABASE_NAME = "horsens";
   private static final String USER = "root";
   private static final String PASSWORD = "";
   private static final boolean DEBUG = true;

   private MyDatabase db;

   public TicketDbAdapter()
   {
      db = new MyDatabase(DATABASE_NAME, USER, PASSWORD);
      db.setDebugMode(DEBUG);
   }

   @Override
   public boolean connect()
   {
      return db.openDatabase();
   }

   @Override
   public boolean disconect()
   {
      return db.closeDatabase();
   }

   @Override
   public PurchaseList getAllPurchases()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public void addPurchase(Purchase p)
   {
      db.openDatabase();

      String sql = "INSERT INTO `purchase`(`ticketRefNo` ,`CPR`, `LastName`, `FirstName`, `PhoneNo`, `email`, `Address`) VALUES ('"
            + p.getRefNo()
            + "', '"
            + p.getCpr()
            + "', '"
            + p.getLastName()
            + "', '"
            + p.getFirstName()
            + "', '"
            + p.getPhoneNo()
            + "', '"
            + p.getEmail() + "', '" + p.getAddress() + "');";
      db.update(sql);
      System.out.println("Data saved in DB");
   }

   @Override
   public void setDebugMode(boolean debugMode)
   {
      db.setDebugMode(debugMode);
   }

   @Override
   public int getLastSoldTicket()
   {

      int ticketRefNo = 0;

      db.openDatabase();

      String sql = "SELECT ticketRefNo FROM `purchase` WHERE `Id` IN (SELECT MAX(`Id`) FROM `purchase`)";

      ArrayList<Object[]> result = db.query(sql);
      // if (result != null && result.get(0) != null && result.get(0).length >
      // 0) {
      for (int i = 0; i < result.size(); i++)
      {
         ticketRefNo = ((Number) result.get(i)[0]).intValue();
         // }
      }

      return ticketRefNo;
   }

   public ArrayList<FootballTicket> getAvailableTickets()
   {
      ArrayList<FootballTicket> list = new ArrayList<FootballTicket>();
      FootballTicket ticket;

      int referenceNo; // 0
      String eventName; // 1
      String dateOfEvent; // 2
      String eventPlace; // 3
      double price; // 4
      String sector; // 5
      String row; // 6
      int seatNo; // 7

      String sql = "SELECT referenceNo, eventName, dateOfEvent, eventPlace, price, sector, row, seatNo FROM footballticket WHERE footballticket.referenceNo NOT IN (SELECT ticketRefNo FROM purchase  )";
      ArrayList<Object[]> result = db.query(sql);
      if (result != null && result.get(0) != null && result.get(0).length > 0)
      {
         for (int i = 0; i < result.size(); i++)
         {
            referenceNo = ((Number) result.get(i)[0]).intValue();
            eventName = (String) result.get(i)[1];
            dateOfEvent = (String) result.get(i)[2];
            eventPlace = (String) result.get(i)[3];
            price = (double) result.get(i)[4];
            sector = (String) result.get(i)[5];
            row = (String) result.get(i)[6];
            seatNo = (Integer) result.get(i)[7];

            ticket = new FootballTicket(referenceNo, eventName, dateOfEvent,
                  eventPlace, price, sector, row, seatNo);
            list.add(ticket);
         }
      }
      return list;
   }

   public ArrayList<Purchase> searchClientByCPR(int number)
   {
      ArrayList<Purchase> list = new ArrayList<Purchase>();
      Purchase p;

      int ticketRefNo;
      int cpr;
      String lastName;
      String firstName;
      int phoneNo;
      String email;
      String address;

      String sql = "SELECT `ticketRefNo`,`CPR`,`LastName`,`FirstName`,`PhoneNo`,`email`,`Address` FROM `purchase` WHERE `FirstName` LIKE '%'";

      ArrayList<Object[]> result = db.query(sql);

      if (result != null && result.get(0) != null && result.get(0).length > 0)
      {

         for (int i = 0; i < result.size(); i++)
         {

            ticketRefNo = ((Number) result.get(i)[0]).intValue();
            cpr = (Integer) result.get(i)[1];
            lastName = (String) result.get(i)[2];
            firstName = (String) result.get(i)[3];
            phoneNo = (Integer) result.get(i)[4];
            email = (String) result.get(i)[5];
            address = (String) result.get(i)[6];

            p = new Purchase(ticketRefNo, cpr, lastName, firstName, phoneNo,
                  email, address);

            if (p.getCpr() == number)
               list.add(p);
         }
         return list;

      }
      return null;
   }

   @Override
   public ArrayList<Purchase> searchClientByName(String name)
   {
      ArrayList<Purchase> list = new ArrayList<Purchase>();
      Purchase p;

      int ticketRefNo;
      int cpr;
      String lastName;
      String firstName;
      int phoneNo;
      String email;
      String address;

      String sql = "SELECT `ticketRefNo`,`CPR`,`LastName`,`FirstName`,`PhoneNo`,`email`,`Address` FROM `purchase` WHERE `FirstName` LIKE '%'";

      ArrayList<Object[]> result = db.query(sql);

      if (result != null && result.get(0) != null && result.get(0).length > 0)
      {

         for (int i = 0; i < result.size(); i++)
         {

            ticketRefNo = ((Number) result.get(i)[0]).intValue();
            cpr = (Integer) result.get(i)[1];
            lastName = (String) result.get(i)[2];
            firstName = (String) result.get(i)[3];
            phoneNo = (Integer) result.get(i)[4];
            email = (String) result.get(i)[5];
            address = (String) result.get(i)[6];

            p = new Purchase(ticketRefNo, cpr, lastName, firstName, phoneNo,
                  email, address);

            if (p.getFirstName().equalsIgnoreCase(name)
                  || p.getLastName().equalsIgnoreCase(name))
               list.add(p);
         }
         return list;

      }
      return null;
   }

   public ArrayList<Purchase> getAllSoldTickets()
   {
      ArrayList<Purchase> list = new ArrayList<Purchase>();
      Purchase p;

      int ticketRefNo;
      int cpr;
      String lastName;
      String firstName;
      int phoneNo;
      String email;
      String address;

      String sql = "SELECT `ticketRefNo`, `CPR`, `LastName`, `FirstName`, `PhoneNo`, `email`, `Address` FROM `purchase` WHERE 1";
      ArrayList<Object[]> result = db.query(sql);

      if (result != null && result.get(0) != null && result.get(0).length > 0)
      {

         for (int i = 0; i < result.size(); i++)
         {

            ticketRefNo = ((Number) result.get(i)[0]).intValue();
            cpr = (Integer) result.get(i)[1];
            lastName = (String) result.get(i)[2];
            firstName = (String) result.get(i)[3];
            phoneNo = (Integer) result.get(i)[4];
            email = (String) result.get(i)[5];
            address = (String) result.get(i)[6];

            p = new Purchase(ticketRefNo, cpr, lastName, firstName, phoneNo,
                  email, address);

            list.add(p);
         }
         return list;

      }
      return null;
   }

   @Override
   public int getTotalIncome()
   {
      int total = 0;
      int price;
      String sql = "SELECT `footballticket`.`price` FROM `horsens`.`purchase` INNER JOIN `horsens`.`footballticket` ON (`purchase`.`ticketRefNo` = `footballticket`.`referenceNo`)";
      ArrayList<Object[]> result = db.query(sql);
      for (int i = 0; i < result.size(); i++)
      {

         price = ((Number) result.get(i)[0]).intValue();
         total += price;
      }
      return total;
   }

   public boolean cancelPurchase(int number) throws SQLException
   {

      String sql = "DELETE FROM `purchase` WHERE `ticketRefNo` = ?";
      int result = db.update(sql, number);

      System.out.println("This Booking was deleted and the ticket with nr: "
            + number + " is now available.");

      boolean update = true;

      if (result <= 0)
      {
         update = false;
      }
      return update;
   }

}
