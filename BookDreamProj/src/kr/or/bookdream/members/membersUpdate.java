package kr.or.bookdream.members;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;
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

public class membersUpdate {

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
	private boolean bcheck = false;
	private JPasswordField pwf;
	private JPasswordField pwf_chk;
	
	private int member_no = 1;
	
	String get_email;
	String get_name;
	String get_tel;
	String get_sido;
	String get_gugun;
	String get_dong;
	
	String get_pwf;
	String get_pwf_chk;
	String get_pwf_chk1;
	
	private JPasswordField pwf_chk1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					membersUpdate window = new membersUpdate();
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
	public membersUpdate() {
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
		
		MembersDAO membersdao= new MembersDAO();
		System.out.println("member_no = " + member_no);

		System.out.println("after new " );
		
		vmembers = membersdao.getMembersSelectId(member_no);
		System.out.println("after membersDAO.getMembersSelectId(memberno) " );
		

		get_email = vmembers.get(0).getEmail().toString();
		get_pwf   = vmembers.get(0).getPw().toString();
		get_name  = vmembers.get(0).getName().toString();
		get_tel   = vmembers.get(0).getTel().toString();
		get_sido  = vmembers.get(0).getSido().toString();
		get_gugun = vmembers.get(0).getGugun().toString();
		get_dong  = vmembers.get(0).getDong().toString();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("한컴 소망 M", Font.BOLD, 36));
		lbl_title.setBounds(314, 47, 275, 44);
		frame.getContentPane().add(lbl_title);
		
		JLabel lbl_email = new JLabel("E-Mail : ");
		lbl_email.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_email.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_email.setBounds(124, 164, 130, 30);
		frame.getContentPane().add(lbl_email);
		
		tf_email = new JTextField();
		tf_email.setEnabled(false);
		tf_email.setText(get_email);
		tf_email.setBounds(266, 166, 275, 30);
		frame.getContentPane().add(tf_email);
		
		JLabel lbl_pw = new JLabel("Password : ");
		lbl_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pw.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_pw.setBounds(124, 222, 130, 30);
		frame.getContentPane().add(lbl_pw);
		
		pwf = new JPasswordField();
		pwf.setHorizontalAlignment(SwingConstants.LEFT);
		pwf.setBounds(266, 224, 275, 30);
		frame.getContentPane().add(pwf);	
		
		JLabel lbl_pwchange = new JLabel("Password \uBCC0\uACBD : ");
		lbl_pwchange.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_pwchange.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_pwchange.setBounds(74, 282, 180, 30);

		pwf_chk = new JPasswordField();
		pwf_chk.setHorizontalAlignment(SwingConstants.LEFT);
		pwf_chk.setBounds(266, 282, 275, 30);
		frame.getContentPane().add(pwf_chk);

		frame.getContentPane().add(lbl_pwchange);		
		pwf_chk1 = new JPasswordField();
		pwf_chk1.setHorizontalAlignment(SwingConstants.LEFT);
		pwf_chk1.setBounds(559, 282, 275, 30);
		frame.getContentPane().add(pwf_chk1);
		
		JLabel lbl_name = new JLabel("\uC774      \uB984 : ");
		lbl_name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_name.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_name.setBounds(124, 344, 130, 30);
		frame.getContentPane().add(lbl_name);
		
		tf_name = new JTextField();
		tf_name.setText(get_name);
		tf_name.setBounds(266, 344, 275, 30);
		frame.getContentPane().add(tf_name);
		
		JLabel lbl_tel = new JLabel("\uC804\uD654\uBC88\uD638 : ");
		lbl_tel.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_tel.setFont(new Font("굴림", Font.BOLD, 16));
		lbl_tel.setBounds(124, 405, 130, 30);
		frame.getContentPane().add(lbl_tel);
		
		tf_tel = new JTextField();
		tf_tel.setText(get_tel);
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
				vsido.setElementAt("시도선택", 0);
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
		
