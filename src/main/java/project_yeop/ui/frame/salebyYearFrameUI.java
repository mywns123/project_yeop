package project_yeop.ui.frame;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_yeop.service.salebyDateService;
import project_yeop.ui.panel.table.salebyYearTablePanel;

@SuppressWarnings("serial")
public class salebyYearFrameUI extends JFrame {

	private JPanel contentPane;
	private salebyYearTablePanel pTable;
	private salebyDateService service;

	public salebyYearFrameUI() {
		setService();
		initialize();
		tableLoadData();
	}
	
	private void tableLoadData() {
		(( salebyYearTablePanel) pTable).setService(service);
		pTable.loadData();
		
	}

	private void setService() {
		service = new salebyDateService();
		
	}

	private void initialize() {
		setTitle("월별 매출");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
	
		pTable = new salebyYearTablePanel();
		contentPane.add(pTable);
	}
	
}
