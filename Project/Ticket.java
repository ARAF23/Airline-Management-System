package Project;

public class Ticket {
   private Flight flightOb;
   private Passenger passengerOb;
   private double price;
   private int number;
   private static int count = 0;

   public Ticket(Flight flightOb, Passenger passengerOb, double price) {
      ++count;
      this.flightOb = flightOb;
      this.passengerOb = passengerOb;
      this.price = price;
      this.number = count;
   }

   public Flight getFlight() {
      return this.flightOb;
   }

   public void setFlight(Flight F) {
      this.flightOb = F;
   }

   public Passenger getPassenger() {
      return this.passengerOb;
   }

   public void setPassenger(Passenger P) {
      this.passengerOb = P;
   }

   public double getPrice() {
      return this.price;
   }

   public void setPrice(double P) {
      this.price = P;
   }

   public int getNumber() {
      return this.number;
   }

   public void setNumber(int n) {
      this.number = n;
   }

   public int getCount() {
      if (count == 1) {
         System.out.println("\nYou are the only passenger in this flight");
      } else if (count > 1) {
         System.out.println("\nYou and " + (count - 1) + " other in the flight");
      }

      return count;
   }

   public void setCount(int n) {
      count = n;
   }

   public String toString() {
      return "Seat Number : " + this.passengerOb.getSeat() + "\nPassenger name : " + this.passengerOb.getName() + "\nPassenger Age:" + this.passengerOb.getAge() + "\nFlight: " + this.flightOb.getFlightNumber() + "\nOrigin: " + this.flightOb.getOrigin() + "\nDeparture: " + this.flightOb.getDestination() + "\nOriginal price: " + this.flightOb.getPrice() + "$\nTicket price: " + this.price + "$\nSeat booked: " + this.getCount() + "\nSeat left: " + this.flightOb.getNumberOfSeatsleft();
   }
}
