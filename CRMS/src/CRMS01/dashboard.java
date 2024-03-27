package CRMS01;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.ImageIcon; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dashboard() {
		setTitle("Dashboard - ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 608);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("CRIMINAL RECORD MANAGEMENT SYSTEM");
		heading.setForeground(new Color(0, 0, 128));
		heading.setBounds(202, 22, 617, 51);
		heading.setBackground(new Color(233, 150, 122));
		heading.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(heading);
		
		JSeparator sep_1 = new JSeparator();
		sep_1.setBounds(0, 486, 391, 2);
		contentPane.add(sep_1);
		
		JSeparator sep_2 = new JSeparator();
		sep_2.setBounds(415, 171, 2, 376);
		sep_2.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(sep_2);
		
		JButton btnlogout = new JButton("LOGOUT");
		btnlogout.setBounds(20, 514, 129, 33);
		btnlogout.setForeground(new Color(255, 255, 255));
		btnlogout.setBackground(new Color(0, 0, 128));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"         Logging Out!","LogOut--",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		});
		btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnlogout);
		
		JSeparator sep_3 = new JSeparator();
		sep_3.setBounds(0, 86, 939, 2);
		contentPane.add(sep_3);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBounds(449, 181, 462, 44);
		btnsearch.setForeground(new Color(255, 255, 255));
		btnsearch.setBackground(new Color(0, 0, 128));
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard.this.dispose();
				table t1 = new table();
				t1.setVisible(true);
				
			}
		});
		btnsearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnsearch);
		
		JButton btnmodify = new JButton("Modify");
		btnmodify.setBounds(449, 270, 462, 44);
		btnmodify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard.this.dispose();
				Crud c1 = new Crud();
				c1.setVisible(true);
			}
		});
		btnmodify.setForeground(new Color(255, 255, 255));
		btnmodify.setBackground(new Color(0, 0, 128));
		btnmodify.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnmodify);
		
		JButton btncases = new JButton("Cases");
		btncases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashboard.this.dispose();
				Victim_Statement c1 = new Victim_Statement();
				c1.setVisible(true);
			}
		});
		btncases.setBounds(449, 361, 462, 44);
		btncases.setForeground(new Color(255, 255, 255));
		btncases.setBackground(new Color(0, 0, 128));
		btncases.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btncases);
		
		JButton btnhelp = new JButton("Help");
		btnhelp.setBounds(449, 444, 462, 44);
		btnhelp.setBackground(new Color(0, 0, 128));
		btnhelp.setForeground(new Color(255, 255, 255));
		btnhelp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnhelp);
		
		JLabel icon = new JLabel("");
		icon.setBounds(54, 10, 245, 91);
		Image img = new ImageIcon(this.getClass().getResource("/icon1.png")).getImage();
		icon.setIcon(new ImageIcon(img));
		contentPane.add(icon);
		
		JLabel lbl01 = new JLabel("Welcome to the CRMS DashBoard!!");
		lbl01.setForeground(new Color(0, 0, 139));
		lbl01.setBackground(SystemColor.info);
		lbl01.setHorizontalAlignment(SwingConstants.CENTER);
		lbl01.setToolTipText("");
		lbl01.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbl01.setBounds(20, 94, 919, 44);
		contentPane.add(lbl01);
		
		JLabel lbl02 = new JLabel("Manage and track criminal records efficiently.");
		lbl02.setForeground(new Color(25, 25, 112));
		lbl02.setToolTipText("");
		lbl02.setHorizontalAlignment(SwingConstants.LEFT);
		lbl02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl02.setBounds(25, 170, 366, 38);
		contentPane.add(lbl02);
		
		JLabel lblSearchForSpecific = new JLabel("Search for specific records quickly and easily.");
		lblSearchForSpecific.setForeground(new Color(25, 25, 112));
		lblSearchForSpecific.setToolTipText("");
		lblSearchForSpecific.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearchForSpecific.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchForSpecific.setBounds(25, 216, 366, 44);
		contentPane.add(lblSearchForSpecific);
		
		JSeparator sep_1_1 = new JSeparator();
		sep_1_1.setBounds(0, 148, 939, 2);
		contentPane.add(sep_1_1);
		
		JLabel lbl03 = new JLabel("Add new records with detailed information.");
		lbl03.setForeground(new Color(25, 25, 112));
		lbl03.setToolTipText("");
		lbl03.setHorizontalAlignment(SwingConstants.LEFT);
		lbl03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl03.setBounds(25, 270, 366, 44);
		contentPane.add(lbl03);
		
		JLabel lbl04 = new JLabel("Update existing records seamlessly.");
		lbl04.setForeground(new Color(25, 25, 112));
		lbl04.setToolTipText("");
		lbl04.setHorizontalAlignment(SwingConstants.LEFT);
		lbl04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl04.setBounds(25, 324, 366, 44);
		contentPane.add(lbl04);
		
		JLabel lbl05 = new JLabel("Delete outdated or irrelevant records.");
		lbl05.setForeground(new Color(25, 25, 112));
		lbl05.setToolTipText("");
		lbl05.setHorizontalAlignment(SwingConstants.LEFT);
		lbl05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl05.setBounds(20, 378, 366, 44);
		contentPane.add(lbl05);
		
		JLabel lbl06 = new JLabel("Monitor case status and progress.");
		lbl06.setForeground(new Color(25, 25, 112));
		lbl06.setToolTipText("");
		lbl06.setHorizontalAlignment(SwingConstants.LEFT);
		lbl06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl06.setBounds(20, 421, 366, 44);
		contentPane.add(lbl06);
	}
}
