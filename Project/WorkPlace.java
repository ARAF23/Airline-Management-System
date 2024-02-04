package Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkPlace {
   ArrayList<Flight> flightsList = new ArrayList();
   ArrayList<Ticket> ticketsList = new ArrayList();

   public void createFlights() {
      try {
         new File("myFile.txt");
         FileWriter myFile = new FileWriter("myFile.txt");
         Scanner in1 = new Scanner(System.in);
         Scanner in2 = new Scanner(System.in);
         Scanner in3 = new Scanner(System.in);
         System.out.println("\nEnter flight Number");
         int flightNum = in1.nextInt();
         System.out.println("Enter flight origin");
         String origin = in2.nextLine();
         System.out.println("Enter flight destination");
         String destination = in2.nextLine();
         System.out.println("Enter flight departure time and date");
         String departureTime = in2.nextLine();
         System.out.println("Enter flight capacity");
         int capacity = in1.nextInt();
         System.out.println("Enter original price of ticket");
         double realPrice = in3.nextDouble();
         Flight flight = new Flight(flightNum, origin, destination, departureTime, capacity, realPrice);
         System.out.println("\nFlight " + flightNum + " has been created:");
         this.flightsList.add(flight);
         myFile.write(flight.toString());
         myFile.close();
         BufferedReader br = new BufferedReader(new FileReader("myFile.txt"));

         for(String content = br.readLine(); content != null; content = br.readLine()) {
            System.out.println(content);
         }
      } catch (IOException var16) {
         System.out.println("Error occured");
      }

   }

   public Flight getFlight(int flightNumber, String origin, String destination) {
      int len = this.flightsList.size();

      for(int i = 0; i < len; ++i) {
         if (((Flight)this.flightsList.get(i)).getFlightNumber() == flightNumber && ((Flight)this.flightsList.get(i)).getOrigin().equalsIgnoreCase(origin) && ((Flight)this.flightsList.get(i)).getDestination().equalsIgnoreCase(destination)) {
            return (Flight)this.flightsList.get(i);
         }
      }

      return null;
   }

   public Ticket getInformations(int flightNumber, String origin, String destination) {
      int size = this.flightsList.size();

      for(int i = 0; i < size; ++i) {
         if (((Flight)this.flightsList.get(i)).getFlightNumber() == flightNumber && ((Flight)this.flightsList.get(i)).getOrigin().equalsIgnoreCase(origin) && ((Flight)this.flightsList.get(i)).getDestination().equalsIgnoreCase(destination)) {
            return (Ticket)this.ticketsList.get(i);
         }
      }

      return null;
   }

   public void displayAvailableFlights(String origin, String destination) {
      int len = this.flightsList.size();

      for(int i = 0; i < len; ++i) {
         String from = ((Flight)this.flightsList.get(i)).getOrigin();
         String to = ((Flight)this.flightsList.get(i)).getDestination();
         int seats = ((Flight)this.flightsList.get(i)).getNumberOfSeatsleft();
         if (from.equalsIgnoreCase(origin) && to.equalsIgnoreCase(destination) && seats > 0) {
            System.out.println("List of available flights:");
            System.out.println();
            System.out.println(this.flightsList.get(i));
         }
      }

   }

   public Flight changeInfo(int flightNumber, String origin, String destination) {
      Scanner in4 = new Scanner(System.in);
      Scanner in5 = new Scanner(System.in);
      Scanner in6 = new Scanner(System.in);
      int len = this.flightsList.size();

      for(int i = 0; i < len; ++i) {
         String from = ((Flight)this.flightsList.get(i)).getOrigin();
         String to = ((Flight)this.flightsList.get(i)).getDestination();
         if (((Flight)this.flightsList.get(i)).getFlightNumber() == flightNumber && from.equalsIgnoreCase(origin) && to.equalsIgnoreCase(destination)) {
            System.out.println("Enter new departure time : ");
            String str = in4.nextLine();
            System.out.println("Enter new price : ");
            double newprice = in5.nextDouble();
            System.out.println("Enter new available sits : ");
            int newseat = in6.nextInt();
            ((Flight)this.flightsList.get(i)).setDepartureTime(str);
            ((Flight)this.flightsList.get(i)).setPrice(newprice);
            ((Flight)this.flightsList.get(i)).setNumberOfSeatsleft(newseat);
            return (Flight)this.flightsList.get(i);
         }
      }

      return null;
   }

   public Flight removeFlight(int flightnumber, String origin, String destination) {
      int len = this.flightsList.size();

      for(int i = 0; i < len; ++i) {
         String from = ((Flight)this.flightsList.get(i)).getOrigin();
         String to = ((Flight)this.flightsList.get(i)).getDestination();
         if (from.equalsIgnoreCase(origin) && to.equalsIgnoreCase(destination) && ((Flight)this.flightsList.get(i)).getFlightNumber() == flightnumber) {
            this.flightsList.remove(i);
            System.out.println("Flight removed");
         }
      }

      return null;
   }

   public Ticket bookSeat(int flightNumber, Passenger pass, String origin, String destination) {
      int size = this.flightsList.size();

      for(int i = 0; i < size; ++i) {
         int seats = ((Flight)this.flightsList.get(i)).getNumberOfSeatsleft();
         String from = ((Flight)this.flightsList.get(i)).getOrigin();
         String to = ((Flight)this.flightsList.get(i)).getDestination();
         if (from.equalsIgnoreCase(origin) && to.equalsIgnoreCase(destination) && ((Flight)this.flightsList.get(i)).getFlightNumber() == flightNumber) {
            System.out.println("\nAt flight " + flightNumber + ", " + seats + " seat avaiable");
         }

         if (from.equalsIgnoreCase(origin) && to.equalsIgnoreCase(destination) && ((Flight)this.flightsList.get(i)).getFlightNumber() == flightNumber && seats > 0) {
            ((Flight)this.flightsList.get(i)).bookASeat();
            double price = pass.applyDiscount(((Flight)this.flightsList.get(i)).getPrice());
            Ticket ticket = new Ticket((Flight)this.flightsList.get(i), pass, price);
            this.ticketsList.add(ticket);
            System.out.println("you have succesfully booked a seat for flight " + flightNumber);
            System.out.println("At flight " + flightNumber + ", " + (seats - 1) + " seat remains");
            return ticket;
         }

         if (seats == 0) {
            System.out.println("\nThe Flight " + flightNumber + " is full you cannot book a ticket for this flight");
         }
      }

      return null;
   }
}
