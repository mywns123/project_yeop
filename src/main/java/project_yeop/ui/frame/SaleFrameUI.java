package project_yeop.ui.frame;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_yeop.service.SalesService;
import project_yeop.ui.panel.table.SaleTablePanel;

@SuppressWarnings("serial")
public class SaleFrameUI extends JFrame {

	private JPanel contentPane;
	private SaleTablePanel pTable;
	private SalesService service;

	public SaleFrameUI() {
		setService();
		initialize();
		tableLoadData();
	}
	
	private void tableLoadData() {
		(( SaleTablePanel) pTable).setService(service);
		pTable.loadData();
		
	}

	private void setService() {
		service = new SalesService();
		
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
	
		pTable = new SaleTablePanel();
		contentPane.add(pTable);
	}
	
}
