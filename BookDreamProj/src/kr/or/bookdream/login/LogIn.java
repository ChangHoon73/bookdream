package kr.or.bookdream.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class LogIn {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 1024, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		panel.setForeground(SystemColor.control);
		panel.setBounds(255, 130, 500, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\uB3C4\uC11C \uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnNewButton.setBounds(50, 50, 400, 40);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		textField.setText(" \uC774\uBA54\uC77C \uC8FC\uC18C \uC785\uB825");
		textField.setBounds(50, 120, 400, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		textField_1.setText(" \uBE44\uBC00\uBC88\uD638");
		textField_1.setBounds(50, 190, 400, 40);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uB85C\uADF8\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		btnNewButton_1.setBounds(50, 260, 400, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("?");
		btnNewButton_2.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(410, 330, 40, 40);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("BookDream");
		lblNewLabel.setBounds(300, 50, 400, 50);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton_3 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		btnNewButton_3.setBounds(460, 560, 100, 40);
		frame.getContentPane().add(btnNewButton_3);
	}

}
