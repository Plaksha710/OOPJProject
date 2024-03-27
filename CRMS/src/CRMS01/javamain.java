package CRMS01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class javamain {

	private JFrame frame;
	private JTextField txtuname;
	private JTable table;
	private JTextField textField;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					javamain window = new javamain();
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
	public javamain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 974, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CRIMINAL RECORD MANAGEMENT SYSTEM");
		lblNewLabel.setBounds(350, 10, 356, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 62, 283, 105);
		panel.setBorder(new TitledBorder(null, "User Authentication:", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("Tahoma", Font.BOLD, 12));
		username.setBounds(52, 24, 72, 31);
		panel.add(username);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Tahoma", Font.BOLD, 12));
		password.setBounds(52, 52, 72, 31);
		panel.add(password);
		
		txtuname = new JTextField();
		txtuname.setBounds(134, 31, 96, 19);
		panel.add(txtuname);
		txtuname.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(134, 59, 96, 19);
		panel.add(txtpass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 19, 253, 2);
		panel.add(separator);
		
		JButton btnsubmit = new JButton("SUBMIT");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtuname.getText();
				String password = txtpass.getText();
				
				if(username.contains("Draco")&&password.contains("malfoy"))
				{
					txtuname.setText(null);
					txtpass.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Credentials!","Try again.",JOptionPane.ERROR_MESSAGE);
					txtuname.setText(null);
					txtpass.setText(null);
				}
			
			}
		});
		btnsubmit.setBounds(42, 165, 81, 28);
		frame.getContentPane().add(btnsubmit);
		
		JButton btnreset = new JButton("RESET");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtuname.setText(null);
				txtpass.setText(null);
			}
		});
		btnreset.setBounds(124, 165, 81, 28);
		frame.getContentPane().add(btnreset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(313, 60, 599, 168);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search Bar:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 203, 283, 77);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Criminal ID:");
		lblNewLabel_1.setBounds(10, 26, 97, 13);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 23, 155, 19);
		panel_1.add(textField);
		
		JButton btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnupdate.setBounds(313, 232, 107, 35);
		frame.getContentPane().add(btnupdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(423, 232, 107, 35);
		frame.getContentPane().add(btnDelete);
		
		JButton btnSort = new JButton("SORT");
		btnSort.setBounds(533, 232, 107, 35);
		frame.getContentPane().add(btnSort);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(208, 165, 81, 28);
		frame.getContentPane().add(btnExit);
	}
}
