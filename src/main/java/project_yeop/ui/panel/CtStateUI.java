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

import project_yeop.control.Management;
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;
import project_yeop.exception.InvalidationException;
import project_yeop.exception.NotSelectedException;
import project_yeop.exception.NullException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.service.CustomerService;
import project_yeop.ui.frame.CustomerFrameUI;
import project_yeop.ui.panel.table.CustomerTablePanel;

@SuppressWarnings("serial")
public class CtStateUI extends JPanel implements ActionListener {
	private JTextField tfSearch;
	private JComboBox<String> comCul;
	private CustomerTablePanel pTable;
	private CustomerService service;
	private JButton btnFind;
	List<CtTable> list;	
	private JButton btnMod;
	private Management mgn;

	public CtStateUI(Management mgn) {
		this.mgn = mgn;
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
		String[] sArr = { "전체보기", "회원번호", "회원명", "성별", "회원등급", "미출고회원" };
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

		btnFind = new JButton("찾기");
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

	protected void setService() {
		service = new CustomerService();
	}

	protected void tableLoadData() {
		pTable.setService(service);
		pTable.loadData();
	}

	protected CustomerTablePanel creatTablePanel() {
		return new CustomerTablePanel();
	}

	protected void actionPerformedBtnFind(ActionEvent e) {
		String com = (String) comCul.getSelectedItem();
		String tf = tfSearch.getText().trim();

		if (com == "전체보기") {
			pTable.loadData();
		} else if (com == "미출고") {
			list = service.showCtTableUnRel();
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원등급") {
			validCheck();
			intCheck();
			String grade = tf;
			list = service.showCtTableGrade(grade);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원명") {
			validCheck();
			intCheck();
			String name = tf;
			list = service.showCtTableName(name);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원번호") {
			stringCheck();
			validCheck();
			int no = Integer.parseInt(tf);
			list = service.showCtTableNO(no);
			if (list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "성별" && tfSearch != null) {
			validCheck();
			intCheck();
			if (tf.equals("남성")) {
				boolean gender = false;
				list = service.showCtTableGender(gender);
			} else if (tf.equals("여성")) {
				boolean gender = true;
				list = service.showCtTableGender(gender);
			}
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

	protected void actionPerformedBtnMod(ActionEvent e) {
		Customer customer;
		try {
			customer = pTable.getItem().getCustomer();
		} catch (Exception e1) {
			throw new NotSelectedException();
		}
		CustomerFrameUI frame = new CustomerFrameUI(mgn);
		frame.pPanel.setItem(customer);
		frame.btnAdd.setText("수정");
		frame.setVisible(true);
	}
	
	///////////////////////갱신
	public void reLoadData() {
		pTable.loadData();
	}
}