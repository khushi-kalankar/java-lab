import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            MyRemoteInterface stub = new MyRemoteImpl();

            // Start the RMI registry
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the object
            registry.rebind("HelloService", stub);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

