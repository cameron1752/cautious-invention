package cautious_invention;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class analyze {
	public void analyze() {
		
	}
	
	public static void main(String[] args) {
		doAnalyze();
	}
	
	public static void doAnalyze() {
		
		
		try {
			File file = new File("C:/Users/Cammy/eclipse-workspace/cautious_invention/status.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String myLine;
			java.sql.Timestamp saveTime;
			long start = 0;
			long lastTime = 0;
			int count = 0; 
			
			while ((myLine = br.readLine()) != null) {
				count++;
			}
			
			br = new BufferedReader(new FileReader(file));
			String myLines[][] = new String[count][5];
			count = 0;
			
			while ((myLine = br.readLine()) != null) {
				myLine = myLine.replace("]", "-");
				myLine = myLine.replace(" in ", "-");
				myLine = myLine.replace(": ", "-");		
				
				String mySplit[] = myLine.split("-");
				myLines[count][0] = mySplit[0].replace("[","").replace("/", "-");
				myLines[count][1] = mySplit[1];
				myLines[count][2] = mySplit[2];
				myLines[count][3] = mySplit[3];
				myLines[count][4] = mySplit[4];
						
				count++;
			}
			
			String temp = "";
			Long totalDowntime = (long) 0;
			int countDowntime = 0;
			Long maxDownTime = (long) 0;
			int lastLine = 0;
			
			for (int x = 0; x < count; x++) {
				long last = 0;
				
				// if able save previous time stamp
				if (x > 0) {
					java.sql.Timestamp ts = java.sql.Timestamp.valueOf(myLines[x - 1][0]);
					last = ts.getTime();
				}
				
				// save current time stamp
				java.sql.Timestamp ts = java.sql.Timestamp.valueOf(myLines[x][0]);
				long current = ts.getTime();
				
				// find difference
				long dif = current - last;
				
				
				
				if (dif > 60000 && x > 0) {
					// print up time
					System.out.println("Up from: " + myLines[x - 1][0] + " -> " + myLines[x][0] + " for " + currentTime(current, last));
					// print start of downtime
					System.out.println("Out at: " + myLines[x][0]);
					
					if (temp != "") {
//						System.out.println("Total downtime: " + currentTime(java.sql.Timestamp.valueOf(myLines[x-1][0]).getTime(), java.sql.Timestamp.valueOf(temp).getTime()));
//						java.sql.Timestamp tempDowntime = java.sql.Timestamp.valueOf();
						
						if (((java.sql.Timestamp.valueOf(myLines[x-1][0]).getTime() - java.sql.Timestamp.valueOf(temp).getTime())) > maxDownTime) {
							maxDownTime = (java.sql.Timestamp.valueOf(myLines[x-1][0]).getTime() - java.sql.Timestamp.valueOf(temp).getTime());
						}
						
						totalDowntime = totalDowntime + (java.sql.Timestamp.valueOf(myLines[x-1][0]).getTime() - java.sql.Timestamp.valueOf(temp).getTime());
						countDowntime++;
					}
					
					// save start of out time
					temp = myLines[x][0];
				} else {
					if (temp == "") {
						// print downtime data
						System.out.println("Out at: " + myLines[x][0]);
					}else {
						// print downtime data
						System.out.println("Out at: " + myLines[x][0] + " since: " + temp + " for: " + currentTime(java.sql.Timestamp.valueOf(myLines[x][0]).getTime(), java.sql.Timestamp.valueOf(temp).getTime()));
					}

				}
				lastLine = x;
			}
			float uptime = (totalDowntime / 1) * 100;
			System.out.println();
			System.out.println("Started Recording: " + myLines[0][0]);
			System.out.println("Finished Recording: " + myLines[lastLine][0]);
			System.out.println("Total downtime: " + currentTime(totalDowntime, 0));
			System.out.println("Number of downtimes: " + countDowntime);
			System.out.println("Avg downtime: " + currentTime(totalDowntime / countDowntime, 0));
			System.out.println("Max downtime: " + currentTime(maxDownTime, 0));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String currentTime(long now, long then) {
		long s = ((now - then) / 1000) % 60;
		long m = (((now - then) / 1000) / 60) % 60;
		long h = (((now - then) / 1000) / (60 * 60)) % 24;
		return String.format("%d:%02d:%02d", h, m, s);
	}
}
