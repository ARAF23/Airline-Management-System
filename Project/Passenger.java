package Project;

public abstract class Passenger {
   String name;
   int age;
   String seat;

   public Passenger(int age, String name, String seat) {
      this.name = name;
      this.age = age;
      this.seat = seat;
   }

   public String getName() {
      return this.name;
   }

   public String getSeat() {
      return this.seat;
   }

   public int getAge() {
      return this.age;
   }

   public abstract double applyDiscount(double var1);
}
