package project_yeop.ui.frame;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project_yeop.service.salebyCtService;
import project_yeop.ui.panel.table.salebyCtTablePanel;

@SuppressWarnings("serial")
public class salebyCtFrameUI extends JFrame {

	private JPanel contentPane;
	private salebyCtTablePanel pTable;
	private salebyCtService service;

	public salebyCtFrameUI() {
		setService();
		initialize();
		tableLoadData();
	}
	
	private void tableLoadData() {
		(( salebyCtTablePanel) pTable).setService(service);
		pTable.loadData();
		
	}

	private void setService() {
		service = new salebyCtService();
		
	}

	private void initialize() {
		setTitle("회원별 누적 매출");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
	
		pTable = new salebyCtTablePanel();
		contentPane.add(pTable);
	}
	
}
