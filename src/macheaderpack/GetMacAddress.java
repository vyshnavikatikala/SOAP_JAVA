package macheaderpack;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class GetMacAddress {
	public static String getAddress() {
		InetAddress ip;
		StringBuilder sb = new StringBuilder();

		try {

			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());

			NetworkInterface network = NetworkInterface.getByInetAddress(ip);

			byte[] mac = network.getHardwareAddress();
			System.out.print("Current MAC address : ");

			for (int i = 0; i < mac.length; i++) {

				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));

			}
			System.out.println(sb.toString());

		}catch(Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(getAddress());
	}
}
