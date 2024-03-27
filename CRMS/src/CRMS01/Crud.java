package CRMS01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class Crud extends JFrame {
	

	Connection con;
	PreparedStatement pst;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtrecordid;
	private JTextField txtcriminalname;
	private JTextField txtdob;
	private JTextField txtgender;
	private JTextField txtaddress;
	private JTextField txtcrimetype;
	private JTextField txtcrimedate;
	private JTextField txtcrimelocation;
	private JTextField txtcasestatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crud frame = new Crud();
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
	public Crud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 610);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel heading = new JLabel("Modify:");
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setFont(new Font("Tahoma", Font.BOLD, 25));
		heading.setBounds(366, 25, 223, 42);
		contentPane.add(heading);
		
		JLabel lblrecordid = new JLabel("Record ID:");
		lblrecordid.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblrecordid.setBounds(139, 94, 139, 28);
		contentPane.add(lblrecordid);
		
		JLabel lblCriminalName = new JLabel("Criminal Name:");
		lblCriminalName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCriminalName.setBounds(125, 196, 175, 28);
		contentPane.add(lblCriminalName);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDateOfBirth.setBounds(125, 241, 175, 28);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGender.setBounds(125, 279, 139, 35);
		contentPane.add(lblGender);
		
		JLabel lbladdress = new JLabel("Address:");
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbladdress.setBounds(125, 324, 139, 28);
		contentPane.add(lbladdress);
		
		JLabel lblcrimetype = new JLabel("Crime Type:");
		lblcrimetype.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblcrimetype.setBounds(125, 362, 139, 28);
		contentPane.add(lblcrimetype);
		
		JLabel lblcrimedate = new JLabel("Crime Date:");
		lblcrimedate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblcrimedate.setBounds(125, 400, 139, 28);
		contentPane.add(lblcrimedate);
		
		JLabel lblcrimelocation = new JLabel("Crime Location:");
		lblcrimelocation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblcrimelocation.setBounds(125, 438, 175, 28);
		contentPane.add(lblcrimelocation);
		
		JLabel lblcasestatus = new JLabel("Case Status:");
		lblcasestatus.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblcasestatus.setBounds(125, 480, 139, 28);
		contentPane.add(lblcasestatus);
		
		txtrecordid = new JTextField();
		txtrecordid.setBounds(317, 94, 298, 42);
		contentPane.add(txtrecordid);
		txtrecordid.setColumns(10);
		
		txtcriminalname = new JTextField();
		txtcriminalname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtcriminalname.setColumns(10);
		txtcriminalname.setBounds(317, 196, 303, 28);
		contentPane.add(txtcriminalname);
		
		txtdob = new JTextField();
		txtdob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtdob.setColumns(10);
		txtdob.setBounds(317, 241, 303, 28);
		contentPane.add(txtdob);
		
		txtgender = new JTextField();
		txtgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtgender.setColumns(10);
		txtgender.setBounds(317, 286, 303, 28);
		contentPane.add(txtgender);
		
		txtaddress = new JTextField();
		txtaddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtaddress.setColumns(10);
		txtaddress.setBounds(317, 324, 303, 28);
		contentPane.add(txtaddress);
		
		txtcrimetype = new JTextField();
		txtcrimetype.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtcrimetype.setColumns(10);
		txtcrimetype.setBounds(317, 362, 303, 28);
		contentPane.add(txtcrimetype);
		
		txtcrimedate = new JTextField();
		txtcrimedate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtcrimedate.setColumns(10);
		txtcrimedate.setBounds(317, 400, 303, 28);
		contentPane.add(txtcrimedate);
		
		txtcrimelocation = new JTextField();
		txtcrimelocation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtcrimelocation.setColumns(10);
		txtcrimelocation.setBounds(317, 438, 303, 28);
		contentPane.add(txtcrimelocation);
		
		txtcasestatus = new JTextField();
		txtcasestatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtcasestatus.setColumns(10);
		txtcasestatus.setBounds(317, 480, 303, 28);
		contentPane.add(txtcasestatus);
		
		JButton btninsert = new JButton("Insert");
		btninsert.setForeground(new Color(255, 255, 255));
		btninsert.setBackground(new Color(0, 0, 128));
		btninsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean insertSuccess = maintainance(1);
				if (insertSuccess) {
		            JOptionPane.showMessageDialog(null, "Record Added Successfully......!!!", "DaComputers", JOptionPane.INFORMATION_MESSAGE);
		        }
		        maintainance(5);
			}
		});
		btninsert.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btninsert.setBounds(687, 211, 191, 42);
		contentPane.add(btninsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 0, 128));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean updateSuccess = maintainance(2);
		        if (updateSuccess) {
		            JOptionPane.showMessageDialog(null, "Record Updated Successfully......!!!", "DaComputers", JOptionPane.INFORMATION_MESSAGE);
		        }
		        maintainance(5);
		    }
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnUpdate.setBounds(687, 285, 191, 42);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(0, 0, 128));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean deleteSuccess = maintainance(4);
		        if (deleteSuccess) {
		            JOptionPane.showMessageDialog(null, "Record Deleted Successfully......!!!", "DaComputers", JOptionPane.INFORMATION_MESSAGE);
		        }
		        maintainance(5);
		    }
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDelete.setBounds(687, 362, 191, 42);
		contentPane.add(btnDelete);
		
		JButton btnclear = new JButton("Clear");
		btnclear.setForeground(new Color(255, 255, 255));
		btnclear.setBackground(new Color(0, 0, 128));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maintainance(5);	
			}
		});
		btnclear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnclear.setBounds(687, 438, 191, 42);
		contentPane.add(btnclear);
		
		JButton btnfind = new JButton("Find");
		btnfind.setForeground(new Color(255, 255, 255));
		btnfind.setBackground(new Color(0, 0, 128));
		btnfind.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        maintainance(3);
		    }
		});

		btnfind.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnfind.setBounds(687, 94, 191, 42);
		contentPane.add(btnfind);
		
		JButton btnback = new JButton("Back");
		btnback.setForeground(new Color(255, 255, 255));
		btnback.setBackground(new Color(0, 0, 128));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crud.this.dispose();
				dashboard d1 = new dashboard();
				d1.setVisible(true);
			}
		});
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnback.setBounds(0, 0, 85, 35);
		contentPane.add(btnback);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 72, 957, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 157, 957, 2);
		contentPane.add(separator_1);
	}

	public boolean maintainance(int value) {
	    boolean success = false;
	    try {
	        String recordid = txtrecordid.getText();
	        String criminalname = txtcriminalname.getText();
	        String dob = txtdob.getText();
	        String gender = txtgender.getText();
	        String address = txtaddress.getText();
	        String crimetype = txtcrimetype.getText();
	        String crimedate = txtcrimedate.getText();
	        String crimelocation = txtcrimelocation.getText();
	        String casestatus = txtcasestatus.getText();

	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/record","root","plaksha");
	        
	        switch(value) {
	            // Inserting record
	            case 1:
	                pst=con.prepareStatement("INSERT INTO criminalrecords (CriminalName, DateOfBirth, Gender, Address, CrimeType, CrimeDate, CrimeLocation, CaseStatus) VALUES (?,?,?,?,?,?,?,?)");
	                pst.setString(1, criminalname);
	                pst.setString(2, dob);
	                pst.setString(3, gender);
	                pst.setString(4, address);
	                pst.setString(5, crimetype);
	                pst.setString(6, crimedate);
	                pst.setString(7, crimelocation);
	                pst.setString(8, casestatus);
	                pst.executeUpdate();
	                pst.close();
	                success = true;
	                break;

	            // Updating database
	            case 2:
	                pst = con.prepareStatement("UPDATE criminalrecords SET CriminalName=?, DateOfBirth=?, Gender=?, Address=?, CrimeType=?, CrimeDate=?, CrimeLocation=?, CaseStatus=? WHERE RecordID=?");
	                pst.setString(1, criminalname);
	                pst.setString(2, dob);
	                pst.setString(3, gender);
	                pst.setString(4, address);
	                pst.setString(5, crimetype);
	                pst.setString(6, crimedate);
	                pst.setString(7, crimelocation);
	                pst.setString(8, casestatus);
	                pst.setString(9, recordid); // Set recordid parameter at the correct index
	                pst.executeUpdate();
	                pst.close();
	                success = true;
	                break;

	            // Displaying database
	            case 3:
	                pst = con.prepareStatement("SELECT * FROM criminalrecords WHERE RecordID=?");
	                pst.setString(1, recordid);
	                ResultSet rs = pst.executeQuery();
	                if (rs.next()) {
	                    txtcriminalname.setText(rs.getString(2)); // Assuming "CriminalName" is the second column in your query result
	                    txtdob.setText(rs.getString(3)); // Assuming "DateOfBirth" is the third column
	                    txtgender.setText(rs.getString(4)); // Assuming "Gender" is the fourth column
	                    txtaddress.setText(rs.getString(5)); // Assuming "Address" is the fifth column
	                    txtcrimetype.setText(rs.getString(6)); // Assuming "CrimeType" is the sixth column
	                    txtcrimedate.setText(rs.getString(7)); // Assuming "CrimeDate" is the seventh column
	                    txtcrimelocation.setText(rs.getString(8)); // Assuming "CrimeLocation" is the eighth column
	                    txtcasestatus.setText(rs.getString(9)); // Assuming "CaseStatus" is the ninth column
	                    success = true;
	                } else {
	                    JOptionPane.showMessageDialog(null, "Couldn't find the record!");
	                    maintainance(5); 

	                }
	                rs.close();
	                break;

	            // Deleting the records
	            case 4:
	                pst = con.prepareStatement("DELETE FROM criminalrecords WHERE RecordID=?");
	                pst.setString(1,recordid);
	                pst.executeUpdate();
	                pst.close();
	                success = true;
	                break;

	            // Clearing the text-boxes after performing the operations
	            case 5:
	                txtrecordid.setText("");
	                txtcriminalname.setText("");
	                txtdob.setText("");
	                txtgender.setText("");
	                txtaddress.setText("");
	                txtcrimetype.setText("");
	                txtcrimedate.setText("");
	                txtcrimelocation.setText("");
	                txtcasestatus.setText("");
	                break;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}
}