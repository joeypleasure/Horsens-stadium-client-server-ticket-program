import java.io.Serializable;

import ticket.domain.controller.Controller;
import ticket.domain.mediator.ServerManager;
import ticket.view.ConsoleView;

public class Main implements Serializable
{
   
   private static final long serialVersionUID = 1L;

   public static void main(String args[])
   {
      try
      {
         ServerManager model = new ServerManager();
         ConsoleView view = new ConsoleView();
         Controller controller = new Controller(model, view);
         view.start(controller);
         System.out.println("Hello Server");
      }
      catch (Exception e)
      {

         e.printStackTrace();
      }
   }
}
