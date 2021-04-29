package project_yeop.ui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import project_yeop.dto.CtTable;
import project_yeop.exception.InvalidationException;
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
	List<CtTable> list1;

	public CtStateUI() {
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
		String[] sArr = { "전체보기", "회원번호", "회원명", "성별", "회원등급", "미출고" };
		DefaultComboBoxModel<String> Model = new DefaultComboBoxModel<String>(sArr);

		comCul.setModel(Model);
		comCul.setSelectedIndex(-1);
		panel.add(comCul);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		tfSearch = new JTextField();
		panel_2.add(tfSearch);
		tfSearch.setColumns(10);

		btnFind = new JButton("찾기");
		btnFind.addActionListener(this);
		panel_2.add(btnFind);

		pTable = creatTablePanel();
		add(pTable);

		JPopupMenu popupMenu = createPopupMenu();
		pTable.setPopupMenu(popupMenu);

	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("관리");
		updateItem.addActionListener(this);
		popMenu.add(updateItem);

		return popMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() instanceof JMenuItem) {
				if (e.getActionCommand().equals("관리")) {
					actionPerformdMenuUpdate();
				}
			} else {
				if (e.getSource() == btnFind) {
					actionPerformedBtnFind(e);
				}
			}

		} catch (InvalidationException | SqlConstraintException | NullException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	protected void actionPerformdMenuUpdate() {
		CustomerFrameUI frame = new CustomerFrameUI();
		frame.setVisible(true);
	};

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
		String com1 = "";
		if (com == "전체보기" || com == com1) {
			pTable.loadData();
		} else if (com == "회원등급" && tfSearch != null) {			
			validCheck();
			intCheck();
			String grade = tfSearch.getText().trim();
			list = service.showCtTableGrade(grade);
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원명" && tfSearch != null) {
			validCheck();
			intCheck();
			String name = tfSearch.getText().trim();
			list = service.showCtTableName(name);
			if(list == null) {
				throw new NullException();
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "회원번호") {
			stringCheck();
			validCheck();
			int no = Integer.parseInt(tfSearch.getText().trim());
			list = service.showCtTableNO(no);
			
			pTable.setSearchList(list);
			pTable.setList();
			
		} else if (com == "성별" && tfSearch != null) {
			validCheck();
			intCheck();
			String gen = tfSearch.getText().trim();
			System.out.println(gen);

			if (gen.equals("남성")) {
				boolean gender = false;
				System.out.println(gender);
				list = service.showCtTableGender(gender);
				System.out.println(list);

			} else if (gen.equals("여성")) {
				boolean gender = true;
				System.out.println(gender);
				list = service.showCtTableGender(gender);
			}
			pTable.setSearchList(list);
			pTable.setList();
		} else if (com == "미출고") {
			list = service.showCtTableUnRel();
			pTable.setSearchList(list);
			pTable.setList();
		}else {
			
		}
	}

	public void validCheck() {
		if (tfSearch.getText().contentEquals("")) {
			throw new InvalidationException();
		}
	}

	public void intCheck() {
		if (isStringDouble(tfSearch.getText())) {
			throw new InvalidationException();//숫자
		}
	}
	
	public void stringCheck() {
		if (!isStringDouble(tfSearch.getText())) {
			throw new InvalidationException();//문자
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