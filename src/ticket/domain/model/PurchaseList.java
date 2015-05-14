package ticket.domain.model;

import java.util.ArrayList;

import ticket.domain.mediator.TicketDbAdapter;
import ticket.domain.mediator.TicketDbInterface;

public class PurchaseList
{
   private ArrayList<Purchase> purchases;
   private static PurchaseList instance;

   private PurchaseList()
   {
      this.purchases = new ArrayList<Purchase>();
   }

   public static PurchaseList getInstance()
   {
      if (instance == null)
      {
         instance = new PurchaseList();

      }
      return instance;
   }

   public void addPurchase(Purchase p)
   {
      purchases.add(p);
   }

   public String getPurchaseByName(String name)
   {
      String nameFound = "This person is Not Registerd";
      for (int i = 0; i < purchases.size(); i++)
      {
         if (name.equalsIgnoreCase(purchases.get(i).getFirstName())
               || name.equalsIgnoreCase(purchases.get(i).getLastName()))
         {
            return nameFound = "First Name: " + purchases.get(i).getFirstName()
                  + "\nLastName: " + purchases.get(i).getLastName()
                  + "\nAddress: " + purchases.get(i).getAddress() + "\nCPR: "
                  + purchases.get(i).getCpr() + "\nTichet Number: "
                  + purchases.get(i).getRefNo() + "\nPhone Number: "
                  + purchases.get(i).getPhoneNo() + "\nEmail: "
                  + purchases.get(i).getEmail();
         }
      }
      return nameFound;
   }

}
