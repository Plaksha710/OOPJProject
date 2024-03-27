package CRMS01;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.SystemColor;

public class Victim_Statement extends JFrame {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtlocation;
    private JTextField txtsname;
    private JTextField txtdate;
    private JTextField txtvname;
    private JTextArea txtarea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Victim_Statement frame = new Victim_Statement();
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
    public Victim_Statement() {
        setTitle("Victim Statement Form -");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 585, 524);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.controlHighlight);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Fill the following details :-");
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(149, 8, 251, 24);
        contentPane.add(lblNewLabel);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setForeground(new Color(0, 0, 139));
        lblname.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblname.setBounds(28, 56, 84, 24);
        contentPane.add(lblname);
        
        JLabel lbldate = new JLabel("Date :");
        lbldate.setForeground(new Color(0, 0, 139));
        lbldate.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbldate.setBounds(28, 99, 63, 24);
        contentPane.add(lbldate);
        
        JLabel lbllocation = new JLabel("Location :");
        lbllocation.setForeground(new Color(0, 0, 139));
        lbllocation.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbllocation.setBounds(28, 141, 95, 24);
        contentPane.add(lbllocation);
        
        JLabel lblsname = new JLabel("Suspect's Name :");
        lblsname.setForeground(new Color(0, 0, 139));
        lblsname.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblsname.setBounds(28, 185, 162, 24);
        contentPane.add(lblsname);
        
        JLabel lbldamages = new JLabel("Injuries/Damages :");
        lbldamages.setForeground(new Color(0, 0, 139));
        lbldamages.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbldamages.setBounds(28, 227, 182, 24);
        contentPane.add(lbldamages);
        
        txtlocation = new JTextField();
        txtlocation.setColumns(10);
        txtlocation.setBounds(299, 145, 239, 24);
        contentPane.add(txtlocation);
        
        txtsname = new JTextField();
        txtsname.setColumns(10);
        txtsname.setBounds(299, 189, 239, 24);
        contentPane.add(txtsname);
        
        txtdate = new JTextField();
        txtdate.setColumns(10);
        txtdate.setBounds(299, 103, 239, 24);
        contentPane.add(txtdate);
        
        txtvname = new JTextField();
        txtvname.setColumns(10);
        txtvname.setBounds(299, 60, 239, 24);
        contentPane.add(txtvname);
        
        JButton btnback1 = new JButton("BACK");
        btnback1.setForeground(new Color(255, 255, 255));
        btnback1.setBackground(new Color(0, 0, 128));
        btnback1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                dashboard d1 = new dashboard();
                d1.setVisible(true);
            }
        });
        btnback1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnback1.setBounds(0, 0, 63, 24);
        contentPane.add(btnback1);
        
        JButton btnregister = new JButton("Register");
        btnregister.setForeground(new Color(255, 255, 255));
        btnregister.setBackground(new Color(0, 0, 128));
        btnregister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String query = "INSERT INTO VictimStatement (VictimName, IncidentDate, Location, SuspectName, InjuriesDamages) VALUES (?, ?, ?, ?, ?)";
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/record","root","plaksha");
                    pst = con.prepareStatement(query);
                    pst.setString(1, txtvname.getText());
                    pst.setString(2, txtdate.getText());
                    pst.setString(3, txtlocation.getText());
                    pst.setString(4, txtsname.getText());
                    pst.setString(5, txtarea.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Registered Successfully!");
                    
                 // Clear input fields after successful registration
                    txtvname.setText("");
                    txtdate.setText("");
                    txtlocation.setText("");
                    txtsname.setText("");
                    txtarea.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } finally {
                    try {
                        if (pst != null) {
                            pst.close();
                        }
                        if (con != null) {
                            con.close();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });
        btnregister.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnregister.setBounds(375, 435, 115, 33);
        contentPane.add(btnregister);
        
        JButton btnclear = new JButton("Clear");
        btnclear.setForeground(new Color(255, 255, 255));
        btnclear.setBackground(new Color(0, 0, 128));
        btnclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtvname.setText("");
                txtdate.setText("");
                txtlocation.setText("");
                txtsname.setText("");
                txtarea.setText("");
            }
        });
        btnclear.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnclear.setBounds(8, 435, 115, 33);
        contentPane.add(btnclear);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(259, 56, 9, 351);
        contentPane.add(separator_1);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(8, 415, 555, 2);
        contentPane.add(separator_2);
        
        txtarea = new JTextArea();
        txtarea.setBounds(299, 230, 239, 162);
        contentPane.add(txtarea);
        
        JButton btndisplayall = new JButton("Display");
        btndisplayall.setForeground(new Color(255, 255, 255));
        btndisplayall.setBackground(new Color(0, 0, 128));
        btndisplayall.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Victim_Statement.this.dispose();
				vrecords c1 = new vrecords();
				c1.setVisible(true);
			}
        });

        
        
        btndisplayall.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btndisplayall.setBounds(138, 435, 115, 33);
        contentPane.add(btndisplayall);
        
    }
}
        