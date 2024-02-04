package Project;

import java.util.Scanner;

public class MainClass {
   public static void main(String[] args) {
      WorkPlace workplaceObj = new WorkPlace();
      Scanner input = new Scanner(System.in);
      Scanner input1 = new Scanner(System.in);
      int pin = 1111;
      boolean flag = true;
      System.out.println("\t\t\t\tWELCOME TO AIRLINE MANAGEMENT SYSTEM");
      System.out.println("\t\t\t\t\t     MAIN MENU");

      label88:
      do {
         System.out.println("\nEnter 1 for admin panel ");
         System.out.println("Enter 2 for passenger panel");
         System.out.println("Enter 3 for terminate the program");
         int in3 = input.nextInt();
         String destination;
         String origin;
         int flight_num;
         int in;
         switch(in3) {
         case 1:
            System.out.println("Enter the pin");
            int PIN = input.nextInt();
            if (pin == PIN) {
               System.out.println("\nEnter 1 if you want to create a flight ");
               System.out.println("Enter 2 if you want to display informations of a flight");
               System.out.println("Enter 3 if you want to change the informations of a flight");
               System.out.println("Enter 4 if you want to remove an existing flight");
               System.out.println("Enter 5 if you want to exit");
               in = input.nextInt();
               Flight flightObj;
               switch(in) {
               case 1:
                  System.out.println("How many flight you want to creat? ");
                  int fli = input.nextInt();
                  int i = 1;

                  while(true) {
                     if (i > fli) {
                        continue label88;
                     }

                     workplaceObj.createFlights();
                     ++i;
                  }
               case 2:
                  System.out.println("Enter the Flight number");
                  flight_num = input.nextInt();
                  System.out.println("Enter the Flight origin");
                  origin = input1.nextLine();
                  System.out.println("Enter the Flight destination");
                  destination = input1.nextLine();
                  flightObj = workplaceObj.getFlight(flight_num, origin, destination);
                  if (flightObj == null) {
                     System.out.println("Flight " + flight_num + " does not exist");
                  } else {
                     System.out.println("Information of Flight " + flight_num + " is :");
                     System.out.println(flightObj.toString());
                  }
                  continue;
               case 3:
                  System.out.println("Enter the flight number");
                  flight_num = input.nextInt();
                  System.out.println("Enter the Flight origin");
                  origin = input1.nextLine();
                  System.out.println("Enter the Flight destination");
                  destination = input1.nextLine();
                  flightObj = workplaceObj.changeInfo(flight_num, origin, destination);
                  if (flightObj == null) {
                     System.out.println("Flight" + flight_num + " does not exists");
                  } else {
                     System.out.println("\nInformations of the flight has changed successfully.");
                     System.out.println("\nNew informations of the flight" + flight_num + ":");
                     System.out.println();
                     System.out.println(flightObj.toString());
                  }
                  continue;
               case 4:
                  System.out.println("Enter the flight number");
                  flight_num = input.nextInt();
                  System.out.println("Enter the Flight origin");
                  origin = input1.nextLine();
                  System.out.println("Enter the Flight destination");
                  destination = input1.nextLine();

                  try {
                     flightObj = workplaceObj.removeFlight(flight_num, origin, destination);
                     if (flightObj == null) {
                        System.out.println("Flight" + flight_num + " does not exists");
                     }
                  } catch (Exception var25) {
                     System.out.println(var25);
                  }
                  continue;
               case 5:
                  System.out.println("You have exited from admin panel");
                  continue;
               default:
                  System.out.println("Invalid option!.. please enter 1,2,3,or 4");
                  continue;
               }
            }

            System.out.println("Invalid Pin. Try again");
            break;
         case 2:
            System.out.println("Enter 1 if you want to see available flights");
            System.out.println("Enter 2 if you want to book a seat");
            System.out.println("Enter 3 if you want to see information of your booked flight");
            System.out.println("Enter 4 if you want to exit passenger panel");
            int in1 = input.nextInt();
            Ticket ticketObj;
            switch(in1) {
            case 1:
               System.out.println("Enter flight origin");
               origin = input1.nextLine();
               System.out.println("Enter flight destination");
               destination = input1.nextLine();
               workplaceObj.displayAvailableFlights(origin, destination);
               continue;
            case 2:
               System.out.println("\nEnter 1 if you are non member");
               System.out.println("Enter 2 if you are a member");
               System.out.println("Enter 3 for going back to the passenger panel");
               in = input.nextInt();
               if (in == 1 || in == 2) {
                  System.out.println("Enter passengers name");
                  String name = input1.nextLine();
                  System.out.println("Enter passengers age");
                  int age = input.nextInt();
                  System.out.println("Enter passengers seat");
                  String seat = input1.nextLine();
                  System.out.println("Enter flight number");
                  flight_num = input.nextInt();
                  System.out.println("Enter the Flight origin");
                  origin = input1.nextLine();
                  System.out.println("Enter the Flight destination");
                  destination = input1.nextLine();
                  if (in == 1) {
                     NonMembership passengerObj = new NonMembership(age, name, seat);

                     try {
                        ticketObj = workplaceObj.bookSeat(flight_num, passengerObj, origin, destination);
                        if (ticketObj == null) {
                           System.out.println("Flight not found");
                        } else {
                           System.out.println(ticketObj.toString());
                        }
                     } catch (Exception var24) {
                        System.out.println(var24);
                     }
                  } else {
                     if (in != 2) {
                        return;
                     }

                     System.out.println("For how many years you have been a member");
                     int years = input.nextInt();
                     Membership passengerObj = new Membership(years, age, name, seat);

                     try {
                        ticketObj = workplaceObj.bookSeat(flight_num, passengerObj, origin, destination);
                        if (ticketObj == null) {
                           System.out.println("Flight not found");
                        } else {
                           System.out.println(ticketObj.toString());
                        }
                     } catch (Exception var23) {
                        System.out.println(var23);
                     }
                  }
               }
               continue;
            case 3:
               System.out.println("Enter Flight number");
               flight_num = input.nextInt();
               System.out.println("Enter the Flight origin");
               origin = input1.nextLine();
               System.out.println("Enter the Flight destination");
               destination = input1.nextLine();
               ticketObj = workplaceObj.getInformations(flight_num, origin, destination);
               if (ticketObj == null) {
                  System.out.println("Flight " + flight_num + " does not exist");
               } else {
                  System.out.println("Info for Flight " + flight_num + ":");
                  System.out.println(ticketObj.toString());
               }
               continue;
            case 4:
               System.out.println("You have exited from passenger panel");
               continue;
            default:
               System.out.println("Please enter 1,2,3,or4");
               continue;
            }
         case 3:
            System.out.println("Program Termitaned");
            System.exit(0);
            break;
         default:
            System.out.println("Invalid option. Please enter 1,2, or 3");
         }
      } while(flag);

   }
}
