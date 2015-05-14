import ticket.domain.mediator.TicketDbAdapter;
import ticket.domain.model.Purchase;

public class TestDBAddPurchase
{

   public static void main(String[] args)
   {

      // FootballTicket ticket = new FootballTicket(4, "Soccer Game", new
      // Date("28 may 2014"), "Casa Arena", 80, 'N', 'A', 101);

      // PurchaseList list = new PurchaseList();
      //
      Purchase p1 = new Purchase(1, 280280, "Alin", "Stanescu", 27605950,
            "stanescu_a21@yahoo.com", "Skanderborg");

      TicketDbAdapter db = new TicketDbAdapter();
      //
      db.addPurchase(p1);

      System.out.println();

   }

}
