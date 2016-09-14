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
import kr.or.bookdream.history.HistoryDetail;
import kr.or.bookdream.history.HistoryMain;
import kr.or.bookdream.login.Login;
import kr.or.bookdream.members.membersAdd;
import kr.or.bookdream.my.MyDetail;
import kr.or.bookdream.my.MyMain;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	private int MembersNo = 0;
	private String MembersName;
	private String MembersEmail;
	

	private boolean bLogin; // 로그인체크변수 true면 로그인, false 로그아웃
	
	
//	private MainView window;
	private Login loginDialog;
	private membersAdd memberform;
	private static final int HOME = 0;
	private static final int MY = 1;
	private static final int HISTORY = 2;
	private static final int CATEGORY = 3;
	private JPanel loginPanel;
	private JPanel logoutPanel;
	
	private int homeBooksno = 0;
	private int myBooksno = 0;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainView().startMain();
	}
	
	public void startMain(){
//		window = new MainView();
//		dialog = new Login(this);
//		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		dialog.setVisible(true);
		startloginForm();
		
	}
	
	// 메인뷰화면 보이기
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
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				switch(	tabbedPane.getSelectedIndex()){
				case HOME:
					if(homeBooksno > 0 )
						setDetailPanel(new HomeDetail(MainView.this, homeBooksno));
					else
						setDetailPanel(new HomeDetail(MainView.this));
					break;
				case MY:
					if(myBooksno > 0 )
						setDetailPanel(new MyDetail(MainView.this, myBooksno));
					else
						setDetailPanel(new MyDetail(MainView.this));
					break;
				case HISTORY:
					setDetailPanel(new HistoryDetail(MainView.this,0));
					break;
				case CATEGORY:
					break;
					default:
						
				}
			}
		});
		tabbedPane.setBounds(12, 21, 549, 631);
		frame.getContentPane().add(tabbedPane);
		
		detailPanel = new JPanel();
		
		homePanel = new JPanel();
		tabbedPane.addTab("HOME", null, homePanel, null);
		homePanel.setLayout(new BorderLayout());
		homePanel.add(new HomeMain(this)); // HomeMain에 MainView객체 전달
		
		myPanel = new JPanel();
		tabbedPane.addTab(" MY ", null, myPanel, null);
		tabbedPane.setEnabledAt(1, false);
		myPanel.setLayout(new BorderLayout());
		myPanel.add(new MyMain(this)); // HomeMain에 MainView객체 전달
		
		historyPanel = new JPanel();
		tabbedPane.addTab("HISTORY", null, historyPanel, null);
		tabbedPane.setEnabledAt(2, false);
		historyPanel.setLayout(new BorderLayout());
		historyPanel.add(new HistoryMain(this)); // HomeMain에 MainView객체 전달
		
		categoryPanel = new JPanel();
		tabbedPane.addTab("CATEGORY", null, categoryPanel, null);
		tabbedPane.setEnabledAt(3, false);
		
		detailScrollPane = new JScrollPane();
		detailScrollPane.setBounds(573, 48, 423, 604);
		frame.getContentPane().add(detailScrollPane);
		
		
		detailPanel.setLayout(new BorderLayout());
		detailPanel.add(new HomeDetail(this)); // 기본적으로 HomeDetail을 표시
		detailScrollPane.setViewportView(detailPanel);
		
		loginPanel = new JPanel();
		loginPanel.setBounds(711, 10, 285, 28);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		//회원 로그아웃
		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setbLogin(false);
				startloginForm();
			}
		});
		btnLogout.setBounds(67, 4, 97, 23);
		loginPanel.add(btnLogout);
		
		// 회원정보수정
		JButton btnMemberInfo = new JButton("\uD68C\uC6D0\uC815\uBCF4");
		btnMemberInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnMemberInfo.setBounds(176, 4, 97, 23);
		loginPanel.add(btnMemberInfo);
		
		loginPanel.setVisible(false);
		logoutPanel = new JPanel();
		logoutPanel.setBounds(711, 10, 285, 28);
		frame.getContentPane().add(logoutPanel);
		logoutPanel.setLayout(null);
		
	
		// 회원로그인
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setBounds(176, 4, 97, 23);
		logoutPanel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startloginForm();
			}
		});
	}
	
	/**
	 * 로그인폼
	 */
	public void startloginForm(){
		loginDialog = new Login(MainView.this);
		loginDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		loginDialog.setVisible(true);
		MainView.this.frame.setVisible(false);
	}
	
	public void disposeLoginForm(){
		loginDialog.dispose();
	}
	
	/**
	 * 회원가입폼
	 */
	public void startMemberForm(){
		memberform = new membersAdd(MainView.this);
//		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		memberform.frame.setVisible(true);
		MainView.this.frame.setVisible(false);
	}
	
	public void disposeMemberForm(){
		memberform.frame.dispose();
	}
	public void setHomeMain(){
		homePanel.removeAll();
		homePanel.add(new HomeMain(this)); // HomeMain에 MainView객체 전달
		homePanel.updateUI();
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
	
	public String getMembersEmail() {
		return MembersEmail;
	}

	public void setMembersEmail(String membersEmail) {
		MembersEmail = membersEmail;
	}

	public boolean isbLogin() {
		return bLogin;
	}

	public void setbLogin(boolean bLogin) {
		this.bLogin = bLogin;
		LoginCheck();
	}
	
	//로그인시 보이기
	public void LoginCheck(){
		tabbedPane.setEnabledAt(1, bLogin);
		tabbedPane.setEnabledAt(2, bLogin);
		loginPanel.setVisible(bLogin);
		logoutPanel.setVisible(!bLogin);
	}
	
	
	public void setHomeBooksno(int homeBooksno) {
		this.homeBooksno = homeBooksno;
	}
	public int getHomeBooksno() {
		return homeBooksno;
	}

	public int getMyBooksno() {
		return myBooksno;
	}

	public void setMyBooksno(int myBooksno) {
		this.myBooksno = myBooksno;
	}
}
