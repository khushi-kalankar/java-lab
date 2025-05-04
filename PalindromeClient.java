import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class PalindromeClient {
    public static void main(String[] args) {
        try {
            // Get the RMI registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            // Lookup the remote object
            PalindromeInterface stub = (PalindromeInterface) registry.lookup("PalindromeService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a string or number to check for palindrome: ");
            String input = scanner.nextLine();

            // Call the remote method
            boolean result = stub.checkPalindrome(input);

            if (result) {
                System.out.println("\"" + input + "\" is a palindrome.");
            } else {
                System.out.println("\"" + input + "\" is not a palindrome.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
