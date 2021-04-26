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

import project_yeop.exception.InvalidationException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.ui.panel.insert.AbstractInsertPanel;
import project_yeop.ui.panel.table.AbstractTablePanel;

@SuppressWarnings("serial")
public abstract class AbstractFrameUI<T> extends JFrame implements ActionListener {

	private JPanel contentPane;
	protected JButton btnAdd;
	private JButton btnClear;
	protected AbstractInsertPanel<T> pPanel;
	protected AbstractTablePanel<T> pTable;

	public AbstractFrameUI() {
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

	protected abstract void setService();

	protected abstract void tableLoadData();

	protected abstract AbstractInsertPanel<T> creatPanel();

	protected abstract AbstractTablePanel<T> creatTablePanel();

	protected abstract void actionPerformdMenuUpdate();

	protected abstract void actionPerformdMenuDelete();

	protected abstract void actionPerformedBtnUpdate(ActionEvent e);

	protected abstract void actionPerformedBtnAdd(ActionEvent e);

	protected void actionPerformedBtnClear(ActionEvent e) {
		pPanel.clearTf();

		if (btnAdd.getText().contentEquals("수정")) {
			btnAdd.setText("추가");
		}
	}

}
