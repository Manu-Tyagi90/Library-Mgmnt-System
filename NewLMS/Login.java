package NewLMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import LibraryManagementSystem.DEPOSIT;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField uname;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("Student Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 419);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Here");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(160, 22, 230, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter username");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(79, 108, 169, 37);
		contentPane.add(lblNewLabel_1_2);
		
		uname = new JTextField();
		uname.setForeground(Color.WHITE);
		uname.setFont(new Font("Tahoma", Font.PLAIN, 19));
		uname.setColumns(10);
		uname.setBackground(Color.BLACK);
		uname.setBounds(276, 109, 223, 37);
		contentPane.add(uname);
		
		password = new JTextField();
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.PLAIN, 19));
		password.setColumns(10);
		password.setBackground(Color.BLACK);
		password.setBounds(276, 177, 223, 37);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_1_1.setBounds(78, 176, 170, 37);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Sign in");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				Statement stm = null;
				ResultSet rs = null;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","123456");
					PreparedStatement ps = con.prepareStatement("select username,password from registration where username =? and password= ?");
					ps.setString(1,uname.getText());
					ps.setString(2, password.getText());
					rs = ps.executeQuery();
					
					
					if (rs.next()) {
						setVisible(false);
						Home home = new Home();
						home.setVisible(true);
						
					} else {
								JOptionPane.showMessageDialog(null, "Incorrect username or Password");
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(79, 260, 169, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnSignUp_1 = new JButton("Sign up");
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationForm form = new RegistrationForm();
				setVisible(false);
				form.setVisible(true);
				
			}
		});
		btnSignUp_1.setForeground(Color.WHITE);
		btnSignUp_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSignUp_1.setBackground(Color.BLACK);
		btnSignUp_1.setBounds(310, 260, 169, 37);
		contentPane.add(btnSignUp_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 559, 388);
		contentPane.add(panel);
	}
}
