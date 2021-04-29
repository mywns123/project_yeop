package project_yeop.ui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project_yeop.dto.OdTable;
import project_yeop.dto.Order;
import project_yeop.exception.InvalidationException;
import project_yeop.exception.NotSelectedException;
import project_yeop.exception.NullException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.service.OrderService;
import project_yeop.ui.frame.OrderFrameUI;
import project_yeop.ui.panel.table.OrderTablePanel;

@SuppressWarnings("serial")
public class OdStateUI extends JPanel implements ActionListener {

	private JTextField tfSearch;
	private JComboBox<String> comCul;
	private OrderTablePanel pTable;
	private OrderService service;
	private JButton btnFind;
	private JButton btnMod;
	List<OdTable> list;

	public OdStateUI() {
		setService();
		initialize();
		tableLoadData();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		comCul = new JComboBox<>();
		String[] sArr = { "전체보기", "주문번호", "회원번호", "회원명", "세탁물 코드", "제품명"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(sArr);
		comCul.setModel(model);	
		comCul.setSelectedIndex(0);
		panel.add(comCul);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));

		tfSearch = new JTextField();
		panel_2.add(tfSearch);
		tfSearch.setColumns(10);

		btnFind = new JButton("검색");
		btnFind.addActionListener(this);
		panel_2.add(btnFind);
		
		btnMod = new JButton("수정");
		btnMod.addActionListener(this);
		panel_2.add(btnMod);

		pTable = creatTablePanel();
		add(pTable);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnFind) {
				actionPerformedBtnFind(e);
			}
			if (e.getSource() == btnMod) {
				actionPerformedBtnMod(e);
			}
		
		} catch (InvalidationException | SqlConstraintException | NullException | NotSelectedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void actionPerformedBtnMod(ActionEvent e) {
		Order order;
		try {
			order = pTable.getItem().getOrder();
		} catch (Exception e1) {
			throw new NotSelectedException();
		}
		OrderFrameUI frame = new OrderFrameUI();
		frame.pPanel.setItem(order);
		frame.btnAdd.setText("수정");
		frame.setVisible(true);
		
	}

	protected void setService() {
		service = new OrderService();	
	}

	protected void tableLoadData() {
		pTable.setService(service);
		pTable.loadData();
	}

	protected OrderTablePanel creatTablePanel() {
		return new OrderTablePanel();
	}

	protected void actionPerformedBtnFind(ActionEvent e) {
		String com = (String) comCul.getSelectedItem();
		String tf = tfSearch.getText().trim();
		
		if (com == "전체보기") {
			pTable.loadData();
		}else if (com == "주문번호") {
			stringCheck();
			validCheck();
			
			int no = Integer.parseInt(tf);
			list = service.showOdTableNo(no);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원번호") {
			stringCheck();
			validCheck();
			int cno = Integer.parseInt(tf);
			list = service.showOdTableCNo(cno);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원명") {
			validCheck();
			intCheck();
			String cName = tf;
			list = service.showOdTableCName(cName);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "세탁물 코드") {
			intCheck();
			validCheck();
			String code = tf;
			list = service.showOdTableCode(code);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} 
		else if (com == "제품명") {
			intCheck();
			validCheck();
			String product = tf;
			list = service.showOdTableProduct(product);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} 
	}
	public void validCheck() {
		if (tfSearch.getText().contentEquals("")) {
			throw new InvalidationException();
		}
	}

	public void intCheck() {
		if (isStringDouble(tfSearch.getText())) {
			throw new InvalidationException();// 숫자
		}
	}

	public void stringCheck() {
		if (!isStringDouble(tfSearch.getText())) {
			throw new InvalidationException();// 문자
		}
	}

	public static boolean isStringDouble(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
