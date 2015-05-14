package ticket.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ticket.domain.controller.ClientController;

public class DisplayGUI extends JFrame implements ActionListener
{

   ClientController controller;

   private JTextArea area;

   private final int WINDOW_WIDTH = 720;
   private final int WINDOW_HEIGHT = 360;

   public DisplayGUI(ClientController controller)
   {
      super("Results");
      this.controller = controller;
      JPanel panel1 = new JPanel();
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      area = new JTextArea(10, 20);
      area.setEditable(false);
      JScrollPane scroll = new JScrollPane(area);
      scroll.setVisible(true);

      add(scroll);

   }

   public void result(String b)
   {
      area.setText(b);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // TODO Auto-generated method stub

   }

}