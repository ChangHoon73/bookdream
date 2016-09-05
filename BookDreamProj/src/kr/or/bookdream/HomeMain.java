package kr.or.bookdream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HomeMain extends JPanel{
	private JComboBox cb_cat1;
	private JComboBox cb_cat2;
	private JComboBox cb_sido;
	private JComboBox cb_gugun;
	private JComboBox cb_dong;
	private JTable table;
	public HomeMain(){
		initilize();
		this.setLayout(null); // 현재 레이아웃을 Absolute Layout으로 변경
	}
	
	public void initilize(){
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9\uC870\uAC74");
		lblNewLabel.setBounds(12, 22, 57, 15);
		this.add(lblNewLabel);
		
		cb_cat1 = new JComboBox();
		cb_cat1.setBounds(12, 47, 163, 21);
		this.add(cb_cat1);
		
		cb_cat2 = new JComboBox();
		cb_cat2.setBounds(187, 47, 149, 21);
		this.add(cb_cat2);
		
		cb_sido = new JComboBox();
		cb_sido.setBounds(12, 79, 100, 21);
		this.add(cb_sido);
		
		cb_gugun = new JComboBox();
		cb_gugun.setBounds(124, 78, 100, 21);
		this.add(cb_gugun);
		
		cb_dong = new JComboBox();
		cb_dong.setBounds(236, 79, 100, 21);
		this.add(cb_dong);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(348, 78, 97, 23);
		this.add(btnSearch);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 110, 439, 482);
		this.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
	}
}
