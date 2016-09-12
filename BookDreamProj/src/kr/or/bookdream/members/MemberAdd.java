package kr.or.bookdream.members;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import kr.or.bookdream.dao.DongDAO;
import kr.or.bookdream.dao.GugunDAO;
import kr.or.bookdream.dao.MembersDAO;
import kr.or.bookdream.dao.SidoDAO;

import java.awt.Label;
import java.awt.TextField;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class MemberAdd {

	private JFrame frame;

	private Vector<String> vsido;
	private Vector<String> vgugun;
	private Vector<String> vdong;
	private TextField tf_tel;
	private TextField tf_name;
	private TextField tf_email;
	private Button btn_cancel;
	private Button btn_add;
	private JComboBox cb_sido;
	private JComboBox cb_gugun;
	private JComboBox cb_dong;
	private JPasswordField tf_pw;
	private JPasswordField tff_pwconfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberAdd window = new MemberAdd();
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
	public MemberAdd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("회원가입");
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(100, 100, 462, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Label label = new Label(" \uD68C  \uC6D0  \uAC00  \uC785");
		label.setFont(new Font("Dialog", Font.BOLD, 36));
		label.setBounds(123, 22, 235, 37);
		frame.getContentPane().add(label);

		Label label_1 = new Label("\uC774\uBA54\uC77C");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_1.setBounds(35, 82, 69, 37);
		frame.getContentPane().add(label_1);

		Label label_2 = new Label("\uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_2.setBounds(35, 135, 69, 37);
		frame.getContentPane().add(label_2);

		Label label_3 = new Label("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_3.setBounds(35, 191, 100, 37);
		frame.getContentPane().add(label_3);

		Label label_4 = new Label("\uC774\uB984");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_4.setBounds(35, 245, 69, 37);
		frame.getContentPane().add(label_4);

		Label label_5 = new Label("\uC804\uD654\uBC88\uD638");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_5.setBounds(35, 293, 69, 37);
		frame.getContentPane().add(label_5);

		Label label_6 = new Label("\uC8FC\uC18C");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_6.setBounds(35, 343, 69, 37);
		frame.getContentPane().add(label_6);

		// 회원 이메일 정보 처리
		tf_email = new TextField();
		tf_email.setBounds(141, 82, 217, 37);
		frame.getContentPane().add(tf_email);

		// 회원 가입 중복여부 확인 처리
		Button btn_dupl = new Button("\uC911\uBCF5\uD655\uC778");
		btn_dupl.setFont(new Font("Dialog", Font.PLAIN, 14));
		btn_dupl.setBounds(375, 82, 69, 32);
		frame.getContentPane().add(btn_dupl);

		// 회원 이름 정보 처리
		tf_name = new TextField();
		tf_name.setBounds(141, 245, 217, 37);
		frame.getContentPane().add(tf_name);

		// 회원 전화번호 정보 처리
		tf_tel = new TextField();
		tf_tel.setBounds(141, 293, 217, 37);
		frame.getContentPane().add(tf_tel);

		// 회원 주소 처리
		vsido = new Vector<String>();
		vgugun = new Vector<String>();
		vdong = new Vector<String>();

		SidoDAO sidodao = new SidoDAO();
		vsido = sidodao.getSidoListAll();

		cb_sido = new JComboBox(this.vsido);
		cb_sido.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED && cb_sido.getSelectedIndex() > 0) {
					vgugun.clear();
					cb_gugun.removeAllItems();
					cb_dong.removeAllItems();
					cb_dong.addItem("선택하세요");
					cb_dong.setSelectedIndex(0);
					GugunDAO gugundao = new GugunDAO();
					vgugun = gugundao.getGugunListAll(cb_sido.getSelectedItem().toString());

					System.out.println("cb_sido.getSelectedItem().toString() =" + cb_sido.getSelectedItem().toString());

					for (int i = 0; i < vgugun.size(); i++) {
						cb_gugun.addItem(vgugun.get(i));
					}
					cb_gugun.setSelectedIndex(0);
				}

			}
		});
		
		// 회원 비번 처리
		tf_pw = new JPasswordField();
		tf_pw.setBounds(141, 137, 217, 37);
		frame.getContentPane().add(tf_pw);

		tff_pwconfirm = new JPasswordField();
		tff_pwconfirm.setBounds(141, 191, 217, 37);
		frame.getContentPane().add(tff_pwconfirm);

		// 회원 주소 검색 처리
		cb_sido.setBounds(123, 345, 77, 34);
		frame.getContentPane().add(cb_sido);
		
		cb_gugun = new JComboBox(this.vgugun);
		cb_gugun.setFont(new Font("굴림", Font.PLAIN, 11));
		cb_gugun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED && cb_gugun.getSelectedIndex() > 0) {
					vdong.clear();
					cb_dong.removeAllItems();// 아이템삭제
					DongDAO dongdao = new DongDAO();
					vdong = dongdao.getDongListAll(cb_sido.getSelectedItem().toString(),
							cb_gugun.getSelectedItem().toString());
					for (int i = 0; i < vdong.size(); i++) {
						cb_dong.addItem(vdong.get(i));
					}
					cb_dong.setSelectedIndex(0);
				}
			}
		});
		cb_gugun.setBounds(212, 346, 110, 34);
		frame.getContentPane().add(cb_gugun);

		cb_dong = new JComboBox(this.vdong);
		cb_dong.setFont(new Font("굴림", Font.PLAIN, 11));
		cb_dong.setBounds(334, 346, 110, 34);
		frame.getContentPane().add(cb_dong);

		// 회원 가입 처리
		btn_add = new Button(" \uAC00 \uC785");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMemberData();
			}
		});
		btn_add.setFont(new Font("Dialog", Font.BOLD, 19));
		btn_add.setBounds(141, 405, 76, 38);
		frame.getContentPane().add(btn_add);

		// 회원 취소 처리
		btn_cancel = new Button(" \uCDE8 \uC18C ");
		btn_cancel.setFont(new Font("Dialog", Font.BOLD, 19));

		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cancelMemberData();

				// if (e.getActionCommand().equals("취소")) {
				// System.out.println("btn_cancel :"+ e.getActionCommand() );
				// cancelMemberData();
				// }
			}
		});

		btn_cancel.setBounds(261, 405, 76, 38);
		btn_cancel.setFont(new Font("Dialog", Font.BOLD, 25));
		frame.getContentPane().add(btn_cancel);

	} // end of initialize()

	// 회원 가입 정보를 DB에 추가한다.
	private void addMemberData() {

		// imsi
		String registdate = "";
		String authdate = "";
		int sticker = 0;
		// imsi
		
		boolean add_result;

		MembersDAO membersDAO = new MembersDAO();
		add_result = membersDAO.setMembersAdd(tf_email.getText(), tf_pw.getText(), tf_name.getText(), tf_tel.getText(),
				cb_sido.getSelectedItem().toString(), cb_gugun.getSelectedItem().toString(), cb_dong.getSelectedItem().toString(), registdate,
				authdate, sticker);

		if (add_result) {
			JOptionPane.showMessageDialog(null, "회원가입을 축하합니다");
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "회원가입을 다시 시도해주십시요");
		}

	} // end of addMemberData()

	// 회원 가입 취소
	private void cancelMemberData() {

		JOptionPane.showMessageDialog(null, "회원가입을 취소합니다");
		frame.dispose();
	} // end of cancelMemberData()

}