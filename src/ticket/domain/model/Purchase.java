package ticket.domain.model;

import java.io.Serializable;

public class Purchase implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -7419185904062682787L;
   // private FootballTicket footballticket;

   private int refNo;
   private int cpr;
   private String firstName, lastName;
   private int phoneNo;
   private String email;
   private String address;

   public Purchase(int refNo, int cpr, String firstName, String lastName,
         int phoneNo, String email, String address)
   {
      this.refNo = refNo;
      this.cpr = cpr;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNo = phoneNo;
      this.email = email;
      this.address = address;
   }

   public int getRefNo()
   {
      return refNo;
   }

   public void setRefNo(int refNo)
   {
      this.refNo = refNo;
   }

   public int getCpr()
   {
      return cpr;
   }

   public void setCpr(int cpr)
   {
      this.cpr = cpr;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public int getPhoneNo()
   {
      return phoneNo;
   }

   public void setPhoneNo(int phoneNo)
   {
      this.phoneNo = phoneNo;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public String getAddress()
   {
      return address;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }

   @Override
   public String toString()
   {
      return "Purchase: refNo=" + refNo + ", cpr=" + cpr + ", firstName="
            + firstName + ", lastName=" + lastName + ", phoneNo=" + phoneNo
            + ", email=" + email + ", address=" + address + "\n";
   }

}
