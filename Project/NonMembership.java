package Project;

public class NonMembership extends Passenger {
   public NonMembership(int age, String name, String seat) {
      super(age, name, seat);
   }

   public double applyDiscount(double price) {
      if (this.age < 2) {
         price -= price * 100.0D / 100.0D;
      } else if (this.age > 70) {
         price -= price * 15.0D / 100.0D;
         return price;
      }

      return price;
   }
}
