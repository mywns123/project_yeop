package project_yeop.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import project_yeop.dto.Customer;
import project_yeop.exception.InvalidationException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.service.CustomerService;
import project_yeop.ui.insert.CustomerPanel;
import project_yeop.ui.table.CustomerTablePanel;

@SuppressWarnings("serial")
public class CustomerUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	protected JButton btnAdd;
	private JButton btnClear;
	protected CustomerPanel pPanel;
	protected CustomerTablePanel pTable;
	private CustomerService service;
	
	public CustomerUI() {
		setService();
		initialize();
		tableLoadData();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pPanel = creatPanel();
		contentPane.add(pPanel);

		JPanel pBtn = new JPanel();
		contentPane.add(pBtn);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtn.add(btnAdd);

		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		pBtn.add(btnClear);

		pTable = creatTablePanel();
		contentPane.add(pTable);

		JPopupMenu popupMenu = createPopupMenu();
		pTable.setPopupMenu(popupMenu);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(this);
		popMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(this);
		popMenu.add(deleteItem);

		return popMenu;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() instanceof JMenuItem) {
				if (e.getActionCommand().equals("삭제")) {
					actionPerformdMenuDelete();
				}
				if (e.getActionCommand().equals("수정")) {
					actionPerformdMenuUpdate();
				}

			} else {
				if (e.getSource() == btnClear) {
					actionPerformedBtnClear(e);
				}
				if (e.getSource() == btnAdd) {
					if (e.getActionCommand().contentEquals("추가")) {
						actionPerformedBtnAdd(e);
					} else {
						actionPerformedBtnUpdate(e);
					}
				}
			}
		} catch (InvalidationException | SqlConstraintException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	
	
	protected void setService() {
		service = new CustomerService();
		
	}

	protected void tableLoadData() {
		((CustomerTablePanel) pTable).setService(service);
		pTable.loadData();
		
	}

	protected CustomerPanel creatPanel() {
		return new CustomerPanel();

	}


	protected CustomerTablePanel creatTablePanel() {
		return new CustomerTablePanel();
	}

	protected void actionPerformdMenuUpdate() {
		Customer customer = pTable.getItem().getCustomer();
		pPanel.setItem(customer);
		btnAdd.setText("수정");
	}

	protected void actionPerformdMenuDelete() {
		Customer customer = pTable.getItem().getCustomer();
		service.removeCustomer(customer);
		pTable.loadData();
		JOptionPane.showMessageDialog(null, customer + "삭제 되었습니다.");
		
	}

	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Customer customer = pPanel.getItem();
		service.modifyCustomer(customer);
		pTable.loadData();
		pPanel.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, customer + "정보가 수정되었습니다.");
		
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Customer customer = pPanel.getItem();
		service.addCustomer(customer);
		pTable.loadData();
		pPanel.clearTf();
		JOptionPane.showMessageDialog(null, customer + " 추가했습니다.");
		
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pPanel.clearTf();

		if (btnAdd.getText().contentEquals("수정")) {
			btnAdd.setText("추가");
		}
	}
	

}
