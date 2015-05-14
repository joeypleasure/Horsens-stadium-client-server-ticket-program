package ticket.domain.controller;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ticket.domain.mediator.ClientModelManager;
import ticket.domain.model.Purchase;
import ticket.view.MasterGUI;

public class ClientController
{
   private ClientModelManager clientManager;
   private MasterGUI gui;

   public ClientController(MasterGUI gui)
   {
      this.clientManager = new ClientModelManager();
      this.gui = gui;

   }

   public void execute(String choice) throws RemoteException
   {
      switch (choice)
      {
         case "Cancel Tiket":
            gui.showCancelGui(true);

            break;
         case "Book Tikets":
            gui.showBookGui(true);

            break;

         case "Search for a customer":
            gui.showSearchGui(true);

            break;

         case "Login":
            String[] inputLogin = gui.getLoginInput();

            if (inputLogin[0].equalsIgnoreCase("admin")
                  && inputLogin[1].equalsIgnoreCase("admin"))
            {
               gui.showMenuGui(true);
               gui.showLogonGui(false);
            }
            else
            {
               JOptionPane.showMessageDialog(gui.getLogingui(), "Wrong !");
               gui.showMenuGui(false);
               gui.showLogonGui(true);
            }
            break;
         case "Cancel":
            gui.showMenuGui(true);
            gui.showBookGui(false);
            gui.showCancelGui(false);
            gui.showSearchGui(false);

            break;

         case "BACK":
            gui.showMenuGui(true);
            gui.showSearchGui(false);
            break;

         case "Confirm":
            String[] inputPurchase = gui.getPurchaseInput();

            if (inputPurchase[0].equals("") || inputPurchase[1].equals("")
                  || inputPurchase[2].equals("") || inputPurchase[3].equals("")
                  || inputPurchase[4].equals("") || inputPurchase[5].equals("")
                  || inputPurchase[6].equals(""))
            {
               JOptionPane.showMessageDialog(null, "No field can be empty");
            }
            else
            {
               int refNo = 0;
               int phoneNo = 0;
               int cpr = 0;

               try
               {
                  refNo = Integer.parseInt(inputPurchase[0]);
                  phoneNo = Integer.parseInt(inputPurchase[4]);

               }
               catch (Exception e)
               {
                  JOptionPane.showMessageDialog(null, "No strings in");
               }

               Purchase p = new Purchase(gui.getBookgui().getRefNoTextField(),
                     gui.getBookgui().getCprTextField(), gui.getBookgui()
                           .getFirsNameTextField(), gui.getBookgui()
                           .getLastNameTextField(), gui.getBookgui()
                           .getPhoneTextField(), gui.getBookgui()
                           .getEmailTextField(), gui.getBookgui()
                           .getAddressTextField());
               clientManager.addPurchase(p);

               JOptionPane.showMessageDialog(gui.getBookgui(), "Succes !!!");
               gui.getBookgui().setFirstnameTextField(null);
               gui.showMenuGui(true);
               gui.showBookGui(false);
               gui.getBookgui().setLastNameTextField();
            }

            break;

         case "Search":
            String[] inputSearch = gui.getSearchInput();

            if ((inputSearch[0].equals("") && gui.getSearchgui()
                  .isNR_RadioButtonChecked())
                  || (inputSearch[1].equals("") && (gui.getSearchgui()
                        .isFN_RadioButtonChecked())))
            {
               JOptionPane.showMessageDialog(null, "No field can be empty");
            }
            try
            {

               if (gui.getSearchgui().isNR_RadioButtonChecked()) // search by
                                                                 // number
               {
                  int cpr = gui.getSearchgui().getCprTextField();
                  JOptionPane.showMessageDialog(gui.getSearchgui(),
                        clientManager.searchClientByCPR(cpr).toString());
               }
               else if (gui.getSearchgui().isFN_RadioButtonChecked())
               {
                  String name = gui.getSearchgui().getfirstNameTextField();
                  JOptionPane.showMessageDialog(gui.getSearchgui(),
                        clientManager.searchClientByName(name).toString());
               }

            }
            catch (Exception e)
            {
               e.printStackTrace();
               JOptionPane.showMessageDialog(gui.getSearchgui(),
                     "No match found");

            }

            break;

         case "Confirm cancellation":

            String[] inputCancel = gui.getCancelInput();

            if (inputCancel[0].equals(""))
            {
               JOptionPane.showMessageDialog(null, "No field can be empty");
            }
            try
            {
               int display = gui.getCancelgui().getRefNoTextField();
               clientManager.cancelPurchase(display);

               // display.result(gui.getCancelgui());
            }

            catch (SQLException e)
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
            break;
         case "See Available Tickets":

            JOptionPane.showMessageDialog(null,
                  clientManager.getAvailableTickets());
            break;

         case "Total Income":
            JOptionPane.showMessageDialog(null, clientManager.getTotalIncome());

            break;
         case "Sold Tickets":

            System.out.println("haha");
            JOptionPane.showMessageDialog(null,
                  clientManager.getAllSoldTickets());
            break;
      }

   }
}
