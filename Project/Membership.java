package Project;

public class Membership extends Passenger {
   private int yearsOfMembership;

   public Membership(int yom, int age, String name, String seat) {
      super(age, name, seat);
      this.yearsOfMembership = yom;
   }

   public double applyDiscount(double price) {
      if (this.age < 2) {
         price -= price * 100.0D / 100.0D;
         return price;
      } else if (this.yearsOfMembership > 5 && this.age > 70) {
         price -= price * 35.0D / 100.0D;
         return price;
      } else if (this.yearsOfMembership <= 5 && this.yearsOfMembership > 1 && this.age > 70) {
         price -= price * 25.0D / 100.0D;
         return price;
      } else {
         if (this.yearsOfMembership > 5 && this.age < 70 && this.age > 7) {
            price -= price * 20.0D / 100.0D;
         }

         return price;
      }
   }
}
