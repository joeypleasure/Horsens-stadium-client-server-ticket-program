package ticket.domain.model;

import java.io.Serializable;

public class FootballTicket extends Ticket implements Serializable
{

   private static final long serialVersionUID = 4419004503824043554L;

   public FootballTicket(int refNo, String eventName, String dateOfEvent,
         String eventPlace, double price, String sectorArea, String row,
         int seatNo)
   {
      super(refNo, eventName, dateOfEvent, eventPlace, price, sectorArea, row,
            seatNo);
   }

   @Override
   public int getRefNo()
   {
      // TODO Auto-generated method stub
      return refNo;
   }

   @Override
   public String getEventName()
   {
      // TODO Auto-generated method stub
      return super.getEventName();
   }

   @Override
   public void setEventName(String eventName)
   {
      // TODO Auto-generated method stub
      super.setEventName(eventName);
   }

   @Override
   public String getEventDate()
   {
      // TODO Auto-generated method stub
      return super.getEventDate();
   }

   @Override
   public void setEventDate(String eventDate)
   {
      // TODO Auto-generated method stub
      super.setEventDate(eventDate);
   }

   @Override
   public String getEventPlace()
   {
      // TODO Auto-generated method stub
      return super.getEventPlace();
   }

   @Override
   public void setEventPlace(String eventPlace)
   {
      // TODO Auto-generated method stub
      super.setEventPlace(eventPlace);
   }

   @Override
   public double getPrice()
   {
      // TODO Auto-generated method stub
      return super.getPrice();
   }

   @Override
   public void setPrice(double price)
   {
      // TODO Auto-generated method stub
      super.setPrice(price);
   }

   @Override
   public String getSectorArea()
   {
      // TODO Auto-generated method stub
      return super.getSectorArea();
   }

   @Override
   public void setSectorArea(String sectorArea)
   {
      // TODO Auto-generated method stub
      super.setSectorArea(sectorArea);
   }

   @Override
   public String getRow()
   {
      // TODO Auto-generated method stub
      return super.getRow();
   }

   @Override
   public void setRow(String row)
   {
      // TODO Auto-generated method stub
      super.setRow(row);
   }

   @Override
   public int getSeatNo()
   {
      // TODO Auto-generated method stub
      return super.getSeatNo();
   }

   @Override
   public void setSeatNo(int seatNo)
   {
      // TODO Auto-generated method stub
      super.setSeatNo(seatNo);
   }

   @Override
   public String toString()
   {
      return " Reference Number: " + refNo + " Event Name : " + eventName
            + " Event Date : " + eventDate + " Event Place : " + eventPlace
            + " Price : " + price + " Sector Area : " + sectorArea + " Row : "
            + row + " Seat No " + seatNo + "\n";
   }

}
