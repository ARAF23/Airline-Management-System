package Project;

import java.util.Scanner;

public class Flight {
   private int flightNumber;
   private String origin;
   private String destination;
   private String departureTime;
   private int capacity;
   private int numberOfSeatsleft;
   private double originalPrice;

   public Flight(int flightNumber, String origin, String destination, String departureTime, int seatLeft, double op) {
      Scanner in = new Scanner(System.in);
      if (destination.equalsIgnoreCase(origin)) {
         try {
            throw new Exception("destination and origin are the same");
         } catch (Exception var10) {
            System.out.println(var10);
            System.out.println("Enter new destination : ");
            destination = in.nextLine();
         }
      }

      this.flightNumber = flightNumber;
      this.origin = origin;
      this.destination = destination;
      this.departureTime = departureTime;
      this.capacity = seatLeft;
      this.numberOfSeatsleft = seatLeft;
      this.originalPrice = op;
   }

   public void bookASeat() {
      --this.numberOfSeatsleft;
   }

   public double getPrice() {
      return this.originalPrice;
   }

   public String getOrigin() {
      return this.origin;
   }

   public String getDestination() {
      return this.destination;
   }

   public String getDepartureTime() {
      return this.departureTime;
   }

   public int getFlightNumber() {
      return this.flightNumber;
   }

   public int getNumberOfSeatsleft() {
      return this.numberOfSeatsleft;
   }

   public int getCapacity() {
      return this.capacity;
   }

   public void setPrice(double Originalprice) {
      this.originalPrice = Originalprice;
   }

   public void setOrigin(String origin) {
      this.origin = origin;
   }

   public void setDestination(String destination) {
      this.destination = destination;
   }

   public void setDepartureTime(String departureTime) {
      this.departureTime = departureTime;
   }

   public void setFlightNumber(int flightNumber) {
      this.flightNumber = flightNumber;
   }

   public void setNumberOfSeatsleft(int numberOfSeatsleft) {
      this.numberOfSeatsleft = numberOfSeatsleft;
   }

   public void setCapacity(int capacity) {
      this.capacity = capacity;
   }

   public String toString() {
      return "\nFlight : " + this.flightNumber + "\nOrigin :" + this.origin + "\nDestination : " + this.destination
            + "\nDeparture time : " + this.departureTime + "\nSeat Left : " + this.numberOfSeatsleft
            + "\nOriginal Price : " + this.originalPrice + " $";
   }
}
