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
import java.util.Date;
import java.util.StringTokenizer;

public class Server_Receiver {

	static boolean running = true;
	static long tiempoAntes = new Date().getTime();
	static int controlImpresion = 0;

	public static void main(String[] args) {

		try {
			System.setProperty("java.net.preferIPv4Stack", "true");
			String inter = "interface";
			NetworkInterface ni = NetworkInterface.getByName(inter);
			InetAddress group = InetAddress.getByName("239.0.0.55");

			DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET)
					.setOption(StandardSocketOptions.SO_REUSEADDR, true).bind(new InetSocketAddress(12345))
					.setOption(StandardSocketOptions.IP_MULTICAST_IF, ni);
			MembershipKey key = dc.join(group, ni);
			DatagramSocket socket = dc.socket();
			while (running) {
				DatagramPacket packet;
				byte[] buf = new byte[256];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				byte[] bytes = packet.getData();
				long tiempoAhora = new Date().getTime();
				if (controlImpresion > 30) {
					System.out.println("\n");
					controlImpresion = 0;
				} else {
					controlImpresion++;
				}
				tiempoAntes = tiempoAhora;
				String received = new String(bytes);

					if (received.length()>2 && received.startsWith("A"))
					{
						try {		
							System.out.println(received);
							StringTokenizer stringTokenizer = new StringTokenizer(received, "|");
							stringTokenizer.nextToken();//Descartar las AA
						    String idrobot = stringTokenizer.nextToken();
						    String numMando = stringTokenizer.nextToken();
						    String mac = stringTokenizer.nextToken();
							System.out.println(idrobot);
							System.out.println(numMando);
							System.out.println(mac);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
			}
			Thread.sleep(2000);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
