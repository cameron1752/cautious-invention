package cautious_invention;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;  

public class CautiousInvention {
	final static Logger logger = LogManager.getLogger(CautiousInvention.class); 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();  
		
		Server serv1 = new Server("Google DNS","8.8.8.8");
		Server serv2 = new Server("CLoudflair","1.0.0.1");
		Server serv3 = new Server("Google DNS 2","8.8.4.4");
		Server serv4 = new Server("router","192.168.50.1");
			
		while (true) {
			
			try {
				long millis = System.currentTimeMillis();
				
				logger.info(getTime());
				
				serv1.ping();
		
				serv2.ping();
				
				serv3.ping();
				
				serv4.ping();
				
				logger.info("----------------------");
			
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

}
