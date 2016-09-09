package kr.or.bookdream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;

import kr.or.bookdream.books.HomeDetail;
import kr.or.bookdream.books.HomeMain;
import kr.or.bookdream.login.Login;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;

public class MainView {

	private JFrame frame;
	private JTable table;
	private JPanel homePanel;
	private JPanel myPanel;
	private JPanel historyPanel;
	private JPanel detailPanel;
	private JTabbedPane tabbedPane;
	private JScrollPane detailScrollPane;
	private JPanel categoryPanel;
	
	private int MembersNo = 1;
	private String MembersName;
//	private MainView window;
	private Login dialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainView().startMain();
	}
	
	public void startMain(){
//		window = new MainView();
		dialog = new Login(this);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		
	}
	
	public void StartMainView(){
		try {
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 21, 549, 631);
		frame.getContentPane().add(tabbedPane);
		
		homePanel = new JPanel();
		tabbedPane.addTab("HOME", null, homePanel, null);
		homePanel.setLayout(new BorderLayout());
		homePanel.add(new HomeMain(this)); // HomeMain에 MainView객체 전달
		
		myPanel = new JPanel();
		tabbedPane.addTab(" MY ", null, myPanel, null);
		tabbedPane.setEnabledAt(1, false);
		
		historyPanel = new JPanel();
		tabbedPane.addTab("HISTORY", null, historyPanel, null);
		tabbedPane.setEnabledAt(2, false);
		
		categoryPanel = new JPanel();
		tabbedPane.addTab("CATEGORY", null, categoryPanel, null);
		tabbedPane.setEnabledAt(3, false);
		
		detailScrollPane = new JScrollPane();
		detailScrollPane.setBounds(573, 48, 423, 604);
		frame.getContentPane().add(detailScrollPane);
		
		detailPanel = new JPanel();
		detailPanel.setLayout(new BorderLayout());
		detailPanel.add(new HomeDetail(this)); // 기본적으로 HomeDetail을 표시
		detailScrollPane.setViewportView(detailPanel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(899, 10, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(790, 10, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public void setDetailPanel(JPanel pDetail){
		this.detailPanel.removeAll(); // 기존DetailPanel내용 삭제
		this.detailPanel.add(pDetail); // pDetail 추가
		this.detailPanel.updateUI(); // 새로고침
	}
	
	public int getMembersNo() {
		return MembersNo;
	}

	public void setMembersNo(int membersNo) {
		MembersNo = membersNo;
	}
	
	public String getMembersName() {
		return MembersName;
	}

	public void setMembersName(String membersName) {
		MembersName = membersName;
	}
}
