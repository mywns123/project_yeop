package project_yeop.ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import project_yeop.exception.InvalidationException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.ui.frame.CustomerFrameUI;
import project_yeop.ui.frame.OrderFrameUI;

@SuppressWarnings("serial")
public class OdStateUI extends JPanel implements ActionListener {

	public OdStateUI() {
		initialize();
	}

	private void initialize() {

		JPopupMenu popupMenu = createPopupMenu();
		add(popupMenu);
	}

	private JPopupMenu createPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("편집");
		updateItem.addActionListener(this);
		popMenu.add(updateItem);

		return popMenu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() instanceof JMenuItem) {
				if (e.getActionCommand().equals("편집")) {
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
}
