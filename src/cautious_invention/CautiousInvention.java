package cautious_invention;

import java.awt.FlowLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CautiousInvention {
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
		
		gui_builder window = new gui_builder();
		window.setInfo(serv1, serv2, serv3, serv4);
		window.frame.setVisible(true);
		
		logger.info("--------------------------------------------");
		logger.info("Starting logging at " + startTime);
		logger.info(serv1.toString());
		logger.info(serv2.toString());
		logger.info(serv3.toString());
		logger.info(serv4.toString());
		logger.info("--------------------------------------------");

		while (true) {
			System.out.println(window.isRunning());
			if (window.isRunning()) {
				System.out.println("CautiousInvention Downtime Monitor");
				System.out.println("Start Time  : " + startTime);
				window.updateStartTime(startTime);
				System.out.println("Current Time: " + getTime());
				window.updateCurrentTime(getTime());
				System.out.println("Elapsed Time: " + currentTime(getTimeMS(), startTimeMS));
				window.updateElapsedTime(currentTime(getTimeMS(), startTimeMS));
				
				window.updateDownTime(downTime);
				System.out.println("Pinging:");
				System.out.println("	" + serv1.toString());
				System.out.println("	" + serv2.toString());
				System.out.println("	" + serv3.toString());
				System.out.println("	" + serv4.toString());
				System.out.println("Current Response Time: ");
				

	
				try {
					long millis = System.currentTimeMillis();
	
					logger.info(getTime());
					
					window.updateTextField(1, serv1.ping());
					downTime = serv1.getLastOutage();
					window.updateDownTime(downTime);
					window.updateTextField(2, serv2.ping());
					downTime = serv2.getLastOutage();
					window.updateDownTime(downTime);
					window.updateTextField(3, serv3.ping());
					downTime = serv3.getLastOutage();
					window.updateDownTime(downTime);
					window.updateTextField(4 ,serv4.ping());
					downTime = serv4.getLastOutage();
					window.updateDownTime(downTime);
					
					logger.info("--------------------------------------------");
	
					Thread.sleep(5000 - millis % 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
