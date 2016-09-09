package kr.or.bookdream.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JDialog {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 867, 661);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("BookDream");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD, 55));
		label.setBounds(209, 33, 400, 50);
		getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(SystemColor.menu);
		panel.setBackground(new Color(51, 204, 153));
		panel.setBounds(164, 113, 500, 400);
		getContentPane().add(panel);
		
		JButton button = new JButton("\uB3C4\uC11C \uAC80\uC0C9");
		button.setFont(new Font("����", Font.PLAIN, 20));
		button.setBounds(50, 50, 400, 40);
		panel.add(button);
		
		textField = new JTextField();
		textField.setToolTipText("\uC774\uBA54\uC77C\uC785\uB825");
		textField.setFont(new Font("����", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(50, 120, 400, 40);
		panel.add(textField);
		
		JButton button_1 = new JButton("\uB85C\uADF8\uC778");
		button_1.setFont(new Font("����", Font.PLAIN, 20));
		button_1.setBounds(50, 260, 400, 40);
		panel.add(button_1);
		
		JButton button_2 = new JButton("?");
		button_2.setFont(new Font("����", Font.PLAIN, 12));
		button_2.setBounds(410, 330, 40, 40);
		panel.add(button_2);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("\uD328\uC2A4\uC6CC\uB4DC\uC785\uB825");
		passwordField.setFont(new Font("����", Font.PLAIN, 15));
		passwordField.setBounds(52, 186, 398, 40);
		panel.add(passwordField);
		
		JLabel label_1 = new JLabel("\uC774\uBA54\uC77C\uC8FC\uC18C\uC785\uB825");
		label_1.setBounds(50, 106, 193, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638\uC785\uB825");
		label_2.setBounds(50, 173, 193, 15);
		panel.add(label_2);
		
		JButton button_3 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button_3.setFont(new Font("����", Font.PLAIN, 15));
		button_3.setBounds(369, 543, 100, 40);
		getContentPane().add(button_3);
	}
}
