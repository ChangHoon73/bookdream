package kr.or.bookdream.my;

import java.util.Vector;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicComboBoxUI.ComboBoxLayoutManager;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import kr.or.bookdream.MainView;
import kr.or.bookdream.dao.BooksDAO;
import kr.or.bookdream.dao.Cat1DAO;
import kr.or.bookdream.dao.Cat2DAO;
import kr.or.bookdream.dao.DongDAO;
import kr.or.bookdream.dao.GugunDAO;
import kr.or.bookdream.dao.SidoDAO;
import kr.or.bookdream.vo.Books;
import kr.or.bookdream.vo.Category1;
import kr.or.bookdream.vo.Category2;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMain extends JPanel{
	private MainView mMainView; 
	
	private JComboBox cb_cat1;
	private JComboBox cb_cat2;
	private JComboBox cb_sido;
	private JComboBox cb_gugun;
	private JComboBox cb_dong;
	private JTable table;
	private Vector<Category1> vcat1;
	private Vector<Category2> vcat2;
	private Vector<String> vcat1name;
	private Vector<String> vcat2name;
	
	private Vector<String> vsido;
	private Vector<String> vgugun;
	private Vector<String> vdong;
	
	private Vector<Books> vbooks;
	
	public MyMain(MainView mMainView){
		this.mMainView = mMainView;
		initilize();
		this.setLayout(null); // ���� ���̾ƿ��� Absolute Layout���� ����
	}
	
	public void initilize(){
		vcat1 = new Vector<Category1>();
		vcat2 = new Vector<Category2>();
		vcat1name = new Vector<String>();
		vcat2name = new Vector<String>();
		
		vsido = new Vector<String>();
		vgugun = new Vector<String>();
		vdong = new Vector<String>();
		
		vbooks = new Vector<Books>();
		BooksDAO booksdao = new BooksDAO();
		vbooks = booksdao.getBooksListAll();
		
		vcat1name.add("ī�װ�1");
		vcat2name.add("ī�װ�2");
		vsido.add("�õ�����");
		vgugun.add("��������");
		vdong.add("������");
		
		Cat1DAO cat1dao = new Cat1DAO();
		vcat1 = cat1dao.getCat1ListAll();
		for(int i = 0; i< vcat1.size(); i++){
			vcat1name.add(vcat1.get(i).getName());
		}
		
		JLabel lblNewLabel = new JLabel("\uAC80\uC0C9\uC870\uAC74");
		lblNewLabel.setBounds(12, 22, 57, 15);
		this.add(lblNewLabel);
		
		cb_cat1 = new JComboBox(vcat1name);
		cb_cat1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cb_cat2.removeAllItems();
				vcat2name.clear();
				vcat2name.add("��������");
				if( e.getStateChange() == ItemEvent.SELECTED && cb_cat1.getSelectedIndex() > 0 ) {
					
					System.out.println(cb_cat1.getSelectedIndex());
					Cat2DAO cat1dao = new Cat2DAO();
					int indx = cb_cat1.getSelectedIndex()-1;
					vcat2 = cat1dao.getCat2ListAll(vcat1.get(indx).getNo());
					for(int i = 0; i< vcat2.size(); i++){
						vcat2name.add(vcat2.get(i).getName());
					}
				}
				cb_cat2.setSelectedIndex(0);
				
			}
		});
		
		cb_cat1.setBounds(12, 47, 163, 21);
		this.add(cb_cat1);
		
		cb_cat2 = new JComboBox(vcat2name);
		cb_cat2.setBounds(187, 47, 149, 21);
		this.add(cb_cat2);
		
		SidoDAO sidodao = new SidoDAO();
		vsido = sidodao.getSidoListAll();
		
		cb_sido = new JComboBox(this.vsido);
		cb_sido.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if(e.getStateChange() == ItemEvent.SELECTED && cb_sido.getSelectedIndex() > 0 ){
					vgugun.clear();
					cb_gugun.removeAllItems();// �����ۻ���
					cb_dong.removeAllItems();
					cb_dong.addItem("������");
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
		cb_sido.setBounds(12, 79, 100, 21);
		this.add(cb_sido);

		cb_gugun = new JComboBox(this.vgugun);
		cb_gugun.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED && cb_gugun.getSelectedIndex() > 0 ){
					vdong.clear();
					cb_dong.removeAllItems();// �����ۻ���
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
		cb_gugun.setBounds(124, 78, 100, 21);
		this.add(cb_gugun);
		
		cb_dong = new JComboBox(this.vdong);
		cb_dong.setBounds(236, 79, 184, 21);
		this.add(cb_dong);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(432, 78, 97, 23);
		this.add(btnSearch);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 110, 517, 482);
		this.add(scrollPane_1);
		
		DefaultTableModel dtm = new DefaultTableModel(){
			// ������ ����
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dtm.addColumn("no");
		dtm.addColumn("å����");
		dtm.addColumn("������");
		dtm.addColumn("���ǻ�");
		dtm.addColumn("����");
		
		DefaultTableColumnModel dtcm = new DefaultTableColumnModel();
		TableColumn tc1 = new TableColumn(0,0);
		tc1.setHeaderValue("no");
		tc1.setMaxWidth(0);
		dtcm.addColumn(tc1);
		TableColumn tc2 = new TableColumn(1, 200);
		tc2.setHeaderValue("å����");
		dtcm.addColumn(tc2);
		TableColumn tc3 = new TableColumn(2);
		tc3.setHeaderValue("������");
		dtcm.addColumn(tc3);
		TableColumn tc4 = new TableColumn(3);
		tc4.setHeaderValue("���ǻ�");
		dtcm.addColumn(tc4);
		TableColumn tc5 = new TableColumn(4);
		tc5.setHeaderValue("����");
		dtcm.addColumn(tc5);
		DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
		dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table = new JTable(dtm, dtcm, dlsm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ���콺Ŭ���ؼ� �ε����� �̰�
				int seletedIndex = table.getSelectedRow();
				// �Ͻ��� pk  no�� ����
				int booksno = (int) table.getValueAt(seletedIndex, 0);
				// mMainView�� �߰���ưȣ��� ���
				MyDetail homeDetail = new MyDetail(mMainView, booksno); 
				mMainView.setMyBooksno(booksno);
				mMainView.setDetailPanel(homeDetail);// �߰�
				System.out.println(booksno);
				
			}
		});
		scrollPane_1.setViewportView(table);
		
		JTableHeader jth = new JTableHeader(dtcm);
		jth.setReorderingAllowed(false); // ��ġ����
		jth.setResizingAllowed(false); // ũ�⺯��
		table.setTableHeader(jth);
		
		for(int i = 0; i< vbooks.size(); i++){
			dtm.addRow(new Object[]{
					vbooks.get(i).getNo(),
					vbooks.get(i).getTitle(),
					vbooks.get(i).getAuthor(),
					vbooks.get(i).getPublisher()
			});
		}
	}
}
