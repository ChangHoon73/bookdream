package kr.or.bookdream.history;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import kr.or.bookdream.books.HomeDetail;
import kr.or.bookdream.dao.BooksDAO;
import kr.or.bookdream.dao.HistoryDAO;
import kr.or.bookdream.vo.Books;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Font;

public class HistoryMain {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	
	private Vector<Books> vhbooks;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryMain window = new HistoryMain();
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
	public HistoryMain() {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 48, 504, 570);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 480, 550);
		panel.add(scrollPane);
		
		vhbooks = new Vector<Books>();
		
		HistoryDAO historydao = new HistoryDAO();
		vhbooks = historydao.getHistoryListAll();
		
		DefaultTableModel dtm = new DefaultTableModel(){
			// 에디터 금지
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dtm.addColumn("no");
		dtm.addColumn("책제목");
		dtm.addColumn("지은이");
		dtm.addColumn("출판사");

		
		DefaultTableColumnModel dtcm = new DefaultTableColumnModel();
		TableColumn tc1 = new TableColumn(0,0);
		tc1.setHeaderValue("no");
		tc1.setMaxWidth(0);
		dtcm.addColumn(tc1);
		TableColumn tc2 = new TableColumn(1, 200);
		tc2.setHeaderValue("책제목");
		dtcm.addColumn(tc2);
		TableColumn tc3 = new TableColumn(2);
		tc3.setHeaderValue("지은이");
		dtcm.addColumn(tc3);
		TableColumn tc4 = new TableColumn(3);
		tc4.setHeaderValue("출판사");
		dtcm.addColumn(tc4);

		DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
		dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table = new JTable(dtm, dtcm, dlsm);	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectIndex = table.getSelectedRow();
				int books_no = (int)table.getValueAt(selectIndex, 0);
				System.out.println(books_no);
				

				
				JPanel detailPanel = new JPanel();
				detailPanel.setLayout(new BorderLayout());
				detailPanel.add(new HistoryDetail(books_no));
				scrollPane.setViewportView(detailPanel);
			}
		});
		scrollPane.setViewportView(table);
		
		JTableHeader jth = new JTableHeader(dtcm);
		jth.setReorderingAllowed(false); // 위치변경
		jth.setResizingAllowed(false); // 크기변경
		table.setTableHeader(jth);
		
		for(int i = 0; i< vhbooks.size(); i++){
			dtm.addRow(new Object[]{
					vhbooks.get(i).getNo(),
					vhbooks.get(i).getTitle(),
					vhbooks.get(i).getAuthor(),
					vhbooks.get(i).getPublisher()
			});
		}	
		
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(539, 48, 457, 570);
		frame.getContentPane().add(panel_1);


	}
}
