package POC_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.channels.DatagramChannel;
import java.nio.channels.MembershipKey;
import java.util.ArrayList;

public class Server_Sender {
	private static byte[] wifiControlArray = new byte[1 + (50 * 3)];

	public static void main(String[] args) {
		System.out.println("Begin");
		boolean running = true;
		try {

			System.setProperty("java.net.preferIPv4Stack", "true");
			String inter = "interface";
			NetworkInterface ni = NetworkInterface.getByName(inter);
			InetAddress group = InetAddress.getByName("239.0.0.57");

			DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET)
					.setOption(StandardSocketOptions.SO_REUSEADDR, true).bind(new InetSocketAddress(12345))
					.setOption(StandardSocketOptions.IP_MULTICAST_IF, ni);
			MembershipKey key = dc.join(group, ni);
			DatagramSocket socket = dc.socket();

			while (running) {
				
				byte separator = (byte)'|';
				byte initial = (byte)'A';
				System.out.println("Asociando robot " + 1 + " a mando " + 1);
				byte[] id = String.valueOf(1).getBytes();
				wifiControlArray[0]= initial;
				wifiControlArray[1]= initial;
				wifiControlArray[2]= separator;
				wifiControlArray[3]= id[0];
				wifiControlArray[4]= separator;		
				byte[] dataForUDP = wifiControlArray;
				DatagramPacket msgPacket = new DatagramPacket(dataForUDP, dataForUDP.length, group, 12345);
				socket.send(msgPacket);
				Thread.sleep(2000);
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
