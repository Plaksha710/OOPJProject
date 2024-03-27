package CRMS01;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.RowFilter;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
public class table extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable data;
	private JTextField txtsearchdata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table frame = new table();
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
	public table() {
		setTitle("Table - ");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 436);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnview = new JButton("View");
		btnview.setForeground(new Color(255, 255, 255));
		btnview.setBackground(new Color(0, 0, 128));
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/record","root","plaksha");
				    Statement st = con.createStatement();
				    String query = "SELECT * FROM CriminalRecords";
				    ResultSet rs = st.executeQuery(query);
				    ResultSetMetaData rsmd = rs.getMetaData();
				   
				    DefaultTableModel model = (DefaultTableModel) data.getModel();

				    int cols = rsmd.getColumnCount();
				    String[] colNames = new String[cols];
				    for (int i = 0; i < cols; i++) {
				        colNames[i] = rsmd.getColumnName(i + 1);
				    }
				    model.setColumnIdentifiers(colNames);
				    
				    String RecordID, CriminalName, DateOfBirth, Gender, Address, CrimeType, CrimeDate, CrimeLocation, CaseStatus;
				    while(rs.next()) {
				    	RecordID=rs.getString(1);
				    	CriminalName=rs.getString(2);
				    	DateOfBirth=rs.getString(3);
				    	Gender=rs.getString(4);
				    	Address=rs.getString(5);
				    	CrimeType=rs.getString(6);
				    	CrimeDate=rs.getString(7);
				    	CrimeLocation=rs.getString(8);
				    	CaseStatus=rs.getString(9);
				    	String[] row= {RecordID, CriminalName, DateOfBirth, Gender, Address, CrimeType, CrimeDate, CrimeLocation, CaseStatus};
				    	model.addRow(row);
				    }
				    st.close();
				    st.close();

				} catch (ClassNotFoundException | SQLException e1) {
				    e1.printStackTrace();
				}

			}
		});
		btnview.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnview.setBounds(176, 74, 78, 33);
		contentPane.add(btnview);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(0, 0, 128));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.setModel(new DefaultTableModel());
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(264, 74, 78, 33);
		contentPane.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 137, 684, 220);
		contentPane.add(scrollPane);
		
		data = new JTable();
		scrollPane.setViewportView(data);
		
		JLabel label1 = new JLabel("The Criminal Records are given below ----");
		label1.setForeground(new Color(0, 0, 128));
		label1.setBackground(new Color(169, 169, 169));
		label1.setFont(new Font("Tahoma", Font.BOLD, 22));
		label1.setBounds(195, 10, 477, 33);
		contentPane.add(label1);
		
		JTextPane txtbox = new JTextPane();
		txtbox.setForeground(new Color(0, 0, 128));
		txtbox.setEditable(false);
		txtbox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtbox.setBackground(SystemColor.controlHighlight);
		txtbox.setText("Select an option:");
		txtbox.setBounds(10, 79, 144, 28);
		contentPane.add(txtbox);
		
		JButton btnback = new JButton("Back");
		btnback.setForeground(new Color(255, 255, 255));
		btnback.setBackground(new Color(0, 0, 128));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.this.dispose();
				dashboard d1 = new dashboard();
				d1.setVisible(true);
			}
		});
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnback.setBounds(0, 0, 92, 33);
		contentPane.add(btnback);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 809, 2);
		contentPane.add(separator);
		
		txtsearchdata = new JTextField();
		txtsearchdata.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				TableModel obj=data.getModel();
				TableRowSorter<TableModel> obj1 = new TableRowSorter<>(obj);
				data.setRowSorter(obj1);
				obj1.setRowFilter(RowFilter.regexFilter(txtsearchdata.getText()));
			}
		});
		txtsearchdata.setBounds(526, 77, 277, 33);
		contentPane.add(txtsearchdata);
		txtsearchdata.setColumns(10);
		
		JLabel searchdata = new JLabel("Search Data :");
		searchdata.setHorizontalAlignment(SwingConstants.CENTER);
		searchdata.setForeground(new Color(0, 0, 128));
		searchdata.setBackground(new Color(0, 0, 128));
		searchdata.setFont(new Font("Tahoma", Font.BOLD, 18));
		searchdata.setBounds(352, 76, 164, 28);
		contentPane.add(searchdata);
	}
}
