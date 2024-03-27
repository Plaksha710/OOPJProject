package CRMS01;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class vrecords extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    vrecords frame = new vrecords();
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
    public vrecords() {
        setTitle("Victim record-");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 515, 382);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.controlHighlight);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("All the victim records are :");
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(143, 35, 222, 25);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(lblNewLabel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 70, 456, 253);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        JButton btnback = new JButton("Back");
        btnback.setBackground(new Color(0, 0, 128));
        btnback.setForeground(new Color(255, 255, 255));
        btnback.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		vrecords.this.dispose();
				dashboard d1 = new dashboard();
				d1.setVisible(true);
        	}
        });
        btnback.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnback.setBounds(0, 0, 77, 25);
        contentPane.add(btnback);
        
        displayVictimRecords();
    }

    private void displayVictimRecords() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/record", "root", "plaksha");
            Statement st = con.createStatement();
            String query = "SELECT * FROM VictimStatement";
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            
            DefaultTableModel model = new DefaultTableModel();
            int cols = rsmd.getColumnCount();
            for (int i = 1; i <= cols; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            
            while (rs.next()) {
                Object[] row = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }
            
            table.setModel(model);
            
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

