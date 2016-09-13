package kr.or.bookdream.members;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Vector;

import javax.swing.SwingConstants;

import com.mysql.fabric.xmlrpc.base.Member;

import kr.or.bookdream.dao.DongDAO;
import kr.or.bookdream.dao.GugunDAO;
import kr.or.bookdream.dao.MembersDAO;
import kr.or.bookdream.dao.MembersDAO;
import kr.or.bookdream.dao.SidoDAO;
import kr.or.bookdream.vo.Members;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class membersAdd {

	private JFrame frame;
	private JTextField tf_email;
	private JTextField tf_name;
	private JTextField tf_tel;
	private JComboBox cb_sido;
	private JComboBox cb_gugun;
	private JComboBox cb_dong;
	
	private Vector<String> vsido;
	private Vector<String> vgugun;
	private Vector<String> vdong;
	
	private Vector<Members> vmembers;
	
	private JButton btn_emailchk;
	private boolean bcheck = false;
	private JPasswordField pwf;
	private JPasswordField pwf_chk;
	private JButton btn_cancel;
	private JButton btn_insert;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					membersAdd window = new membersAdd();
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
	public membersAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		vsido  = new Vector<String>();
		vgugun = new Vector<String>();
		vdong  = new Vector<String>();
		
		vsido.add("시도선택");
		vgugun.add("구군선택");
		vdong.add("동선택");
		
		vmembers = new Vector<Members>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("\uD68C \uC6D0 \uAC00 \uC785");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("한컴 소망 M", Font.BOLD, 36));
		lbl_title.setBounds(333, 47, 242, 44);
		frame.getContentPane().add(lbl_title);
		
		JLabel lbl_email = new JLabel("E-Mail : ");
		lbl_email.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_email.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_email.setBounds(124, 164, 130, 30);
		frame.getContentPane().add(lbl_email);
		
		tf_email = new JTextField();
		tf_email.setBounds(266, 166, 275, 30);
		frame.getContentPane().add(tf_email);
		tf_email.setColumns(10);
		
		btn_emailchk = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_emailchk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MembersDAO membersdao = new MembersDAO();
				vmembers = membersdao.getMembersListAll(tf_email.getText());
				
				if(vmembers.size() > 0)
				{
					JOptionPane.showMessageDialog(null, "이메일이 중복되었습니다.");
					tf_email.setText(null);
					tf_email.requestFocus();
				}else
				{
					pwf.requestFocus();
					bcheck = true;
				}
			}
		});
		btn_emailchk.setFont(new Font("굴림", Font.BOLD, 16));
		btn_emailchk.setBounds(577, 164, 122, 30);
		frame.getContentPane().add(btn_emailchk);
		
		JLabel lbl_pw = new JLabel("Password : ");
		lbl_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pw.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_pw.setBounds(124, 222, 130, 30);
		frame.getContentPane().add(lbl_pw);
		
		pwf = new JPasswordField();
		pwf.setHorizontalAlignment(SwingConstants.LEFT);
		pwf.setBounds(266, 224, 275, 30);
		frame.getContentPane().add(pwf);	

		pwf_chk = new JPasswordField();
		pwf_chk.setHorizontalAlignment(SwingConstants.LEFT);
		pwf_chk.setBounds(266, 282, 275, 30);
		frame.getContentPane().add(pwf_chk);

		
		JLabel lbl_name = new JLabel("\uC774      \uB984 : ");
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_name.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_name.setBounds(124, 344, 130, 30);
		frame.getContentPane().add(lbl_name);
		
		tf_name = new JTextField();
		tf_name.setColumns(10);
		tf_name.setBounds(266, 344, 275, 30);
		frame.getContentPane().add(tf_name);
		
		JLabel lbl_tel = new JLabel("\uC804\uD654\uBC88\uD638 : ");
		lbl_tel.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tel.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_tel.setBounds(124, 405, 130, 30);
		frame.getContentPane().add(lbl_tel);
		
		tf_tel = new JTextField();
		tf_tel.setColumns(10);
		tf_tel.setBounds(266, 405, 275, 30);
		frame.getContentPane().add(tf_tel);
		
		JLabel lbl_addr = new JLabel("\uC8FC      \uC18C : ");
		lbl_addr.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_addr.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_addr.setBounds(124, 465, 130, 30);
		frame.getContentPane().add(lbl_addr);
		
		SidoDAO sidodao = new SidoDAO();
		vsido = sidodao.getSidoListAll();
		
		cb_sido = new JComboBox(vsido);
		cb_sido.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED && cb_sido.getSelectedIndex() > 0 ){
					vgugun.clear();
					cb_gugun.removeAllItems();// 아이템삭제
					cb_dong.removeAllItems();
					cb_dong.addItem("동선택");
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
		cb_sido.setBounds(266, 463, 129, 36);
		frame.getContentPane().add(cb_sido);
		
		cb_gugun = new JComboBox(vgugun);
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
		cb_gugun.setBounds(412, 463, 129, 36);
		frame.getContentPane().add(cb_gugun);
		
		cb_dong = new JComboBox(vdong);
		cb_dong.setBounds(558, 463, 180, 36);
		frame.getContentPane().add(cb_dong);

		btn_insert = new JButton("\uAC00  \uC785");
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean input_chk = true;
				
				if(tf_email.getText().trim().length() < 1)
				{	
					input_chk = false;
					JOptionPane.showMessageDialog(null, "이메일 주소를 입력하세요");
					tf_email.setText(null);
					tf_email.requestFocus();
				}
				else if(!bcheck)
				{
					input_chk = false;
					JOptionPane.showMessageDialog(null, "이메일 중복체크를 해주세요");
					btn_emailchk.requestFocus();			
				}
				else if(pwf.getText().equals(""))
				{
					input_chk = false;
					JOptionPane.showMessageDialog(null, "비밀번호룰 입력하세요");
					pwf.setText(null);
				 	pwf.requestFocus();	
				}
				else if(pwf_chk.getText().equals(""))
				{
					input_chk = false;
					JOptionPane.showMessageDialog(null, "비밀번호룰 한번 더 입력하세요");
					pwf_chk.setText(null);
					pwf_chk.requestFocus();	
				}
				else if(!pwf.getText().equals(pwf_chk.getText()))
				{
					input_chk = false;
					JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다 비밀번호룰 다시 입력하세요");
					pwf_chk.setText(null);
					pwf_chk.requestFocus();	
				}
				else if(tf_name.getText().equals(""))
				{
					input_chk = false;
					JOptionPane.showMessageDialog(null, "이름을 입력하세요");
					tf_name.setText(null);
					tf_name.requestFocus();
				}
				else if (input_chk)
				{		
						insertMembers();
				}
			}
		});
		btn_insert.setFont(new Font("굴림", Font.BOLD, 16));
		btn_insert.setBounds(295, 554, 122, 44);
		frame.getContentPane().add(btn_insert);
		
		btn_cancel = new JButton("\uCDE8  \uC18C");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelMembers();
			}
		});
		btn_cancel.setFont(new Font("굴림", Font.BOLD, 16));
		btn_cancel.setBounds(520, 554, 122, 44);
		frame.getContentPane().add(btn_cancel);
	}
	
	public void insertMembers()
	{
		String registdate = "";
		String authdate = "";
		int sticker = 0;

		boolean add_result;

		MembersDAO membersdao = new MembersDAO();
		add_result = membersdao.setMembersAdd(tf_email.getText(), 
				 							  pwf.getText(),
				 							  tf_name.getText(),
				 							  tf_tel.getText(),
				 							  cb_sido.getSelectedItem().toString(),
				 							  cb_gugun.getSelectedItem().toString(),
				 							  cb_dong.getSelectedItem().toString(), 
				 							  registdate,
				 							  authdate, 
				 							  sticker);

		if (add_result) 
		{
			JOptionPane.showMessageDialog(null, "회원가입을 축하합니다");
			frame.dispose();
		} else 
		{
			JOptionPane.showMessageDialog(null, "회원가입을 다시 시도해주십시요");
		}

	}
	
	private void cancelMembers() {

		JOptionPane.showMessageDialog(null, "회원가입을 취소합니다");
		frame.dispose();
	}

}
