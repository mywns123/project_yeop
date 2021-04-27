package project_yeop.ui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import project_yeop.dto.Column;
import project_yeop.dto.Order;
import project_yeop.exception.InvalidationException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.service.ColumnService;
import project_yeop.service.OrderService;
import project_yeop.ui.frame.OrderFrameUI;
import project_yeop.ui.panel.insert.OrderRelPanel;
import project_yeop.ui.panel.table.OrderComTablePanel;

@SuppressWarnings("serial")
public class ReleasedUI extends JPanel implements ActionListener {

	private JTextField tfSearch;
	private JComboBox<Column> comCul;
	private OrderComTablePanel pTable;
	private OrderService service;
	private ColumnService service1;
	private JButton btnFind;
	private JPanel pCenter;
	private JPanel pSouth;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private OrderRelPanel pRel;

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
		List<Column> list = service1.odTableColumn();
		DefaultComboBoxModel<Column> model = new DefaultComboBoxModel<>(new Vector<>(list));
		comCul.setModel(model);
		comCul.setModel(model);
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

		JPopupMenu popupMenu = createPopupMenu();
		pTable.setPopupMenu(popupMenu);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("관리");
		updateItem.addActionListener(this);
		popMenu.add(updateItem);

		JMenuItem relItem = new JMenuItem("출고");
		relItem.addActionListener(this);
		popMenu.add(relItem);

		return popMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() instanceof JMenuItem) {
				if (e.getActionCommand().equals("관리")) {
					actionPerformdMenuUpdate();
				}
				if (e.getActionCommand().equals("출고")) {
					actionPerformdMenuRel();
				}
			} else {
				if (e.getSource() == btnNewButton) {
					actionPerformedBtnNewButton(e);
				}
				if (e.getSource() == btnNewButton_1) {
					actionPerformedBtnNewButton_1(e);
				}
			}
		} catch (InvalidationException | SqlConstraintException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void actionPerformdMenuRel() {
		Order order = pTable.getItem().getOrder();	
		pRel.setItem(order);
	}

	private void actionPerformdMenuUpdate() {
		OrderFrameUI frame = new OrderFrameUI();
		frame.setVisible(true);
	}

	protected void setService() {
		service = new OrderService();
		service1 = new ColumnService();
	}

	protected void tableLoadData() {
		((OrderComTablePanel) pTable).setService(service);
		pTable.loadData();
	}

	protected OrderComTablePanel creatTablePanel() {
		return new OrderComTablePanel();
	}

	protected void actionPerformedBtnFind(ActionEvent e) {

	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {
		Order order = new Order(pRel.getItem().getNo());
		service.RelOrder(order);
		pTable.loadData();
		pRel.clearTf();
		JOptionPane.showMessageDialog(null, order.getCtNo() + "출고처리되었습니다.");
	}

	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		pRel.clearTf();
	}
}
