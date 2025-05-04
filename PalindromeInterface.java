import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PalindromeInterface extends Remote {
    boolean checkPalindrome(String input) throws RemoteException;
}
