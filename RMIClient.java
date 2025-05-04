import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MyRemoteInterface stub = (MyRemoteInterface) registry.lookup("HelloService");

            // Call sayHello
            String greeting = stub.sayHello("Alice");
            System.out.println("Greeting: " + greeting);

            // Call add
            int sum = stub.add(10, 20);
            System.out.println("Addition (10 + 20): " + sum);

            // Call subtract
            int diff = stub.subtract(50, 15);
            System.out.println("Subtraction (50 - 15): " + diff);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
