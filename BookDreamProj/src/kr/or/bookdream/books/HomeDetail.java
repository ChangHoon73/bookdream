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

public class HomeDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomeDetail() {
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
		lblNewLabel.setIcon(new ImageIcon(HomeDetail.class.getResource("/javax/swing/plaf/basic/icons/image-failed.png")));
		lblNewLabel.setBackground(Color.BLACK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(147, 31, 276, 371);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(12, 10, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uC800\uC790");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(12, 41, 57, 15);
		panel_1.add(label);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setBounds(12, 73, 57, 15);
		panel_1.add(lblIsbn);
		
		JLabel label_2 = new JLabel("\uCD9C\uD310\uC0AC");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(12, 101, 57, 15);
		panel_1.add(label_2);
		
		JLabel label_1 = new JLabel("\uBC1C\uD589\uC77C");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 129, 57, 15);
		panel_1.add(label_1);
		
		JLabel label_3 = new JLabel("\uBA87\uC1C4");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 157, 57, 15);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\uC0C1\uD0DC");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 185, 57, 15);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("\uC18C\uC720\uC790");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(12, 213, 57, 15);
		panel_1.add(label_5);
		
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
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(81, 10, 57, 15);
		panel_1.add(lbl_title);
		
		JLabel lbl_author = new JLabel("");
		lbl_author.setBounds(81, 41, 57, 15);
		panel_1.add(lbl_author);
		
		JLabel lbl_isbn = new JLabel("");
		lbl_isbn.setBounds(81, 73, 57, 15);
		panel_1.add(lbl_isbn);
		
		JLabel lbl_publisher = new JLabel("");
		lbl_publisher.setBounds(81, 101, 57, 15);
		panel_1.add(lbl_publisher);
		
		JLabel lbl_pdate = new JLabel("");
		lbl_pdate.setBounds(81, 129, 57, 15);
		panel_1.add(lbl_pdate);
		
		JLabel lbl_edition = new JLabel("");
		lbl_edition.setBounds(81, 157, 57, 15);
		panel_1.add(lbl_edition);
		
		JLabel lbl_status = new JLabel("");
		lbl_status.setBounds(81, 185, 57, 15);
		panel_1.add(lbl_status);
		
		JLabel lbl_member = new JLabel("");
		lbl_member.setBounds(81, 213, 57, 15);
		panel_1.add(lbl_member);
		
		JLabel lbl_rpoint = new JLabel("0");
		lbl_rpoint.setBounds(81, 241, 57, 15);
		panel_1.add(lbl_rpoint);
		
		JLabel lbl_category1 = new JLabel("");
		lbl_category1.setBounds(81, 275, 57, 15);
		panel_1.add(lbl_category1);
		
		JLabel lbl_category2 = new JLabel("");
		lbl_category2.setBounds(81, 303, 57, 15);
		panel_1.add(lbl_category2);
		
		JLabel label_11 = new JLabel("\uB4F1\uB85D\uC77C");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(12, 328, 57, 15);
		panel_1.add(label_11);
		
		JLabel lbl_registdate = new JLabel("");
		lbl_registdate.setBounds(81, 328, 57, 15);
		panel_1.add(lbl_registdate);
		
		JButton btn_add = new JButton("\uB4F1\uB85D");
		btn_add.setBounds(180, 463, 97, 23);
		add(btn_add);

	}
}