		vgugun.setElementAt(get_gugun, 0);
		cb_gugun = new JComboBox(vgugun);
		cb_gugun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED && cb_gugun.getSelectedIndex() > 0 ){
					vdong.clear();
					cb_dong.removeAllItems();// 아이템삭제
					DongDAO dongdao = new DongDAO();
					vdong = dongdao.getDongListAll(cb_sido.getSelectedItem().toString(),cb_gugun.getSelectedItem().toString());
					for(int i = 0; i< vdong.size(); i++){
						cb_dong.addItem(vdong.get(i));
					}
					cb_dong.setSelectedIndex(0);
				}
			}
		});
		cb_gugun.setBounds(412, 463, 129, 36);
		frame.getContentPane().add(cb_gugun);

		vdong.setElementAt(get_dong, 0);
		cb_dong = new JComboBox(vdong);
		cb_dong.setBounds(558, 463, 180, 36);
		frame.getContentPane().add(cb_dong);

		cb_sido.setSelectedItem(get_sido);
		cb_gugun.setSelectedItem(get_gugun);
		cb_dong.setSelectedItem(get_dong);
		
		
		JButton btn_update = new JButton("\uC218  \uC815");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean input_chk = true;

				if(!pwf.getText().equals(get_pwf))
				{
					JOptionPane.showMessageDialog(null, "패스워드를 다시 입력하세요");
					pwf.setText(null);
					pwf.requestFocus();
					input_chk = false;
				}
				else if(pwf_chk.getText().trim().length() > 0 && pwf_chk1.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "변경할 패스워드를 한번 더 입력하세요");
					pwf_chk1.setText(null);
					pwf_chk1.requestFocus();
					input_chk = false;					
				}
				else if(!pwf_chk.getText().equals(pwf_chk1.getText()))
				{
					JOptionPane.showMessageDialog(null, "변경할 패스워드가 다릅니다. 다시 한번 입력하세요");
					pwf_chk1.setText(null);
					pwf_chk1.requestFocus();
					input_chk = false;					
				}
				else if(!tf_name.getText().equals(get_name))
				{
					JOptionPane.showMessageDialog(null, "이름이 변경되었습니다. 확인하십시요");
					cb_sido.requestFocus();
				}
				
				if(input_chk)
				{
					updateMembers();
				}
			}
		});
		btn_update.setFont(new Font("굴림", Font.BOLD, 16));
		btn_update.setBounds(295, 554, 122, 44);
		frame.getContentPane().add(btn_update);
		
		JButton btn_delete = new JButton("\uD0C8 \uD1F4");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean input_chk = true;

				if(!pwf.getText().equals(get_pwf))
				{
					JOptionPane.showMessageDialog(null, "패스워드를 다시 입력하세요");
					pwf.setText(null);
					pwf.requestFocus();
					input_chk = false;
				}else 
				{
					int conf = JOptionPane.showConfirmDialog(null, "정말로 탈퇴하시겠습니까?");
					if (conf == 0)
					{
						deleteMembers();
					}else
					{
						JOptionPane.showMessageDialog(null, "취소합니다......");
					}
				}

			}
		});
		btn_delete.setFont(new Font("굴림", Font.BOLD, 16));
		btn_delete.setBounds(520, 554, 122, 44);
		frame.getContentPane().add(btn_delete);
	}
	
	
	public void updateMembers()
	{
		String registdate = "";
		String authdate = "";
		int sticker = 0;

		boolean update_result;

		MembersDAO membersdao = new MembersDAO();
		update_result = membersdao.setMembersUpdate(member_no,
											     	tf_email.getText(), 
											     	pwf.getText(),
											     	tf_name.getText(),
											     	tf_tel.getText(),
											     	cb_sido.getSelectedItem().toString(),
											     	cb_gugun.getSelectedItem().toString(),
											     	cb_dong.getSelectedItem().toString(), 
											     	registdate,
											     	authdate, 
											     	sticker);

		if (update_result) 
		{
			JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.....");
			frame.dispose();
		} else 
		{
			JOptionPane.showMessageDialog(null, "다시 시도해주십시요");
		}

	}


	public void deleteMembers() 
	{
		String registdate = "";
		String authdate = "";
		int sticker = 0;

		boolean delete_result;

		MembersDAO membersdao = new MembersDAO();
		delete_result = membersdao.setMembersDelete(member_no);

		if (delete_result) 
		{
			JOptionPane.showMessageDialog(null, "탈퇴되었습니다..........");
			frame.dispose();
		} else 
		{
			JOptionPane.showMessageDialog(null, "다시 시도해주십시요");
		}
	}
}
