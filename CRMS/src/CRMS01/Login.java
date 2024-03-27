package CRMS01;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.ImageIcon; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frmLoginPage;
	private JTextField txtuname;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setTitle("Login Page -");
		frmLoginPage.getContentPane().setBackground(SystemColor.controlHighlight);
		frmLoginPage.setBounds(200, 200, 368, 244);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JLabel Login = new JLabel("User Authentication:");
		Login.setForeground(new Color(0, 0, 128));
		Login.setBackground(new Color(205, 92, 92));
		Login.setHorizontalAlignment(SwingConstants.CENTER);
		Login.setFont(new Font("Tahoma", Font.BOLD, 14));
		Login.setBounds(0, 0, 354, 31);
		frmLoginPage.getContentPane().add(Login);
		
		JLabel uname = new JLabel("Username:");
		uname.setForeground(new Color(0, 0, 139));
		uname.setFont(new Font("Tahoma", Font.BOLD, 12));
		uname.setBounds(127, 63, 73, 13);
		frmLoginPage.getContentPane().add(uname);
		
		JLabel password = new JLabel("Password:");
		password.setForeground(new Color(0, 0, 139));
		password.setFont(new Font("Tahoma", Font.BOLD, 12));
		password.setBounds(127, 105, 73, 13);
		frmLoginPage.getContentPane().add(password);
		
		txtuname = new JTextField();
		txtuname.setBounds(210, 61, 96, 19);
		frmLoginPage.getContentPane().add(txtuname);
		txtuname.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(210, 103, 96, 19);
		frmLoginPage.getContentPane().add(txtpass);
		
		JSeparator sep_1 = new JSeparator();
		sep_1.setBounds(28, 39, 302, 2);
		frmLoginPage.getContentPane().add(sep_1);
		
		JButton btnsubmit = new JButton("SUBMIT");
		btnsubmit.setForeground(new Color(255, 255, 255));
		btnsubmit.setBackground(new Color(0, 0, 128));
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtuname.getText();
				String password = txtpass.getText();
				
				if(username.contains("Draco")&&password.contains("malfoy"))
				{
					frmLoginPage.dispose();
					dashboard d1 = new dashboard();
					d1.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"    Invalid Credentials!","Try again.",JOptionPane.ERROR_MESSAGE);
					txtuname.setText(null);
					txtpass.setText(null);
				}
			}
		});
		btnsubmit.setBounds(28, 155, 100, 31);
		frmLoginPage.getContentPane().add(btnsubmit);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(0, 0, 128));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtuname.setText(null);
				txtpass.setText(null);
			}
		});
		btnReset.setBounds(138, 155, 97, 31);
		frmLoginPage.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(0, 0, 128));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(245, 155, 85, 31);
		frmLoginPage.getContentPane().add(btnExit);
		
		JSeparator sep_2 = new JSeparator();
		sep_2.setBounds(28, 143, 302, 2);
		frmLoginPage.getContentPane().add(sep_2);
		
		JLabel iamge = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img1.png")).getImage();
		iamge.setIcon(new ImageIcon(img));
		iamge.setBounds(39, 63, 59, 59);
		frmLoginPage.getContentPane().add(iamge);
	}

}
