package cautious_invention;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class gui_builder {

	public JFrame frame;
	private boolean isRunning = false;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_7;
	private JTextField textField_9;
	private JLabel lblNewLabel_8;
	private JTextField textField_10;
	private JLabel lblNewLabel_9;
	private JTextField textField_11;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_builder window = new gui_builder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui_builder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("Closing up shop");
			}
		});
		frame.setBounds(100, 100, 473, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cautious Invention Internet Uptime Monitor");
		lblNewLabel.setBounds(10, 11, 434, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(23, 69, 133, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Host");
		lblNewLabel_1.setBounds(23, 49, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(182, 69, 133, 25);
		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("IP Address");
		lblNewLabel_1_1.setBounds(182, 49, 78, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(23, 144, 133, 25);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(182, 144, 133, 25);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(23, 214, 133, 25);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(182, 214, 133, 25);
		frame.getContentPane().add(textField_5);
		
		lblNewLabel_2 = new JLabel("Host");
		lblNewLabel_2.setBounds(23, 119, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_1_2 = new JLabel("IP Address");
		lblNewLabel_1_2.setBounds(182, 119, 78, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		lblNewLabel_3 = new JLabel("Host");
		lblNewLabel_3.setBounds(23, 193, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_1_3 = new JLabel("IP Address");
		lblNewLabel_1_3.setBounds(182, 193, 78, 14);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(342, 71, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(342, 146, 86, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(342, 216, 86, 20);
		frame.getContentPane().add(textField_8);
		
		lblNewLabel_4 = new JLabel("Response Time");
		lblNewLabel_4.setBounds(342, 49, 105, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Response Time");
		lblNewLabel_5.setBounds(342, 119, 105, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Response Time");
		lblNewLabel_6.setBounds(342, 193, 105, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Start Monitoring");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Setting isRunning to true");
				setRunning(true);
				
			}
		});
		btnNewButton.setBounds(150, 405, 147, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Stop Monitoring");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Setting isRunning to false");
				setRunning(false);
			}
		});
		btnNewButton_1.setBounds(150, 439, 147, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_7 = new JLabel("Time Started");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(23, 349, 115, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setBounds(23, 374, 120, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Current Time");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(175, 349, 122, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		textField_10.setBounds(175, 374, 120, 20);
		frame.getContentPane().add(textField_10);
		
		lblNewLabel_9 = new JLabel("Elapsed Time");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(321, 349, 123, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(320, 374, 124, 20);
		frame.getContentPane().add(textField_11);
		
		lblNewLabel_1_4 = new JLabel("IP Address");
		lblNewLabel_1_4.setBounds(179, 263, 78, 14);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		lblNewLabel_10 = new JLabel("Host");
		lblNewLabel_10.setBounds(20, 263, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Response Time");
		lblNewLabel_11.setBounds(339, 263, 105, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(339, 286, 86, 20);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(179, 284, 133, 25);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(20, 284, 133, 25);
		frame.getContentPane().add(textField_14);
	}
	
	public void setInfo(Server serv1, Server serv2, Server serv3, Server serv4) {
		textField.setText(serv1.getHostName());
		textField_2.setText(serv2.getHostName());
		textField_4.setText(serv3.getHostName());
		textField_14.setText(serv4.getHostName());
		
		textField_1.setText(serv1.getIpAddress());
		textField_3.setText(serv2.getIpAddress());
		textField_5.setText(serv3.getIpAddress());
		textField_13.setText(serv4.getIpAddress());
	}
	
	public void updateTextField(Integer index, String text) {
		if (index == 1) {
			textField_6.setText(text);
		} else if (index == 2) {
			textField_7.setText(text);
		} else if (index == 3) {
			textField_8.setText(text);
		} else if (index == 4) {
			textField_12.setText(text);
		}
	}
	
	public void updateStartTime(String startTime) {
		textField_9.setText(startTime);
	}
	
	public void updateCurrentTime(String currentTime) {
		textField_10.setText(currentTime);
	}
	
	public void updateElapsedTime(String elapsedTime) {
		textField_11.setText(elapsedTime);
	}
	
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
}
