package project_yeop.ui.frame;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_yeop.service.salebylLaundryService;
import project_yeop.ui.panel.table.salebylLaundryTablePanel;

@SuppressWarnings("serial")
public class salebylLaundryFrameUI extends JFrame {

	private JPanel contentPane;
	private salebylLaundryTablePanel pTable;
	private salebylLaundryService service;

	public salebylLaundryFrameUI() {
		setService();
		initialize();
		tableLoadData();
	}
	
	private void tableLoadData() {
		(( salebylLaundryTablePanel) pTable).setService(service);
		pTable.loadData();
		
	}

	private void setService() {
		service = new salebylLaundryService();
		
	}

	private void initialize() {
		setTitle("제품별 누적 매출");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
	
		pTable = new salebylLaundryTablePanel();
		contentPane.add(pTable);
	}
	
}
