package ticket.domain.controller;

import ticket.domain.mediator.ServerManager;
import ticket.view.ConsoleView;

public class Controller
{
   private ServerManager modelManager;
   private ConsoleView view;

   public Controller(ServerManager model, ConsoleView view)
   {
      this.modelManager = model;
      this.view = view;
      modelManager.addObserver(view);

   }

   public void execute(String what)
   {
      String input;
      switch (what)
      {
         case "":
            break;

         case "Quit":
            System.exit(0);
            break;

         default:
            ;
      }
   }
}