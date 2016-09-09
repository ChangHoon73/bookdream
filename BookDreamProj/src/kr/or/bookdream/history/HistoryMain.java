package kr.or.bookdream.history;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import kr.or.bookdream.MainView;
import kr.or.bookdream.books.HomeDetail;
import kr.or.bookdream.dao.HistoryDAO;
import kr.or.bookdream.vo.Books;

public class HistoryMain extends JPanel {
	
	private JTable table;
	private JScrollPane scrollPane;
	
	private Vector<Books> vhbooks;
	private MainView mMainView;
	/**
	 * Create the panel.
	 */
	public HistoryMain(MainView mMainView) {
		this.mMainView = mMainView;
		initialize();
		
		HistoryDetail historyDetail = new HistoryDetail(mMainView, 0); 
		mMainView.setDetailPanel(historyDetail);// 추가
	}
	
	
	public void initialize(){
		this.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 480, 550);
		this.add(scrollPane);
		
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
				
				HistoryDetail historyDetail = new HistoryDetail(mMainView, books_no); 
				mMainView.setDetailPanel(historyDetail);// 추가
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
		
	}
}
