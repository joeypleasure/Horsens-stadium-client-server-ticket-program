package ticket.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ticket.domain.controller.ClientController;

public class SearchCustomerGUI extends JFrame implements ActionListener
{
   ClientController controller;

   private JLabel cpr;
   private JLabel firstName;

   private JTextField cprtext, nametext;
   private JRadioButton rbNumber, rbName;

   private final int WINDOW_WIDTH = 350;
   private final int WINDOW_HEIGHT = 340;
   JButton search = new JButton("SEARCH"); // *
   JButton back = new JButton("BACK");

   public int getCprTextField()
   {
      return Integer.parseInt(cprtext.getText());
   }

   public String getfirstNameTextField()
   {
      return nametext.getText();
   }

   public boolean isNR_RadioButtonChecked()
   {
      if (rbNumber.isSelected())
         return true;
      else
         return false;
   }

   public boolean isFN_RadioButtonChecked()
   {
      if (rbName.isSelected())
         return true;
      else
         return false;
   }

   public SearchCustomerGUI(ClientController controller)
   {

      super("Search for Customers");
      this.controller = controller;
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      panel1.setLayout(null);
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      setLayout(new GridLayout(10, 3, 5, 5));
      cpr = new JLabel("Search by CPR:");
      rbNumber = new JRadioButton("");
      firstName = new JLabel("Search by Name:");
      rbName = new JRadioButton("");

      ButtonGroup group = new ButtonGroup();
      group.add(rbNumber);
      group.add(rbName);

      cprtext = new JTextField(20);
      nametext = new JTextField(20);

      search.addActionListener(this);
      back.addActionListener(this);
      add(rbNumber);
      add(cpr);

      add(cprtext);
      add(rbName);
      add(firstName);

      add(nametext);
      panel2.add(search);
      panel2.add(back);
      getContentPane().add(panel1);
      getContentPane().add(panel2);
      // *
      rbName.setBounds(70, 23, 140, 15);
      cpr.setBounds(70, 30, 150, 20);
      firstName.setBounds(70, 65, 150, 20);
      // badLogin.setBounds(110,100,80,20);
      search.setBounds(110, 100, 80, 20);
      back.setBounds(90, 9, 80, 20);

      setDefaultCloseOperation(EXIT_ON_CLOSE); // the program stops when X is
      // pressed

   }

   public String[] getSearchInfo()
   {
      String[] input = new String[2];

      input[0] = cprtext.getText();
      input[1] = nametext.getText();
      return input;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (!(e.getSource() instanceof JButton))
         return;

      if (((JButton) e.getSource()).getText().equalsIgnoreCase("BACK"))
      {
         try
         {
            controller.execute("BACK");
         }
         catch (RemoteException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }

      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Search"))
      {
         try
         {
            controller.execute("Search");
         }
         catch (RemoteException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }
   }
}
