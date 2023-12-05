package NewLMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Borrow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField aname;
	private JTextField type;
	private JTextField bname;
	private static JLabel lebel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrow frame = new Borrow();
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
	public Borrow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 722, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEPOSIT BOOK HERE");
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 33));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(168, 34, 372, 72);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home back = new Home();
				back.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Inter", Font.BOLD, 18));
		btnNewButton_1.setBounds(0, 10, 104, 31);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AUTHOR NAME");
		lblNewLabel_1_1.setFont(new Font("Inter", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(56, 261, 182, 46);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("TYPE");
		lblNewLabel_1_2.setFont(new Font("Inter", Font.BOLD, 19));
		lblNewLabel_1_2.setBounds(56, 339, 182, 46);
		contentPane.add(lblNewLabel_1_2);
		
		aname = new JTextField();
		aname.setFont(new Font("Tahoma", Font.BOLD, 20));
		aname.setColumns(10);
		aname.setBounds(304, 261, 263, 46);
		contentPane.add(aname);
		
		type = new JTextField();
		type.setFont(new Font("Tahoma", Font.BOLD, 20));
		type.setColumns(10);
		type.setBounds(304, 339, 263, 46);
		contentPane.add(type);
		
		JButton btnValidate = new JButton("DEPOSIT BOOK");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","123456");
					PreparedStatement ps = con.prepareStatement("delete from book_details where book_name = ? and author_name= ? and type = ?");
					ps.setString(1,bname.getText() );
					ps.setString(2,aname.getText() );
					ps.setString(3,type.getText() );
					
					if ( bname.getText().isEmpty() || aname.getText().isEmpty() || type.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please Fill the Text-Field ");
					}
					
					else {
						int i = ps.executeUpdate();
						
						if (i == 0) {
						JOptionPane.showMessageDialog(btnValidate,"No information Available");
						
						}
						
						else {
							lebel.setVisible(true);
							JOptionPane.showMessageDialog(btnValidate," Book is  Deposited");
							
						}
						bname.setText("");
						aname.setText("");
						type.setText("");
						lebel.setVisible(false);
					}
					ps.close();
					con.close();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Error 404!");
				}
				
			}
		});
		btnValidate.setForeground(new Color(255, 255, 255));
		btnValidate.setBackground(new Color(0, 0, 0));
		btnValidate.setFont(new Font("Inter", Font.BOLD, 20));
		btnValidate.setBounds(56, 425, 511, 46);
		contentPane.add(btnValidate);
		
		lebel = new JLabel("BOOK IS DEPOSITED");
		lebel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lebel.setBounds(205, 492, 197, 37);
		contentPane.add(lebel);
		
		JLabel lblNewLabel_1 = new JLabel("BOOK NAME");
		lblNewLabel_1.setFont(new Font("Inter", Font.BOLD, 19));
		lblNewLabel_1.setBounds(56, 183, 182, 46);
		contentPane.add(lblNewLabel_1);
		
		bname = new JTextField();
		bname.setFont(new Font("Tahoma", Font.BOLD, 20));
		bname.setColumns(10);
		bname.setBounds(304, 187, 263, 46);
		contentPane.add(bname);
		lebel.setVisible(false);
	}
}
