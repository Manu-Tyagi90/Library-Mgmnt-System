package NewLMS;

import LibraryManagementSystem.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class RegistrationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField password;
	private JTextField uname;
	private JTextField mail;
	private JTextField mob;
	private JTextField txtName;
	private JTextField txtadd;
	private JTextField age;
	private JRadioButton rbMale;
	private JRadioButton rbFemale;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	public RegistrationForm() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Euphorigenic", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\abc.png"));
		setTitle("Registration Form");
		setBounds(100, 100, 974, 566);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtadd.setText("");
				buttonGroup.clearSelection();
				age.setText("");
				mob.setText("");
				mail.setText("");
				uname.setText("");
				password.setText("");
				
			}
		});
		btnReset.setBackground(Color.WHITE);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnReset.setBounds(72, 455, 781, 39);
		contentPane.add(btnReset);
		
		JButton btnValidate = new JButton("Create Account");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","123456");
					PreparedStatement ps = con.prepareStatement( "insert into registration values(?,?,?,?,?,?,?,?)");
					ps.setString(1, txtName.getText());
					ps.setString(2,txtadd.getText());
					if (rbMale.isSelected()==true) 
						ps.setString(3,rbMale.getText());
					
					else 
						ps.setString(3,rbFemale.getText());
				
					ps.setInt(4,Integer.parseInt(age.getText()));
					ps.setInt(5,Integer.parseInt(mob.getText()));
					ps.setString(6, mail.getText());
					ps.setString(7, uname.getText());
					ps.setString(8, password.getText());
					
					int i = ps.executeUpdate();
					
					JOptionPane.showMessageDialog(btnValidate,i+" Record Added");
					ps.close();
					con.close();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnValidate.setBackground(Color.WHITE);
		btnValidate.setForeground(Color.BLACK);
		btnValidate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnValidate.setBounds(72, 394, 781, 39);
		contentPane.add(btnValidate);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.BOLD, 19));
		password.setForeground(Color.BLACK);
		password.setColumns(10);
		password.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		password.setBackground(Color.WHITE);
		password.setBounds(688, 308, 165, 34);
		contentPane.add(password);
		
		JLabel pass = new JLabel("Password");
		pass.setForeground(Color.WHITE);
		pass.setFont(new Font("Tahoma", Font.BOLD, 19));
		pass.setBounds(541, 306, 119, 36);
		contentPane.add(pass);
		
		JLabel username = new JLabel("Username");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Tahoma", Font.BOLD, 19));
		username.setBounds(541, 236, 119, 36);
		contentPane.add(username);
		
		uname = new JTextField();
		uname.setFont(new Font("Tahoma", Font.BOLD, 19));
		uname.setForeground(Color.BLACK);
		uname.setColumns(10);
		uname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		uname.setBackground(Color.WHITE);
		uname.setBounds(688, 238, 165, 34);
		contentPane.add(uname);
		
		mail = new JTextField();
		mail.setFont(new Font("Tahoma", Font.BOLD, 19));
		mail.setForeground(Color.BLACK);
		mail.setColumns(10);
		mail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		mail.setBackground(Color.WHITE);
		mail.setBounds(688, 162, 165, 34);
		contentPane.add(mail);
		
		JLabel Email = new JLabel("Email");
		Email.setForeground(Color.WHITE);
		Email.setFont(new Font("Tahoma", Font.BOLD, 19));
		Email.setBounds(541, 160, 119, 36);
		contentPane.add(Email);
		
		JLabel mobile = new JLabel("Mobile No.");
		mobile.setForeground(Color.WHITE);
		mobile.setFont(new Font("Tahoma", Font.BOLD, 19));
		mobile.setBounds(541, 94, 119, 36);
		contentPane.add(mobile);
		
		mob = new JTextField();
		mob.setFont(new Font("Tahoma", Font.BOLD, 19));
		mob.setForeground(Color.BLACK);
		mob.setColumns(10);
		mob.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		mob.setBackground(Color.WHITE);
		mob.setBounds(688, 96, 165, 34);
		contentPane.add(mob);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setForeground(Color.WHITE);
		Gender.setFont(new Font("Tahoma", Font.BOLD, 19));
		Gender.setBounds(72, 238, 119, 34);
		contentPane.add(Gender);
		
		JLabel name = new JLabel("Name");
		name.setForeground(Color.WHITE);
		name.setFont(new Font("Tahoma", Font.BOLD, 19));
		name.setBounds(72, 94, 119, 36);
		contentPane.add(name);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtName.setForeground(Color.BLACK);
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(219, 96, 165, 34);
		contentPane.add(txtName);
		
		JLabel address = new JLabel("Address");
		address.setForeground(Color.WHITE);
		address.setFont(new Font("Tahoma", Font.BOLD, 19));
		address.setBounds(72, 160, 119, 36);
		contentPane.add(address);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 162, 165, 68);
		contentPane.add(scrollPane);
		
		txtadd = new JTextField();
		scrollPane.setViewportView(txtadd);
		txtadd.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtadd.setForeground(Color.BLACK);
		txtadd.setColumns(10);
		txtadd.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtadd.setBackground(Color.WHITE);
		
		JLabel agelabel = new JLabel("Age");
		agelabel.setForeground(Color.WHITE);
		agelabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		agelabel.setBounds(72, 306, 119, 36);
		contentPane.add(agelabel);
		
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.BOLD, 19));
		age.setForeground(Color.BLACK);
		age.setColumns(10);
		age.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		age.setBackground(Color.WHITE);
		age.setBounds(219, 308, 165, 34);
		contentPane.add(age);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setBounds(0, 0, 960, 529);
		contentPane.add(desktopPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 940, 64);
		desktopPane.add(panel);
		
		JButton btnback = new JButton("←Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login login = new Login();
				setVisible(false);
				login.setVisible(true);
				
			}
		});
		btnback.setHorizontalAlignment(SwingConstants.LEFT);
		btnback.setForeground(Color.WHITE);
		btnback.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnback.setBackground(Color.BLACK);
		panel.add(btnback);
		
		JLabel lblNewLabel = new JLabel("                            Register Here                           ");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBackground(Color.WHITE);
		
		 rbFemale = new JRadioButton("Female");
		rbFemale.setForeground(Color.WHITE);
		rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rbFemale.setBackground(Color.BLACK);
		rbFemale.setBounds(302, 242, 87, 36);
		desktopPane.add(rbFemale);
		
		rbMale = new JRadioButton("Male");
		rbMale.setForeground(Color.WHITE);
		rbMale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rbMale.setBackground(Color.BLACK);
		rbMale.setBounds(215, 242, 78, 36);
		desktopPane.add(rbMale);
	}
}
