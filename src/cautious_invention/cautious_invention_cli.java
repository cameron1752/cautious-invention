package cautious_invention;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class cautious_invention_cli {
	final static Logger logger = LogManager.getLogger(CautiousInvention.class);
	final static Logger statusLogger = LogManager.getLogger("OTHER_LOGGER");
	final static String startTime = getTime();
	final static long startTimeMS = System.currentTimeMillis();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String downTime = "";
		
		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.info");
		
		//GUIBuilder.guiBuilder();

		
		Server serv1 = new Server("Google DNS", "8.8.8.8");
		Server serv2 = new Server("CLoudflair", "1.0.0.1");
		Server serv3 = new Server("Google DNS 2", "8.8.4.4");
		Server serv4 = new Server("router", "192.168.50.1");
		
		logger.info("--------------------------------------------");
		logger.info("Starting logging at " + startTime);
		logger.info(serv1.toString());
		logger.info(serv2.toString());
		logger.info(serv3.toString());
		logger.info(serv4.toString());
		logger.info("--------------------------------------------");

		while (true) {
			System.out.println("CautiousInvention Downtime Monitor");
			System.out.println("Start Time  : " + startTime);
			System.out.println("Current Time: " + getTime());
			System.out.println("Elapsed Time: " + currentTime(getTimeMS(), startTimeMS));

			logger.info("CautiousInvention Downtime Monitor");
			logger.info("Start Time  : " + startTime);
			logger.info("Current Time: " + getTime());
			logger.info("Elapsed Time: " + currentTime(getTimeMS(), startTimeMS));
			
			System.out.println("Pinging:");
			System.out.println("	" + serv1.toString());
			System.out.println("	" + serv2.toString());
			System.out.println("	" + serv3.toString());
			System.out.println("	" + serv4.toString());
			System.out.println("Current Response Time: ");
			
			logger.info("Pinging:");
			logger.info("	" + serv1.toString());
			logger.info("	" + serv2.toString());
			logger.info("	" + serv3.toString());
			logger.info("	" + serv4.toString());
			logger.info("Current Response Time: ");

			try {
				long millis = System.currentTimeMillis();

				logger.info(getTime());
				
				serv1.ping();
				serv2.ping();
				serv3.ping();
				serv4.ping();
				
				downTime = serv1.getLastOutage();
				downTime = serv2.getLastOutage();
				downTime = serv3.getLastOutage();
				downTime = serv4.getLastOutage();
				
				logger.info("--------------------------------------------");

				Thread.sleep(5000 - millis % 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	
	public static String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return dtf.format(LocalDateTime.now());
	}

	public static String currentTime(long now, long then) {
		long s = ((now - then) / 1000) % 60;
		long m = (((now - then) / 1000) / 60) % 60;
		long h = (((now - then) / 1000) / (60 * 60)) % 24;
		return String.format("%d:%02d:%02d", h, m, s);
	}

	public static long getTimeMS() {
		return System.currentTimeMillis();
	}

}
