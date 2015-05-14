package ticket.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ticket.domain.controller.ClientController;

public class LoginGUI extends JFrame implements ActionListener
{

   private JLabel user;
   private JLabel pass;
   private JTextField text1, text2;
   private ClientController controller;
   private final int WINDOW_WIDTH = 360;
   private final int WINDOW_HEIGHT = 120;
   JButton Login = new JButton("Login");

   public LoginGUI(ClientController controller)
   {

      super("Please login");
      this.controller = controller;
      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      panel1.setLayout(null);
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setLayout(new GridLayout(3, 1));
      user = new JLabel("Username:");
      pass = new JLabel("Password");
      text1 = new JTextField(12);
      text2 = new JTextField(12);
      JButton login = new JButton("Login");
      login.addActionListener(this);
      add(user);
      add(text1);
      add(pass);
      add(text2);
      panel2.add(login);
      getContentPane().add(panel1);
      getContentPane().add(panel2);
      user.setBounds(70, 30, 150, 20);
      pass.setBounds(70, 65, 150, 20);

      login.setBounds(110, 100, 80, 20);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public String[] getLoginInfo()
   {
      String[] input = new String[2];

      input[0] = text1.getText();
      input[1] = text2.getText();
      return input;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      if (!(e.getSource() instanceof JButton))
         return;

      if (((JButton) e.getSource()).getText().equalsIgnoreCase("Login"))
      {
         try
         {
            controller.execute("Login");
         }
         catch (RemoteException e1)
         {

            e1.printStackTrace();
         }

      }
   }
}
