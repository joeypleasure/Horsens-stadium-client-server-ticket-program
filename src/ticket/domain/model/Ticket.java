package ticket.domain.model;

import java.io.Serializable;

public abstract class Ticket implements Serializable
{
   int refNo;
   String eventName;
   String eventDate;
   String eventPlace;
   double price;
   String sectorArea;
   String row;
   int seatNo;

   protected Ticket(int refNo, String eventName, String dateOfEvent,
         String eventPlace, double price, String sectorArea, String row,
         int seatNo)
   {
      this.refNo = refNo;
      this.eventName = eventName;
      this.eventDate = dateOfEvent;
      this.eventPlace = eventPlace;
      this.price = price;
      this.sectorArea = sectorArea;
      this.row = row;
      this.seatNo = seatNo;
   }

   public int getRefNo()
   {
      return refNo;
   }

   public String getEventName()
   {
      return eventName;
   }

   public void setEventName(String eventName)
   {
      this.eventName = eventName;
   }

   public String getEventDate()
   {
      return eventDate;
   }

   public void setEventDate(String eventDate)
   {
      this.eventDate = eventDate;
   }

   public String getEventPlace()
   {
      return eventPlace;
   }

   public void setEventPlace(String eventPlace)
   {
      this.eventPlace = eventPlace;
   }

   public double getPrice()
   {
      return price;
   }

   public void setPrice(double price)
   {
      this.price = price;
   }

   public String getSectorArea()
   {
      return sectorArea;
   }

   public void setSectorArea(String sectorArea)
   {
      this.sectorArea = sectorArea;
   }

   public String getRow()
   {
      return row;
   }

   public void setRow(String row)
   {
      this.row = row;
   }

   public int getSeatNo()
   {
      return seatNo;
   }

   public void setSeatNo(int seatNo)
   {
      this.seatNo = seatNo;
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
