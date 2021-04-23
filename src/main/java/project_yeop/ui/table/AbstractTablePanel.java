package project_yeop.ui.table;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class AbstractTablePanel extends JPanel {
	private JTable table;

	public AbstractTablePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
