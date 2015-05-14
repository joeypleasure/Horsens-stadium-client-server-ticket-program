package ticket.view;

import java.util.Observable;
import java.util.Observer;

import ticket.domain.controller.Controller;

public class ConsoleView implements Observer
{
   private Controller controller;
   private boolean newPurchase;

   public ConsoleView()
   {
      this.newPurchase = false;
   }

   @Override
   public void update(Observable o, Object arg)
   {
      System.out.println("look: " + arg.toString());

   }

 

   public void start(Controller controller)
   {
      this.controller = controller;
   }

}
