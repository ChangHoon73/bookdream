package kr.or.bookdream.members;

import java.awt.EventQueue;

import javax.swing.JFrame;

import kr.or.bookdream.dao.MembersDAO;
import kr.or.bookdream.vo.Members;

import java.awt.Label;
import java.awt.TextField;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MemberUpdate {

	private JFrame frame;
	private JComboBox cb_sido;
	private JComboBox cb_gugun;
	private JComboBox cb_gong;
	private TextField tf_email;
	private TextField tf_name;
	private MembersDAO membersDAO;
	private Vector<Members> vmembers;
	private String MembersEmail;
	private int memberno = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUpdate window = new MemberUpdate();
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
	public MemberUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// 회원정보의 이메일 주소를 받아 회원정보를 출력해주고
		// 수정이나 탈퇴처리를 한다.

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 462, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Label label = new Label("  \uD68C\uC6D0\uC815\uBCF4 \uC218\uC815/\uBCC0\uACBD");
		label.setBackground(new Color(250, 235, 215));
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		label.setBounds(123, 10, 242, 40);
		frame.getContentPane().add(label);

		Label label_1 = new Label("\uC774\uBA54\uC77C");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_1.setBounds(35, 65, 69, 37);
		frame.getContentPane().add(label_1);

		Label label_2 = new Label("\uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_2.setBounds(35, 122, 69, 37);
		frame.getContentPane().add(label_2);

		Label label_3 = new Label("\uBE44\uBC00\uBC88\uD638\uD655\uC778");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_3.setBounds(35, 180, 100, 37);
		frame.getContentPane().add(label_3);

		Label label_4 = new Label("\uC774\uB984");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_4.setBounds(35, 230, 69, 37);
		frame.getContentPane().add(label_4);

		Label label_5 = new Label("\uC804\uD654\uBC88\uD638");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_5.setBounds(35, 279, 69, 37);
		frame.getContentPane().add(label_5);

		Label label_6 = new Label("\uC8FC\uC18C");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_6.setBounds(35, 333, 69, 23);
		frame.getContentPane().add(label_6);

		cb_sido = new JComboBox();
		cb_sido.setBounds(111, 333, 76, 30);
		frame.getContentPane().add(cb_sido);

		cb_gugun = new JComboBox();
		cb_gugun.setBounds(199, 333, 96, 30);
		frame.getContentPane().add(cb_gugun);

		cb_gong = new JComboBox();
		cb_gong.setBounds(307, 333, 100, 30);
		frame.getContentPane().add(cb_gong);

		Button btn_update = new Button("\uC218\uC815");
		btn_update.setFont(new Font("Dialog", Font.BOLD, 20));
		btn_update.setBounds(140, 391, 76, 40);
		frame.getContentPane().add(btn_update);

		Button btn_drop = new Button("\uD0C8\uD1F4");
		btn_drop.setFont(new Font("Dialog", Font.BOLD, 20));
		btn_drop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_drop.setBounds(270, 391, 76, 40);
		frame.getContentPane().add(btn_drop);

		memberno = 1;
		membersDAO = new MembersDAO();
		System.out.println("membersno = " + memberno);
		
		vmembers = new Vector<Members>();
		System.out.println("after new " );
		
		vmembers = membersDAO.getMembersSelectId(memberno);
		System.out.println("after membersDAO.getMembersSelectId(memberno) " );
		
//?????
		String text = vmembers.get(0).getEmail();
		System.out.println("membersno === " + memberno);

		TextField tf_email = new TextField();
		tf_email.setText(text);
		tf_email.setBounds(141, 65, 235, 37);
		frame.getContentPane().add(tf_email);

//?????
		String textname = vmembers.get(0).getName().toString();
		
		tf_name = new TextField(textname);
		tf_name.setBounds(141, 230, 235, 37);
		frame.getContentPane().add(tf_name);

		TextField tf_pw = new TextField();
		tf_pw.setBounds(141, 122, 235, 37);
		frame.getContentPane().add(tf_pw);

		TextField tf_pwconfirm = new TextField();
		tf_pwconfirm.setBounds(141, 180, 235, 37);
		frame.getContentPane().add(tf_pwconfirm);

//?????
		String texttel = vmembers.get(0).getTel().toString();
		TextField tf_tel = new TextField(texttel);
		tf_tel.setBounds(141, 279, 235, 37);
		frame.getContentPane().add(tf_tel);
		
	} // end of initialize()
}