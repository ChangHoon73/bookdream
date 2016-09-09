package kr.or.bookdream.books;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import kr.or.bookdream.MainView;
import kr.or.bookdream.dao.BooksDAO;
import kr.or.bookdream.vo.Books;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeDetail extends JPanel {
	private MainView mMainView;
	
	private int booksno;
	private JLabel lbl_title;
	private JLabel lbl_author;
	private JLabel lbl_isbn;
	private JLabel lbl_publisher;
	private JLabel lbl_pdate;
	private JLabel lbl_edition;
	private JLabel lbl_status;
	private JLabel lbl_member;
	private JLabel lbl_rpoint;
	private JLabel lbl_category1;
	private JLabel lbl_category2;
	private JLabel lbl_registdate;
	private JLabel lbl_image;
	private JPanel imgPanel;
	
	public HomeDetail(MainView mMainView){
		this.mMainView = mMainView;
		initialize(); //  추가
	}
	
	public HomeDetail(MainView mMainView, int booksno) {
		this.mMainView = mMainView;
		this.booksno = booksno;
		
		initialize();
		
		BooksDAO booksdao = new BooksDAO();
		Vector<Books> vbooks = booksdao.getBooksSelectId(booksno);
		
		lbl_title.setText(vbooks.get(0).getTitle());
		lbl_author.setText(vbooks.get(0).getAuthor());
		lbl_isbn.setText(vbooks.get(0).getIsbn());
		lbl_publisher.setText(vbooks.get(0).getPublisher());
		lbl_pdate.setText(vbooks.get(0).getPdate());
		lbl_edition.setText(""+vbooks.get(0).getEdition());
		lbl_status.setText(vbooks.get(0).getStatus());
		lbl_registdate.setText(vbooks.get(0).getRegidate());
		lbl_rpoint.setText(""+vbooks.get(0).getRpoint());
		//lbl_title.setText(vbooks.get(0).getTitle());
		getLinksImg(vbooks.get(0).getLink());
	}
	
	private void initialize() {
		setForeground(Color.WHITE);
		setLayout(null);
		
		
		imgPanel = new JPanel();
		imgPanel.setBackground(Color.BLACK);
		imgPanel.setBounds(23, 34, 112, 152);
		add(imgPanel);
		imgPanel.setLayout(new BorderLayout(0, 0));
		
		lbl_image = new JLabel("");
		imgPanel.add(lbl_image, BorderLayout.NORTH);
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setIcon(new ImageIcon(HomeDetail.class.getResource("/javax/swing/plaf/basic/icons/image-failed.png")));
		lbl_image.setBackground(Color.BLACK);
		
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
		
		lbl_title = new JLabel("");
		lbl_title.setBounds(81, 10, 183, 15);
		panel_1.add(lbl_title);
		
		lbl_author = new JLabel("");
		lbl_author.setBounds(81, 41, 183, 15);
		panel_1.add(lbl_author);
		
		lbl_isbn = new JLabel("");
		lbl_isbn.setBounds(81, 73, 183, 15);
		panel_1.add(lbl_isbn);
		
		lbl_publisher = new JLabel("");
		lbl_publisher.setBounds(81, 101, 183, 15);
		panel_1.add(lbl_publisher);
		
		lbl_pdate = new JLabel("");
		lbl_pdate.setBounds(81, 129, 183, 15);
		panel_1.add(lbl_pdate);
		
		lbl_edition = new JLabel("");
		lbl_edition.setBounds(81, 157, 183, 15);
		panel_1.add(lbl_edition);
		
		lbl_status = new JLabel("");
		lbl_status.setBounds(81, 185, 183, 15);
		panel_1.add(lbl_status);
		
		lbl_member = new JLabel("");
		lbl_member.setBounds(81, 213, 183, 15);
		panel_1.add(lbl_member);
		
		lbl_rpoint = new JLabel("0");
		lbl_rpoint.setBounds(81, 241, 183, 15);
		panel_1.add(lbl_rpoint);
		
		lbl_category1 = new JLabel("");
		lbl_category1.setBounds(81, 275, 183, 15);
		panel_1.add(lbl_category1);
		
		lbl_category2 = new JLabel("");
		lbl_category2.setBounds(81, 303, 183, 15);
		panel_1.add(lbl_category2);
		
		JLabel label_11 = new JLabel("\uB4F1\uB85D\uC77C");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setBounds(12, 328, 57, 15);
		panel_1.add(label_11);
		
		lbl_registdate = new JLabel("");
		lbl_registdate.setBounds(81, 328, 183, 15);
		panel_1.add(lbl_registdate);
		
		//등록버튼 
		JButton btn_add = new JButton("\uCC45\uB4F1\uB85D");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// HomeDetailAdd 패널 호출
				mMainView.setDetailPanel(new HomeDetailAdd(mMainView));
			}
		});
		btn_add.setBounds(180, 463, 97, 23);
		add(btn_add);
		
	}
	
	/**
	 * 이미지 링크주소를 받아서 이미지를 뽑아서 이미지 라벨에 적용 함수
	 * @param linkurl
	 */
	private void getLinksImg(String linkurl){
		URL url = null;
		try {
			url = new URL(linkurl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 이미지를 사이즈에 맞게 축소
		ImageIcon imgscale = new ImageIcon(img);
		Image image = imgscale.getImage().getScaledInstance(
				imgPanel.getWidth(), // 가로크기
				imgPanel.getHeight(), // 세로크기
				Image.SCALE_DEFAULT);
		ImageIcon imgIcon = new ImageIcon(
				image
				);
		lbl_image.setIcon(imgIcon);
		
	}
}
