package kr.or.bookdream;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;

public class HomeMain {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeMain window = new HomeMain();
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
	public HomeMain() {
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 21, 468, 631);
		frame.getContentPane().add(tabbedPane);
		
		JPanel homePanel = new JPanel();
		tabbedPane.addTab("HOME", null, homePanel, null);
		homePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9\uC870\uAC74");
		lblNewLabel.setBounds(12, 22, 57, 15);
		homePanel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 47, 163, 21);
		homePanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(187, 47, 149, 21);
		homePanel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(12, 79, 100, 21);
		homePanel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(124, 78, 100, 21);
		homePanel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(236, 79, 100, 21);
		homePanel.add(comboBox_4);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(348, 78, 97, 23);
		homePanel.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 110, 439, 482);
		homePanel.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JPanel myPanel = new JPanel();
		tabbedPane.addTab(" MY ", null, myPanel, null);
		
		JPanel historyPanel = new JPanel();
		tabbedPane.addTab("HISTORY", null, historyPanel, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 48, 504, 604);
		frame.getContentPane().add(scrollPane);
		
		JPanel detailPanel = new JPanel();
		detailPanel.setLayout(new BorderLayout());
		detailPanel.add(new HomeDetail());
		scrollPane.setViewportView(detailPanel);
	}
}
