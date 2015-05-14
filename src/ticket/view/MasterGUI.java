package ticket.view;

import java.sql.SQLException;

import ticket.domain.controller.ClientController;

public class MasterGUI
{
   private MenuGUI menugui;
   private BookTiketGUI bookgui;
   private CancelTiketGUI cancelgui;
   private DisplayGUI displaygui;
   private SearchCustomerGUI searchgui;
   private ClientController controller;
   private LoginGUI logingui;

   public MasterGUI() throws ClassNotFoundException, SQLException
   {
      this.controller = new ClientController(this);

      logingui = new LoginGUI(controller);
      menugui = new MenuGUI(controller);
      bookgui = new BookTiketGUI(controller);
      cancelgui = new CancelTiketGUI(controller);
      displaygui = new DisplayGUI(controller);
      searchgui = new SearchCustomerGUI(controller);

      logingui.setVisible(true);
   }

   public MenuGUI getMenugui()
   {
      return menugui;
   }

   public void setMenugui(MenuGUI menugui)
   {
      this.menugui = menugui;
   }

   public BookTiketGUI getBookgui()
   {
      return bookgui;
   }

   public void setBookgui(BookTiketGUI bookgui)
   {
      this.bookgui = bookgui;
   }

   public CancelTiketGUI getCancelgui()
   {
      return cancelgui;
   }

   public void setCancelgui(CancelTiketGUI cancelgui)
   {
      this.cancelgui = cancelgui;
   }

   public DisplayGUI getDisplaygui()
   {
      return displaygui;
   }

   public void setDisplaygui(DisplayGUI displaygui)
   {
      this.displaygui = displaygui;
   }

   public SearchCustomerGUI getSearchgui()
   {
      return searchgui;
   }

   public void setSearchgui(SearchCustomerGUI searchgui)
   {
      this.searchgui = searchgui;
   }

   public LoginGUI getLogingui()
   {
      return logingui;
   }

   public void setLogingui(LoginGUI logingui)
   {
      this.logingui = logingui;
   }

   public String[] getPurchaseInput()
   {
      return bookgui.getPurchaseInfo();
   }

   public String[] getSearchInput()
   {
      return searchgui.getSearchInfo();
   }

   public String[] getLoginInput()
   {
      return logingui.getLoginInfo();
   }

   public String[] getCancelInput()
   {
      return cancelgui.getCancelInput();
   }

   public void showLogonGui(boolean show)
   {
      logingui.setVisible(show);
   }

   public void showMenuGui(boolean show)
   {
      menugui.setVisible(show);
   }

   public void showBookGui(boolean show)
   {
      bookgui.setVisible(show);
   }

   public void showCancelGui(boolean show)
   {
      cancelgui.setVisible(show);
   }

   public void showSearchGui(boolean show)
   {
      searchgui.setVisible(show);
   }

}
