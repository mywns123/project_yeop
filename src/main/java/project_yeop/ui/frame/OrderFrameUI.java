package project_yeop.ui.frame;

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

import project_yeop.control.Management;
import project_yeop.dto.Order;
import project_yeop.exception.InvalidationException;
import project_yeop.exception.NotSelectedException;
import project_yeop.exception.RelException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.service.LaundryService;
import project_yeop.service.OrderService;
import project_yeop.ui.panel.insert.OrderInsertPanel;
import project_yeop.ui.panel.table.OrderTablePanel;

@SuppressWarnings("serial")
public class OrderFrameUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JButton btnAdd;
	private JButton btnClear;
	public OrderInsertPanel pPanel;
	protected OrderTablePanel pTable;
	private OrderService service;
	private LaundryService lservice;
	private Management mgn;

	public OrderFrameUI(Management mgn) {
		this.mgn = mgn;
		setService();
		initialize();
		tableLoadData();
	}

	private void initialize() {
		setTitle("주문관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pPanel = creatPanel();
		pPanel.setService(lservice);
		contentPane.add(pPanel);
		int no = service.showOdTables().size()+1;		
		pPanel.tfNo.setText(no + "");
		
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
		
		JMenuItem relItem = new JMenuItem("출고");
		relItem.addActionListener(this);
		popMenu.add(relItem);

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
				if (e.getActionCommand().equals("출고")) {
					actionPerformdMenuREl();
				}
			} else {
				if (e.getSource() == btnClear) {
					actionPerformedBtnClear(e);
				}
				if (e.getSource() == btnAdd) {
					if (e.getActionCommand().contentEquals("추가")) {
						actionPerformedBtnAdd(e);
					} else if(e.getActionCommand().contentEquals("수정")){
						actionPerformedBtnUpdate(e);
					}else if(e.getActionCommand().contentEquals("출고")) {
						actionPerformedBtnRel(e);
					}
				}
			}
		} catch (InvalidationException | SqlConstraintException | NotSelectedException | RelException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	

	protected void setService() {
		service = new OrderService();
		lservice = new LaundryService();
	}

	protected void tableLoadData() {
		pTable.setService(service);
		pTable.loadData();

	}

	protected OrderInsertPanel creatPanel() {
		return new OrderInsertPanel();

	}

	protected OrderTablePanel creatTablePanel() {
		return new OrderTablePanel();
	}

	protected void actionPerformdMenuUpdate() {
		Order order;
		try {
			order = pTable.getItem().getOrder();
		} catch (Exception e1) {
			throw new NotSelectedException();
		}		
		pPanel.setItem(order);
		btnAdd.setText("수정");
	}

	private void actionPerformdMenuREl() {
		Order order;
		try {
			order = pTable.getItem().getOrder();
		} catch (Exception e1) {
			throw new NotSelectedException();
		}		
		pPanel.setItem(order);
		btnAdd.setText("출고");		
	}
	
	protected void actionPerformdMenuDelete() {
		Order order;
		try {
			order = pTable.getItem().getOrder();
		} catch (Exception e1) {
			throw new NotSelectedException();
		}
		service.removeOrder(order);
		pTable.loadData();
		JOptionPane.showMessageDialog(null, order + "삭제 되었습니다.");
		mgn.reloadTableData();

	}

	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Order order = pPanel.getItem();
		service.modifyOrder(order);
		pTable.loadData();
		pPanel.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, order + "정보가 수정되었습니다.");
		mgn.reloadTableData();
	}
	
	protected void actionPerformedBtnRel(ActionEvent e) {
		Order order = pPanel.getItem();		
		service.RelOrder(order);
		pTable.loadData();
		pPanel.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, order.getNo() + "출고처리되었습니다.");
		mgn.reloadTableData();
	}
	
	

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Order order = pPanel.getItem();
		service.addOrder(order);
		pTable.loadData();
		pPanel.clearTf();
		JOptionPane.showMessageDialog(null, order.getNo() + " 추가했습니다.");
		int no = service.showOdTables().size()+1;		
		pPanel.tfNo.setText(no + "");

	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pPanel.clearTf();

		if (btnAdd.getText().contentEquals("수정")) {
			btnAdd.setText("추가");
		}
	}

}
