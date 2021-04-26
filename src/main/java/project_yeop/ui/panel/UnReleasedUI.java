package project_yeop.ui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import project_yeop.dto.Column;
import project_yeop.exception.InvalidationException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.service.ColumnService;
import project_yeop.service.OrderService;
import project_yeop.ui.frame.OrderFrameUI;
import project_yeop.ui.panel.table.OrderRelTablePanel;

@SuppressWarnings("serial")
public class UnReleasedUI extends JPanel implements ActionListener {

	private JTextField tfSearch;
	private JComboBox<Column> comCul;
	private OrderRelTablePanel pTable;
	private OrderService service;
	private ColumnService service1;
	private JButton btnFind;
	
	public UnReleasedUI() {
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
			}
		} catch (InvalidationException | SqlConstraintException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void actionPerformdMenuUpdate() {
		OrderFrameUI frame = new OrderFrameUI();
		frame.setVisible(true);
	}

	protected void setService() {
		service = new OrderService();
		service1 = new ColumnService();
		List<Column> list = service1.odTableColumn();
		for (Column e : list) {
			System.out.println(e);
		}
		/*
		 * DefaultComboBoxModel<Column> model = new DefaultComboBoxModel<>(new
		 * Vector<>(list)); comCul.setModel(model);
		 * 
		 * comCul.setSelectedIndex(-1);
		 */
	}

	protected void tableLoadData() {
		((OrderRelTablePanel) pTable).setService(service);
		pTable.loadData();
	}

	protected OrderRelTablePanel creatTablePanel() {
		return new OrderRelTablePanel();
	}

	protected void actionPerformedBtnFind(ActionEvent e) {

	}
}
