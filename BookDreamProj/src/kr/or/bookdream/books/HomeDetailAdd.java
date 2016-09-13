package kr.or.bookdream.books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import kr.or.bookdream.MainView;
import kr.or.bookdream.dao.BooksDAO;
import kr.or.bookdream.dao.Cat1DAO;
import kr.or.bookdream.dao.Cat2DAO;
import kr.or.bookdream.util.CommonUtil;
import kr.or.bookdream.vo.Books;
import kr.or.bookdream.vo.Category1;
import kr.or.bookdream.vo.Category2;
import kr.or.bookdream.vo.SearchBooks;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class HomeDetailAdd extends JPanel {
	private MainView mMainView;
	private JTextField tf_title;
	private JTextField tf_author;
	private JTextField tf_isbn;
	private JTextField tf_publisher;
	private JTextField tf_pdate;
	private JTextField textField_7;
	private JTextField tf_link;
	private JComboBox cb_status;
	private JComboBox cb_rpoint;
	
	private int category1_no;
	private int category2_no;
	private JComboBox cb_edition;
	
	private Vector<Category1> vcat1;
	private Vector<Category2> vcat2;

	private JComboBox cb_cat1;
	private JComboBox cb_cat2;
	private JLabel lbl_Image;
	private JPanel imgPanel;
	/**
	 * Create the panel.
	 */
	public HomeDetailAdd(MainView mMainView) {
		this.mMainView = mMainView;
		setForeground(Color.WHITE);
		setLayout(null);
		
		vcat1 = new Vector<Category1>();
		vcat2 = new Vector<Category2>();
		
		imgPanel = new JPanel();
		imgPanel.setBackground(Color.BLACK);
		imgPanel.setBounds(23, 34, 112, 152);
		add(imgPanel);
		imgPanel.setLayout(new BorderLayout(0, 0));
		
		lbl_Image = new JLabel("");
		imgPanel.add(lbl_Image, BorderLayout.NORTH);
		lbl_Image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Image.setIcon(new ImageIcon(HomeDetailAdd.class.getResource("/javax/swing/plaf/basic/icons/image-failed.png")));
		lbl_Image.setBackground(Color.BLACK);
		
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
		
		JLabel label_4 = new JLabel("\uC0C1\uD0DC");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(12, 185, 57, 15);
		panel_1.add(label_4);
		
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
		
		// isbn검색버튼
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<SearchBooks> vSearchBooks = CommonUtil.getSearchBooks(tf_isbn.getText());
				tf_author.setText(vSearchBooks.get(0).getAuthor());
				tf_title.setText(vSearchBooks.get(0).getTitle());
				tf_link.setText(vSearchBooks.get(0).getLink());
				tf_pdate.setText(vSearchBooks.get(0).getPdate());
				tf_publisher.setText(vSearchBooks.get(0).getPublisher());
				lbl_Image.setIcon(CommonUtil.getLinksImg(vSearchBooks.get(0).getLink(), imgPanel.getWidth(), imgPanel.getHeight()));
			}
		});
		btnNewButton.setBounds(180, 69, 73, 23);
		panel_1.add(btnNewButton);
		
		cb_rpoint = new JComboBox();
		cb_rpoint.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		cb_rpoint.setBounds(81, 241, 172, 21);
		panel_1.add(cb_rpoint);
		
		cb_cat1 = new JComboBox();
		cb_cat1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
//				cb_cat2.removeAllItems();
//				vcat2name.clear();
//				cb_cat2.removeAll();
				if( e.getStateChange() == ItemEvent.SELECTED && cb_cat1.getSelectedIndex() > 0 ) {
					cb_cat2.removeAllItems();
					cb_cat2.addItem("카테고리2");
					//System.out.println(cb_cat1.getSelectedIndex());
					Cat2DAO cat2dao = new Cat2DAO();
					int indx = cb_cat1.getSelectedIndex();
					category1_no = vcat1.get(indx-1).getNo();
					vcat2 = cat2dao.getCat2ListAll(category1_no);
					for(int i = 0; i< vcat2.size(); i++){
						cb_cat2.addItem(vcat2.get(i).getName());
					}
//					if(cb_cat2.getItemCount() > 0)
//						cb_cat2.setSelectedIndex(0);
				}
				
				
			}
		});
		cb_cat1.setBounds(81, 272, 172, 21);
		panel_1.add(cb_cat1);
		
		cb_cat1.addItem("카테고리1");
		
		
		Cat1DAO cat1dao = new Cat1DAO();
		vcat1 = cat1dao.getCat1ListAll();
		for(int i = 0; i< vcat1.size(); i++){
			cb_cat1.addItem(vcat1.get(i).getName());
		}
		
		cb_cat2 = new JComboBox();
		cb_cat2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if( e.getStateChange() == ItemEvent.SELECTED && cb_cat2.getSelectedIndex() > 0 ) {
					int indx = cb_cat2.getSelectedIndex();
					category2_no = vcat2.get(indx).getNo();
				}
			}
		});
		cb_cat2.setBounds(81, 300, 172, 21);
		cb_cat2.addItem("카테고리2");
		panel_1.add(cb_cat2);
		
		JLabel label_6 = new JLabel("\uCC45\uC774\uBBF8\uC9C0");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(12, 331, 57, 15);
		panel_1.add(label_6);
		
		tf_link = new JTextField();
		tf_link.setColumns(10);
		tf_link.setBounds(81, 328, 172, 21);
		panel_1.add(tf_link);
		
		cb_status = new JComboBox();
		cb_status.setModel(new DefaultComboBoxModel(new String[] {"PRIVATE", "PUBLIC"}));
		cb_status.setBounds(81, 182, 172, 21);
		panel_1.add(cb_status);
		
		cb_edition = new JComboBox();
		cb_edition.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cb_edition.setBounds(81, 157, 172, 21);
		panel_1.add(cb_edition);
		
		JButton btn_add = new JButton("\uB4F1\uB85D\uD558\uAE30");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addData();
			}
		});
		btn_add.setBounds(180, 463, 97, 23);
		add(btn_add);

	}
	
	private void addData(){
		BooksDAO booksdao = new BooksDAO();
		boolean bresult = booksdao.setBooksAdd(
				tf_title.getText(), 
				tf_isbn.getText(), 
				tf_author.getText(), 
				tf_publisher.getText(), 
				tf_pdate.getText(), 
				Integer.parseInt(cb_edition.getSelectedItem().toString()), 
				cb_status.getSelectedItem().toString(), 
				tf_link.getText(), 
				Integer.parseInt(cb_rpoint.getSelectedItem().toString()), 
				mMainView.getMembersNo(), 
				category1_no, 
				category2_no
		);
		
		if(bresult){
			JOptionPane.showMessageDialog(null, "등록성공");
			mMainView.setHomeMain();
		}else{
			JOptionPane.showMessageDialog(null, "등록실패");
		}
		

	}
}
