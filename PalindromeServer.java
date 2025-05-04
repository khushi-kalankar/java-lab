import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class PalindromeServer extends UnicastRemoteObject implements PalindromeInterface {

    public PalindromeServer() throws RemoteException {
        super();
    }

    @Override
    public boolean checkPalindrome(String input) throws RemoteException {
        // Remove spaces and convert to lower case for case-insensitive comparison
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleanedInput).reverse().toString();

        // Check if input is equal to its reverse
        return cleanedInput.equals(reversed);
    }

    public static void main(String[] args) {
        try {
            PalindromeServer server = new PalindromeServer();
            // Create and bind the RMI registry
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("PalindromeService", server);
            System.out.println("Palindrome RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
