package zadania;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) throws SocketException {
        ListNetsEx listNetsEx = new ListNetsEx ();
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            listNetsEx.displayInterfaceInformation(netint);

    }
}
class ListNetsEx {

    public static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        System.out.println("Display name: \n"+ netint.getDisplayName());
        System.out.println("Name: \n"+ netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();

        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            System.out.println("InetAddress: \n"+ inetAddress);
        }

        System.out.println("Up? \n"+ netint.isUp());
        System.out.println("Loopback? \n"+ netint.isLoopback());
        System.out.println("PointToPoint? \n"+ netint.isPointToPoint());
        System.out.println("Supports multicast? \n"+ netint.supportsMulticast());
        System.out.println("Virtual? \n"+ netint.isVirtual());
        System.out.println("Hardware address: \n"+
                Arrays.toString(netint.getHardwareAddress()));
        System.out.println("MTU: \n"+ netint.getMTU());
        System.out.println("\n");
    }
}
