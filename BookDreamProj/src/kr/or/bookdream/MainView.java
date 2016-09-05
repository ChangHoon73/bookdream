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

public class MainView {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 21, 468, 631);
		frame.getContentPane().add(tabbedPane);
		
		JPanel homePanel = new JPanel();
		tabbedPane.addTab("HOME", null, homePanel, null);
		homePanel.setLayout(new BorderLayout());
		homePanel.add(new HomeMain());
		
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
