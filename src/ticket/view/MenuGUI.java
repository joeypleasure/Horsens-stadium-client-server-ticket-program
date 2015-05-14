package ticket.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ticket.domain.controller.ClientController;

public class MenuGUI extends JFrame implements ActionListener
{

   private static final long serialVersionUID = 5167936514412011069L;
   private JPanel panel;
   private JButton SeeAvailableTickets, BookTiket, searchcustomer, CancelTiket,
         TotalIncome, SoldTickets;

   ClientController controller;

   private final int WINDOW_WIDTH = 500;
   private final int WINDOW_HEIGHT = 260;

   public MenuGUI(ClientController controller) throws SQLException,
         ClassNotFoundException
   {
      super("Tiket Menu UI");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      buildPanel();

      this.controller = controller;
   }

   private void buildPanel()
   {
      JPanel pageList = new JPanel();

      BookTiket = new JButton("Book Tikets");
      searchcustomer = new JButton("Search for a customer");

      CancelTiket = new JButton("Cancel Tiket");

      JPanel panel1 = new JPanel();

      panel1.add(BookTiket);
      panel1.add(searchcustomer);

      panel1.add(CancelTiket);

      panel1.setLayout(new GridLayout(8, 1));
      add(panel1, BorderLayout.WEST);

      JPanel panel2 = new JPanel();
      SeeAvailableTickets = new JButton("See Available Tickets");
      TotalIncome = new JButton("Total Income");
      SoldTickets = new JButton("Sold Tickets");
      panel2.add(SeeAvailableTickets);
      panel2.add(TotalIncome);
      panel2.add(SoldTickets);
      panel2.setLayout(new GridLayout(6, 1));
      add(panel2, BorderLayout.EAST);

      panel1.setBorder(BorderFactory.createTitledBorder("Edit"));
      panel2.setBorder(BorderFactory.createTitledBorder("Show"));

      SeeAvailableTickets.addActionListener(this);
      BookTiket.addActionListener(this);
      searchcustomer.addActionListener(this);
      TotalIncome.addActionListener(this);
      CancelTiket.addActionListener(this);
      SoldTickets.addActionListener(this);

   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (!(e.getSource() instanceof JButton))
         return;

      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Book Tikets"))
      {
         try
         {
            controller.execute("Book Tikets");
         }
         catch (RemoteException e1)
         {

            e1.printStackTrace();
         }
      }
      if (((JButton) e.getSource()).getText().equalsIgnoreCase(
            "Search for a customer"))
      {
         try
         {
            controller.execute("Search for a customer");
         }
         catch (RemoteException e1)
         {

            e1.printStackTrace();
         }

      }
      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Cancel Tiket"))
      {
         try
         {
            controller.execute("Cancel Tiket");
         }
         catch (RemoteException e1)
         {

            e1.printStackTrace();
         }

      }
      if (((JButton) e.getSource()).getText().equalsIgnoreCase(
            "See Available Tickets"))
      {
         try
         {
            controller.execute("See Available Tickets");
         }
         catch (RemoteException e1)
         {

            e1.printStackTrace();
         }

      }
      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Total Income"))
      {
         try
         {
            controller.execute("Total Income");
         }
         catch (RemoteException e1)
         {

            e1.printStackTrace();
         }

      }
      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Sold Tickets"))
      {
         try
         {
            controller.execute("Sold Tickets");
         }
         catch (RemoteException e1)
         {

            e1.printStackTrace();
         }

      }

   }

}