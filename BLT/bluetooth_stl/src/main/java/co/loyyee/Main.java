package co.loyyee;


import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;

public class Main {
	public static void main(String[] args) {
		try {
			LocalDevice dev = LocalDevice.getLocalDevice();
			String mac = dev.getBluetoothAddress();
			System.out.println("Address:" + mac);
			DiscoveryAgent agent = dev.getDiscoveryAgent();
			System.out.println(dev.getFriendlyName());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}