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
import project_yeop.ui.panel.insert.OrderRelPanel;
import project_yeop.ui.panel.table.OrderComTablePanel;

@SuppressWarnings("serial")
public class ReleasedUI extends JPanel implements ActionListener {

	private JTextField tfSearch;
	private JComboBox<String> comCul;
	private OrderComTablePanel pTable;
	private OrderService service;
	private JButton btnFind;
	private JPanel pCenter;
	private JPanel pSouth;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private OrderRelPanel pRel;
	List<OdTable> list;
	private JButton btnMod;
	
	public ReleasedUI() {
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
		
		btnMod = new JButton("출고");
		btnMod.addActionListener(this);
		panel_2.add(btnMod);

		pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);

		pTable = creatTablePanel();
		pCenter.add(pTable);

		pRel = new OrderRelPanel();
		pCenter.add(pRel);

		pSouth = new JPanel();
		add(pSouth, BorderLayout.SOUTH);

		btnNewButton = new JButton("출고");
		btnNewButton.addActionListener(this);
		pSouth.add(btnNewButton);

		btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(this);
		pSouth.add(btnNewButton_1);
		pCenter.setLayout(new GridLayout(0, 1, 0, 0));
	
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
			if (e.getSource() == btnNewButton) {
					actionPerformedBtnNewButton(e);
			}
			if (e.getSource() == btnNewButton_1) {
					actionPerformedBtnNewButton_1(e);				
			}
		} catch (InvalidationException | SqlConstraintException| NullException | NotSelectedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void actionPerformedBtnMod(ActionEvent e) {
		Order order = pTable.getItem().getOrder();	
		pRel.setItem(order);
	}

	protected void setService() {
		service = new OrderService();

	}

	protected void tableLoadData() {
		((OrderComTablePanel) pTable).setService(service);
		pTable.loadData();
	}

	protected OrderComTablePanel creatTablePanel() {
		return new OrderComTablePanel();
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
			list = service.showOdTableUnCompleteNo(no);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원번호") {
			stringCheck();
			validCheck();
			int cno = Integer.parseInt(tf);
			list = service.showOdTableUnCompleteCNo(cno);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원명") {
			validCheck();
			intCheck();
			String cName = tf;
			list = service.showOdTableUnCompleteCName(cName);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "세탁물 코드") {
			intCheck();
			validCheck();
			String code = tf;
			list = service.showOdTableUnCompleteCode(code);
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
			list = service.showOdTableUnCompleteProduct(product);
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
	
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		Order order = new Order(pRel.getItem().getNo());
		service.RelOrder(order);
		pTable.loadData();
		pRel.clearTf();
		JOptionPane.showMessageDialog(null, order.getNo() + "출고처리되었습니다.");
	}

	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		pRel.clearTf();
	}
}
