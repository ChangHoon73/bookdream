package kr.or.bookdream.books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class HomeDetailAdd extends JPanel {
	private JTextField tf_title;
	private JTextField tf_author;
	private JTextField tf_isbn;
	private JTextField tf_publisher;
	private JTextField tf_pdate;
	private JTextField tf_edition;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public HomeDetailAdd() {
		setForeground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(23, 34, 112, 152);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(HomeDetailAdd.class.getResource("/javax/swing/plaf/basic/icons/image-failed.png")));
		lblNewLabel.setBackground(Color.BLACK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(147, 31, 276, 371);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(12, 10, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		tf_title = new JTextField();
		tf_title.setBounds(81, 7, 172, 21);
		panel_1.add(tf_title);
		tf_title.setColumns(10);
		
		JLabel label = new JLabel("\uC800\uC790");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(12, 41, 57, 15);
		panel_1.add(label);
		
		tf_author = new JTextField();
		tf_author.setColumns(10);
		tf_author.setBounds(81, 38, 172, 21);
		panel_1.add(tf_author);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setBounds(12, 73, 57, 15);
		panel_1.add(lblIsbn);
		
		tf_isbn = new JTextField();
		tf_isbn.setColumns(10);
		tf_isbn.setBounds(81, 70, 87, 21);
		panel_1.add(tf_isbn);
		
		JLabel label_2 = new JLabel("\uCD9C\uD310\uC0AC");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(12, 101, 57, 15);
		panel_1.add(label_2);
		
		tf_publisher = new JTextField();
		tf_publisher.setColumns(10);
		tf_publisher.setBounds(81, 98, 172, 21);
		panel_1.add(tf_publisher);
		
		JLabel label_1 = new JLabel("\uBC1C\uD589\uC77C");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 129, 57, 15);
		panel_1.add(label_1);
		
		tf_pdate = new JTextField();
		tf_pdate.setColumns(10);
		tf_pdate.setBounds(81, 126, 172, 21);
		panel_1.add(tf_pdate);
		
		JLabel label_3 = new JLabel("\uBA87\uC1C4");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 157, 57, 15);
		panel_1.add(label_3);
		
		tf_edition = new JTextField();
		tf_edition.setColumns(10);
		tf_edition.setBounds(81, 154, 172, 21);
		panel_1.add(tf_edition);
		
		JLabel label_4 = new JLabel("\uC0C1\uD0DC");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 185, 57, 15);
		panel_1.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(81, 182, 172, 21);
		panel_1.add(textField_6);
		
		JLabel label_5 = new JLabel("\uC18C\uC720\uC790");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(12, 213, 57, 15);
		panel_1.add(label_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(81, 210, 172, 21);
		panel_1.add(textField_7);
		
		JLabel label_7 = new JLabel("\uCD94\uCC9C\uC810\uC218");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setBounds(12, 241, 57, 15);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("\uBD84\uB9581");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(12, 275, 57, 15);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("\uBD84\uB9582");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(12, 303, 57, 15);
		panel_1.add(label_9);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setBounds(180, 69, 73, 23);
		panel_1.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		comboBox.setBounds(81, 241, 172, 21);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(81, 272, 172, 21);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(81, 300, 172, 21);
		panel_1.add(comboBox_2);
		
		JButton btn_add = new JButton("\uB4F1\uB85D");
		btn_add.setBounds(180, 463, 97, 23);
		add(btn_add);

	}
}
