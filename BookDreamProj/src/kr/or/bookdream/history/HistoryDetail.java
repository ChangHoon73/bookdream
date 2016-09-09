package kr.or.bookdream.history;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import kr.or.bookdream.MainView;
import kr.or.bookdream.dao.HistoryDAO;
import kr.or.bookdream.vo.History;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoryDetail extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private Vector<History> vhistory;
	private MainView mMainView;
	
	public HistoryDetail(MainView mMainView, int books_no) 
	{
		this.mMainView = mMainView;
		initialize(books_no);
	}
	
	public void initialize(int books_no){
		setForeground(Color.WHITE);
		setLayout(null);
		
		JButton btnNewButton = new JButton("\uC18C\uC720\uC790 \uC774\uB825");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("휴먼둥근헤드라인", Font.BOLD, 18));
		btnNewButton.setBounds(149, 10, 171, 39);
		add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 63, 433, 489);
		add(scrollPane);
		
		vhistory = new Vector<History>();
		
		HistoryDAO historydao = new HistoryDAO();
		vhistory = historydao.getHistorySelectId(books_no);
	
		DefaultTableModel dtm = new DefaultTableModel(){
			// 에디터 금지
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dtm.addColumn("no");
		dtm.addColumn("날   짜");
		dtm.addColumn("소유자");
		
		DefaultTableColumnModel dtcm = new DefaultTableColumnModel();
		TableColumn tc1 = new TableColumn(0,0);
		tc1.setHeaderValue("no");
		tc1.setMaxWidth(0);
		dtcm.addColumn(tc1);
		TableColumn tc2 = new TableColumn(1, 200);
		tc2.setHeaderValue("날   짜");
		dtcm.addColumn(tc2);
		TableColumn tc3 = new TableColumn(2);
		tc3.setHeaderValue("소유자");
		dtcm.addColumn(tc3);

		DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
		dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table = new JTable(dtm, dtcm, dlsm);	
		scrollPane.setViewportView(table);

		JTableHeader jth = new JTableHeader(dtcm);
		jth.setReorderingAllowed(false); // 위치변경
		jth.setResizingAllowed(false); // 크기변경
		table.setTableHeader(jth);
		

		
		for(int i = 0; i< vhistory.size(); i++){
			dtm.addRow(new Object[]{
					vhistory.get(i).getNo(),
					vhistory.get(i).getWdate(),
					vhistory.get(i).getMembers_name()
			});
		}	
	}
}
