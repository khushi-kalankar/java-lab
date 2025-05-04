import java.net.*;
import java.io.*;
public class InetAddressExample {
    public static void main(String[] args) {
        try {
            // 1. Get InetAddress for a given hostname (e.g., google.com)
            InetAddress googleAddress = InetAddress.getByName("www.google.com");
            System.out.println("Google's IP Address: " + googleAddress.getHostAddress());

            // 2. Get InetAddress for the local host (your own machine)
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local Hostname: " + localAddress.getHostName());
            System.out.println("Local Host IP Address: " + localAddress.getHostAddress());

            // 3. Get InetAddress from an IP address (example using byte array for 8.8.8.8)
            byte[] ip = {(byte) 8, (byte) 8, (byte) 8, (byte) 8}; // IP for 8.8.8.8
            InetAddress addressFromIP = InetAddress.getByAddress(ip);
            System.out.println("IP Address from byte array: " + addressFromIP.getHostAddress());

            // 4. Checking if a host is reachable
            boolean isReachable = googleAddress.isReachable(2000);  // Timeout 2 seconds
            System.out.println("Is google.com reachable? " + isReachable);

            // 5. Display all IP addresses for the local host (hostname resolution)
            InetAddress[] localAddresses = InetAddress.getAllByName(localAddress.getHostName());
            System.out.println("All IP addresses for local host:");
            for (InetAddress addr : localAddresses) {
                System.out.println(addr.getHostAddress());
            }

        } catch (UnknownHostException e) {
            System.err.println("Host could not be resolved: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error while checking reachability: " + e.getMessage());
        }
    }
}
