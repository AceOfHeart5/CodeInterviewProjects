import java.util.*;

public class ExceptionExample {

    public void example() {

        try {
            int n1 = 5;
            System.out.println("The first number is: " + n1);
            int n2 = 0;
            System.out.println("The second number is: " + n2);
            System.out.print("The result is: ");
            int result = n1 / n2;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("You broke it!");
        }
    }
}
