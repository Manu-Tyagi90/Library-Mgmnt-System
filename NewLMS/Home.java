package NewLMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 491);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 31, 406, 57);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("DEPOSIT BOOKS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(416, 31, 410, 57);
		contentPane.add(panel_1);
		
		JLabel lblDepositBooks = new JLabel("BORROW BOOKS");
		lblDepositBooks.setForeground(Color.WHITE);
		lblDepositBooks.setFont(new Font("Tahoma", Font.BOLD, 35));
		panel_1.add(lblDepositBooks);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(406, 31, 10, 423);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setLabelFor(lblNewLabel);
		lblNewLabel_1.setLocation(new Point(23, 100));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\borrow (1).jpg"));
		lblNewLabel_1.setBounds(71, 118, 214, 236);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setLabelFor(lblDepositBooks);
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\deposit (1).jpg"));
		lblNewLabel_1_1.setLocation(new Point(23, 100));
		lblNewLabel_1_1.setBounds(516, 141, 284, 236);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("DEPOSIT HERE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Borrow borrow = new Borrow();
				borrow.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setBounds(71, 372, 193, 51);
		contentPane.add(btnNewButton);
		
		JButton btnDepositHere = new JButton("BORROW HERE");
		btnDepositHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DEPOSIT deposit = new DEPOSIT();
				deposit.setVisible(true);
			}
		});
		btnDepositHere.setForeground(Color.WHITE);
		btnDepositHere.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDepositHere.setBackground(Color.BLUE);
		btnDepositHere.setBounds(516, 372, 193, 51);
		contentPane.add(btnDepositHere);
	}
}
