package ticket.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ticket.domain.controller.ClientController;

public class CancelTiketGUI extends JFrame implements ActionListener
{
   private ClientController controller;

   private JTextField refNoTextField;

   public int getRefNoTextField()
   {
      return Integer.parseInt(refNoTextField.getText());
   }

   public CancelTiketGUI(ClientController controller)
   {

      setLayout(new GridLayout(4, 8, 5, 5));

      this.controller = controller;
      JLabel text = new JLabel("Please enter the Tiket refNum:");
      add(text);

      refNoTextField = new JTextField(8);
      add(refNoTextField);

      JButton confirm = new JButton("Confirm cancellation");
      add(confirm);

      JButton cancel = new JButton("Cancel");
      add(cancel);

      confirm.addActionListener(this);
      cancel.addActionListener(this);

      setTitle("Cancel Tikets");
      setSize(400, 150);
      setLocationRelativeTo(null); // Center the frame
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

   public String[] getCancelInput()
   {
      String[] input = new String[1];

      input[0] = refNoTextField.getText();

      return input;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (!(e.getSource() instanceof JButton))
         return;
      if (((JButton) e.getSource()).getText().equalsIgnoreCase(
            "Confirm cancellation"))
      {
         try
         {
            controller.execute("Confirm cancellation");
         }
         catch (RemoteException e1)
         {
            e1.printStackTrace();
         }
      }
      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Cancel"))
      {
         try
         {
            controller.execute("Cancel");
         }
         catch (RemoteException e1)
         {
            e1.printStackTrace();
         }
      }
   }
}
