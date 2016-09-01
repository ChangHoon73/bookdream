import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CategoryDB {

	private JFrame frame;
	private JTextField tf1;
	private JTextField tf2;
	private JList list1;
	private JList list2;
	private Vector<Category1> vc1;
	private Vector<Category2> vc2;
	private Vector<String> cat1;
	private Vector<String> cat2;
	private boolean busing;
	private JButton btnINS2;
	private JButton btnDEL2;
	private boolean bClick = true;
	private int pk1;
	private int pk2;
	private JButton btnDEL1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryDB window = new CategoryDB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CategoryDB() {
		initialize();
		usingCat2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 406, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//String[] strs = {"불고기","삼겹살","닭찜"};
		vc1 = new Vector<Category1>();
		vc2 = new Vector<Category2>();
		
		cat1 = new Vector<String>();
		cat2 = new Vector<String>();
		CallDB();
//		vc1.add("불고기");
//		vc1.add("삼겹살");
//		vc1.add("닭찜");
		
//		int a;
		list1 = new JList(cat1); // 객체배열, 벡터, 리스트모델
		
		list1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if(bClick){
					bClick = false;
					int indx = list1.getSelectedIndex();
					pk1 = vc1.get(indx).getNo();
					CallDB2(pk1); // category2 불러옴
					list2.updateUI(); // 리스트2 새로고침
					busing = true; // 비활성화 변수
					if(busing)
					usingCat2(); // 비활성화 텍스트필드, 버튼을 활성화
				}
				
			}
		});
		JScrollPane jsp1 = new JScrollPane(list1);
		jsp1.setBounds(40, 24, 120, 155);
		frame.getContentPane().add(jsp1);
		
		tf1 = new JTextField();
		tf1.setBounds(40, 189, 120, 27);
		frame.getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JButton btnINS1 = new JButton("INS");
		btnINS1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input_text = tf1.getText();
//				vc1.addElement(input_text);
//				list1.updateUI();
				insCatagory1(input_text);
				CallDB();
				list1.updateUI();
				
			}
		});
		btnINS1.setBounds(40, 226, 55, 23);
		frame.getContentPane().add(btnINS1);
		
		btnDEL1 = new JButton("DEL");
		btnDEL1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(list1.getSelectedIndex());
//				int indx = list1.getSelectedIndex();
//				int no = vc1.get(indx).getNo();
				delCatagory1(pk1);
				CallDB();
				list1.updateUI();
			}
		});
		btnDEL1.setBounds(96, 226, 64, 23);
		frame.getContentPane().add(btnDEL1);
		
		list2 = new JList(cat2);
		list2.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
					int indx = list2.getSelectedIndex();
					pk2 = vc2.get(indx).getNo();
			}
		});
		JScrollPane jsp2 = new JScrollPane(list2);
		jsp2.setBounds(211, 24, 120, 155);
		frame.getContentPane().add(jsp2);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(211, 189, 120, 27);
		frame.getContentPane().add(tf2);
		
		btnDEL2 = new JButton("DEL");
		btnDEL2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delCatagory2(pk2);
				CallDB2(pk1);
				list2.updateUI();				
			}
		});
		btnDEL2.setBounds(267, 226, 64, 23);
		frame.getContentPane().add(btnDEL2);
		
		btnINS2 = new JButton("INS");
		btnINS2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input_text = tf2.getText();
				insCatagory2(pk1,input_text);
				CallDB2(pk1);
				list2.updateUI();
			}
		});
		btnINS2.setBounds(211, 226, 55, 23);
		frame.getContentPane().add(btnINS2);
		
		
	}
	
	protected void CallDB2(int no) {
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select no, name from category2 where category1_no = "+no+" order by no ");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			vc2.removeAllElements();
			cat2.clear();
			while(  rs.next() ){
				vc2.add(new Category2(rs.getInt("no"), rs.getString("name")));
				cat2.add(rs.getString("name"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		bClick = true;
		
	}

	public void CallDB(){
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select no, name from category1 order by no ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			vc1.removeAllElements();
//			vc1.clear();
			cat1.clear();
			while(  rs.next() ){
//				vc1.add(rs.getString(2));
//				vc1.add(rs.getString("name"));
				vc1.add(new Category1(rs.getInt("no"), rs.getString("name")));
				cat1.add(rs.getString("name"));
			}
//			cat1 = new String[vc1.size()];
//			for(int i = 0; i< cat1.length; i++){// 배열의 방에 값(name)을 넣기위해서
//				cat1[i] = vc1.get(i).getName();
//			}
//			System.out.println(cat1.length);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insCatagory1(String name){
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.getConnection();
		String sql = "insert into category1(name) values(?) ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insCatagory2(int no, String name){
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.getConnection();
		String sql = "insert into category2(name, category1_no) values(?, ?) ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delCatagory1(int indx){
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.getConnection();
		String sql = "delete from category1 where no = ? ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
			pstmt.setInt(1, indx);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delCatagory2(int indx){
		DBConn dbconn = new DBConn();
		Connection conn = dbconn.getConnection();
		String sql = "delete from category2 where no = ? ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
			pstmt.setInt(1, indx);
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void usingCat2(){
		tf2.setEnabled(busing);
		btnINS2.setEnabled(busing);
		btnDEL2.setEnabled(busing);
		btnDEL1.setEnabled(busing);
	}
}
