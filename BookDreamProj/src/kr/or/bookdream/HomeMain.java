package kr.or.bookdream;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kr.or.bookdream.dao.Cat1DAO;
import kr.or.bookdream.dao.Cat2DAO;
import kr.or.bookdream.dao.DongDAO;
import kr.or.bookdream.dao.GugunDAO;
import kr.or.bookdream.dao.SidoDAO;
import kr.or.bookdream.vo.Category1;
import kr.or.bookdream.vo.Category2;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class HomeMain extends JPanel{
	private JComboBox cb_cat1;
	private JComboBox cb_cat2;
	private JComboBox cb_sido;
	private JComboBox cb_gugun;
	private JComboBox cb_dong;
	private JTable table;
	private Vector<Category1> vcat1;
	private Vector<Category2> vcat2;
	private Vector<String> vcat1name;
	private Vector<String> vcat2name;
	
	private Vector<String> vsido;
	private Vector<String> vgugun;
	private Vector<String> vdong;
	
	public HomeMain(){
		initilize();
		this.setLayout(null); // 현재 레이아웃을 Absolute Layout으로 변경
	}
	
	public void initilize(){
		vcat1 = new Vector<Category1>();
		vcat2 = new Vector<Category2>();
		vcat1name = new Vector<String>();
		vcat2name = new Vector<String>();
		
		vsido = new Vector<String>();
		vgugun = new Vector<String>();
		vdong = new Vector<String>();
		
		
		vcat1name.add("선택하세요");
		vcat2name.add("선택하세요");
		vsido.add("선택하세요");
		vgugun.add("선택하세요");
		vdong.add("선택하세요");
		
		Cat1DAO cat1dao = new Cat1DAO();
		vcat1 = cat1dao.getCat1ListAll();
		for(int i = 0; i< vcat1.size(); i++){
			vcat1name.add(vcat1.get(i).getName());
		}
		
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9\uC870\uAC74");
		lblNewLabel.setBounds(12, 22, 57, 15);
		this.add(lblNewLabel);
		
		cb_cat1 = new JComboBox(vcat1name);
		cb_cat1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cb_cat2.removeAllItems();
				vcat2name.clear();
				vcat2name.add("선택하세요");
				if( e.getStateChange() == ItemEvent.SELECTED && cb_cat1.getSelectedIndex() > 0 ) {
					
					System.out.println(cb_cat1.getSelectedIndex());
					Cat2DAO cat1dao = new Cat2DAO();
					int indx = cb_cat1.getSelectedIndex()-1;
					vcat2 = cat1dao.getCat2ListAll(vcat1.get(indx).getNo());
					for(int i = 0; i< vcat2.size(); i++){
						vcat2name.add(vcat2.get(i).getName());
					}
				}
				cb_cat2.setSelectedIndex(0);
				
			}
		});
		
		cb_cat1.setBounds(12, 47, 163, 21);
		this.add(cb_cat1);
		
		cb_cat2 = new JComboBox(vcat2name);
		cb_cat2.setBounds(187, 47, 149, 21);
		this.add(cb_cat2);
		
		SidoDAO sidodao = new SidoDAO();
		vsido = sidodao.getSidoListAll();
		
		cb_sido = new JComboBox(this.vsido);
		cb_sido.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.SELECTED && cb_sido.getSelectedIndex() > 0 ){
					vgugun.clear();
					cb_gugun.removeAllItems();// 아이템삭제
					cb_dong.removeAllItems();
					cb_dong.addItem("선택하세요");
					cb_dong.setSelectedIndex(0);
					GugunDAO gugundao = new GugunDAO();
					vgugun = gugundao.getGugunListAll(cb_sido.getSelectedItem().toString());
					for(int i = 0; i< vgugun.size(); i++){
						cb_gugun.addItem(vgugun.get(i));
					}
					cb_gugun.setSelectedIndex(0);
				}
				
			}
		});
		cb_sido.setBounds(12, 79, 100, 21);
		this.add(cb_sido);

		cb_gugun = new JComboBox(this.vgugun);
		cb_gugun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED && cb_gugun.getSelectedIndex() > 0 ){
					vdong.clear();
					cb_dong.removeAllItems();// 아이템삭제
					DongDAO dongdao = new DongDAO();
					vdong = dongdao.getDongListAll(cb_sido.getSelectedItem().toString(),
							cb_gugun.getSelectedItem().toString());
					for(int i = 0; i< vdong.size(); i++){
						cb_dong.addItem(vdong.get(i));
					}
					cb_dong.setSelectedIndex(0);
				}
			}
		});
		cb_gugun.setBounds(124, 78, 100, 21);
		this.add(cb_gugun);
		
		cb_dong = new JComboBox(this.vdong);
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
