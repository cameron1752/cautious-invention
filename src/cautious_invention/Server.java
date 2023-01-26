package cautious_invention;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Server {
	final Logger logger = LogManager.getLogger(Server.class);
	private String ipAddress;
	private String hostName;
	private InetAddress address;
	private long start;
	private long finish;
	private long timeElapsed;
	private int timeout = 200;

	public Server(String hostName, String ipAddress) {
		this.ipAddress = ipAddress;
		this.hostName = hostName;
	}

	public void ping() {
		try {
			address = InetAddress.getByName(ipAddress);

			logger.info("Pinging this ipAddress: " + ipAddress);

			start = System.currentTimeMillis();

			if (address.isReachable(timeout)) {
				finish = System.currentTimeMillis();
				timeElapsed = finish - start;
				logger.info("reachable in " + timeElapsed + " ms");
			} else {
				finish = System.currentTimeMillis();
				timeElapsed = finish - start;
				logger.info("not reachable in " + timeElapsed + " ms");
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			logger.info("Host name not found: " + ipAddress);
			// logger.info(toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String toString() {
		return hostName + ": " + ipAddress + " with timeout of: " + timeout;

	}
}
