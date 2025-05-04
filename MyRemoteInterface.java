import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteInterface extends Remote {
    String sayHello(String name) throws RemoteException;
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
}

