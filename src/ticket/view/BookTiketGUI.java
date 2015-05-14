package ticket.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ticket.domain.controller.ClientController;
import ticket.domain.mediator.ClientModelManager;

public class BookTiketGUI extends JFrame implements ActionListener
{

   private JTextField firstnameTextField;
   private JTextField lastNameTextField;
   private JTextField cprTextField;
   private JTextField phoneTextField;
   private JTextField emailTextField;
   private JTextField addressTextField;
   private JTextField refNoTextField;

   ClientController controller;

   public String getFirsNameTextField()
   {
      return firstnameTextField.getText();
   }

   public String getLastNameTextField()
   {
      return lastNameTextField.getText();
   }

   public int getCprTextField()
   {
      return Integer.parseInt(cprTextField.getText());
   }

   public int getPhoneTextField()
   {
      return Integer.parseInt(phoneTextField.getText());
   }

   public String getEmailTextField()
   {
      return emailTextField.getText();
   }

   public String getAddressTextField()
   {
      return addressTextField.getText();
   }

   public int getRefNoTextField()
   {
      return Integer.parseInt(refNoTextField.getText());
   }

   // setters

   public void setFirstnameTextField(JTextField firstnameTextField)
   {
      this.firstnameTextField = firstnameTextField;
   }

   public void setLastNameTextField()
   {
      this.lastNameTextField = null;
   }

   public void setCprTextField(JTextField cprTextField)
   {
      this.cprTextField = cprTextField;
   }

   public void setPhoneTextField(JTextField phoneTextField)
   {
      this.phoneTextField = phoneTextField;
   }

   public void setEmailTextField(JTextField emailTextField)
   {
      this.emailTextField = emailTextField;
   }

   public void setAddressTextField(JTextField addressTextField)
   {
      this.addressTextField = addressTextField;
   }

   public BookTiketGUI(ClientController controller)
         throws ClassNotFoundException, SQLException
   {

      setLayout(new GridLayout(12, 6, 8, 8));

      // Add labels and text fields to the frame#
      this.controller = controller;

      JLabel refNum = new JLabel("Reference Number");
      add(refNum);
      refNoTextField = new JTextField(6);
      add(refNoTextField);
      ClientModelManager manager = new ClientModelManager();
      int text = 0;
      try
      {
         text = manager.getLastSoldTicket();
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      text += 1;
      refNoTextField.setText("" + text);
      refNoTextField.setEditable(false);

      JLabel CPR = new JLabel("CPR");
      add(CPR);
      cprTextField = new JTextField(10);
      add(cprTextField);

      JLabel Lname = new JLabel("Last Name");
      add(Lname);
      lastNameTextField = new JTextField(10);
      add(lastNameTextField);

      JLabel Fname = new JLabel("Firs Name");
      add(Fname);
      firstnameTextField = new JTextField(10);
      add(firstnameTextField);

      JLabel phone = new JLabel("Phone");
      add(phone);
      phoneTextField = new JTextField(10);
      add(phoneTextField);

      JLabel Email = new JLabel("Email");
      add(Email);
      emailTextField = new JTextField(10);
      add(emailTextField);

      JLabel address = new JLabel("Address");
      add(address);
      addressTextField = new JTextField(10);
      add(addressTextField);

      JButton confirm = new JButton("Confirm");
      add(confirm);

      JButton cancel = new JButton("Cancel");
      add(cancel);

      confirm.addActionListener(this);

      cancel.addActionListener(this);

      setTitle("Book Ticket UI");
      setSize(600, 400);
      setLocationRelativeTo(null); // Center the frame
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

   public String[] getPurchaseInfo()
   {
      String[] input = new String[7];

      input[0] = refNoTextField.getText();
      input[1] = cprTextField.getText();
      input[2] = lastNameTextField.getText();
      input[3] = firstnameTextField.getText();
      input[4] = phoneTextField.getText();
      input[5] = emailTextField.getText();
      input[6] = addressTextField.getText();

      return input;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (!(e.getSource() instanceof JButton))
         return;

      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Cancel"))
      {
         try
         {
            controller.execute("Cancel");
         }
         catch (RemoteException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }

      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Confirm"))
      {
         try
         {
            controller.execute("Confirm");

         }
         catch (RemoteException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }
   }

}
