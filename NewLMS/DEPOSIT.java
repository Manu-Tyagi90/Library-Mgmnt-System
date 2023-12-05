package NewLMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.util.Locale;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import java.awt.Window.Type;
import javax.swing.JProgressBar;

public class DEPOSIT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField book_name;
	private JTextField author_name;
	private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DEPOSIT frame = new DEPOSIT();
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
	public DEPOSIT() {
		setResizable(false);
		setForeground(new Color(240, 240, 240));
		setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Downloads\\abc.png"));
		setTitle("LibraryManagementSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 534);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("BOOK NAME");
		lblName.setBounds(61, 166, 182, 26);
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Inter", Font.BOLD, 19));
		lblName.setBorder(null);
		lblName.setBackground(Color.GREEN);
		contentPane.add(lblName);
		
		JLabel lblName_1 = new JLabel("AUTHOR NAME");
		lblName_1.setBounds(61, 210, 182, 26);
		lblName_1.setForeground(new Color(255, 255, 255));
		lblName_1.setFont(new Font("Inter", Font.BOLD, 19));
		lblName_1.setBorder(null);
		lblName_1.setBackground(Color.GREEN);
		contentPane.add(lblName_1);
		
		String[] Type ={"Fiction","Computer Programming","Cooking"};
		JComboBox type = new JComboBox<Object>(Type) ;
		type.setForeground(new Color(0, 0, 0));
		type.setBounds(303, 254, 251, 26);
		type.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		type.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		type.setLocale(new Locale("aa"));
		type.setFont(new Font("Inter", Font.BOLD, 19));
		type.setModel(new DefaultComboBoxModel(new String[] {"Fiction", "Computer Programming", "Cooking"}));
		contentPane.add(type);
		
		JLabel lblName_1_1 = new JLabel("TYPE");
		lblName_1_1.setBounds(61, 252, 182, 29);
		lblName_1_1.setForeground(new Color(255, 255, 255));
		lblName_1_1.setFont(new Font("Inter", Font.BOLD, 19));
		lblName_1_1.setBorder(null);
		lblName_1_1.setBackground(Color.GREEN);
		contentPane.add(lblName_1_1);
		
		book_name = new JTextField();
		book_name.setFont(new Font("Inter", Font.BOLD, 19));
		book_name.setForeground(new Color(0, 0, 0));
		book_name.setBounds(303, 166, 251, 26);
		contentPane.add(book_name);
		book_name.setColumns(10);
		
		author_name = new JTextField();
		author_name.setFont(new Font("Inter", Font.BOLD, 19));
		author_name.setForeground(new Color(0, 0, 0));
		author_name.setBounds(303, 208, 251, 26);
		author_name.setColumns(10);
		contentPane.add(author_name);
		
		JButton btnValidate = new JButton("ADD BOOK");
		btnValidate.setBounds(61, 324, 493, 39);
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","123456");
					PreparedStatement ps = con.prepareStatement("insert into book_details values (?,?,?)");
					ps.setString(1, book_name.getText());
					ps.setString(2, author_name.getText());
					System.out.println(type.getSelectedItem());
					ps.setString(3, (String) type.getSelectedItem());
					
					if ( book_name.getText().isEmpty() || author_name.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Please Fill the Text-Field ");
					}
					
					else {
						int i = ps.executeUpdate();
						lblNewLabel_1.setVisible(true);
						Thread.sleep(500);
						JOptionPane.showMessageDialog(btnValidate,i+" Book is  Added");
						book_name.setText("");
						author_name.setText("");
						type.setSelectedIndex(0);
						lblNewLabel_1.setVisible(false);
					}
					ps.close();
					con.close();
					
					
				}
				
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnValidate.setBackground(new Color(0, 128, 192));
		btnValidate.setFont(new Font("Inter", Font.BOLD, 19));
		contentPane.add(btnValidate);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(0, 0, 610, 105);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Library-Management-System");
		lblNewLabel.setBounds(39, 20, 523, 59);
		desktopPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBorder(null);
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 35));
		
		lblNewLabel_1 = new JLabel("📖Book is Added");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Inter", Font.BOLD, 19));
		lblNewLabel_1.setBounds(201, 399, 154, 26);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
	}
}
