package kr.or.bookdream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HomeMain extends JPanel{
	public HomeMain(){
		initilize();
	}
	
	public void initilize(){
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9\uC870\uAC74");
		lblNewLabel.setBounds(12, 22, 57, 15);
		this.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 47, 163, 21);
		this.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(187, 47, 149, 21);
		this.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(12, 79, 100, 21);
		this.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(124, 78, 100, 21);
		this.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(236, 79, 100, 21);
		this.add(comboBox_4);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(348, 78, 97, 23);
		this.add(btnNewButton);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 110, 439, 482);
		this.add(scrollPane_1);
		
		JTable table = new JTable();
		scrollPane_1.setViewportView(table);
	}
}
