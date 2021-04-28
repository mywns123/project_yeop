package project_yeop.control;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project_yeop.ui.frame.CustomerFrameUI;
import project_yeop.ui.frame.GradeFrameUI;
import project_yeop.ui.frame.LaundryFrameUI;
import project_yeop.ui.frame.OrderFrameUI;
import project_yeop.ui.frame.salebyCtFrameUI;
import project_yeop.ui.frame.salebyMonthFrameUI;
import project_yeop.ui.frame.salebyYearFrameUI;
import project_yeop.ui.frame.salebylLaundryFrameUI;
import project_yeop.ui.panel.CheckUI;
import project_yeop.ui.panel.CtStateUI;
import project_yeop.ui.panel.OdStateUI;
import project_yeop.ui.panel.OrderUI;
import project_yeop.ui.panel.ReleasedUI;
import project_yeop.ui.panel.UnReleasedUI;

@SuppressWarnings("serial")
public class Management extends JFrame implements ActionListener {

	public JPanel contentPane;
	private JButton btuGrade;
	private JButton btuLaundry;
	private JButton btuCus;
	private JButton btuSalesbyLaundry;
	private JButton btnOrder;
	private JButton btuSalesbyMonth;
	private JButton btuSalesbyYear;
	private JButton btuSalesbyCt;
	public JPanel pCheck;

	public Management() {
		initialize();
		setService();
	}
	
	private void setService() {
//		ColumnService service1 = new ColumnService();				
//		CustomerService service	= new CustomerService();		
		
	}

	private void initialize() {
		setTitle("세탁물 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel pOrder = new OrderUI();
		tabbedPane.addTab("주문입력", null, pOrder, null);		
		
		pCheck = new CheckUI();
		tabbedPane.addTab("조회", null, pCheck, null);		
				
		JPanel pReleased = new ReleasedUI();
		tabbedPane.addTab("세탁물 출고", null, pReleased, null);		
				
		JPanel pUnReleased = new UnReleasedUI();
		tabbedPane.addTab("미출고", null, pUnReleased, null);
		
		JPanel pOdState = new OdStateUI();
		tabbedPane.addTab("전체주문현황", null, pOdState, null);
		
		JPanel pCtState = new CtStateUI();
		tabbedPane.addTab("회원 조회", null, pCtState, null);
		
		JPanel pPS = new JPanel();
		tabbedPane.addTab("관리/설정 및 통계", null, pPS, null);
		pPS.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pManagement = new JPanel();
		pManagement.setBorder(new TitledBorder(null, "관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pPS.add(pManagement);
		pManagement.setLayout(new GridLayout(0, 2, 20, 0));
		
		btuCus = new JButton("회원 관리");
		btuCus.addActionListener(this);
		
		btnOrder = new JButton("주문 관리");
		btnOrder.addActionListener(this);
		pManagement.add(btnOrder);
		pManagement.add(btuCus);
		
		JPanel pStatistics = new JPanel();
		pStatistics.setBorder(new TitledBorder(null, "통계", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pPS.add(pStatistics);
		pStatistics.setLayout(new GridLayout(1, 1, 10, 0));
		
		btuSalesbyMonth = new JButton("월별 제품 매출");
		btuSalesbyMonth.addActionListener(this);
		pStatistics.add(btuSalesbyMonth);
		
		btuSalesbyYear = new JButton("월별 매출");
		btuSalesbyYear.addActionListener(this);
		pStatistics.add(btuSalesbyYear);
		
		btuSalesbyLaundry = new JButton("제품별 누적 매출");
		pStatistics.add(btuSalesbyLaundry);
		
		btuSalesbyCt = new JButton("회원별 누적 매출");
		btuSalesbyCt.addActionListener(this);
		pStatistics.add(btuSalesbyCt);
		btuSalesbyLaundry.addActionListener(this);
		
		JPanel pSetting = new JPanel();
		pSetting.setBorder(new TitledBorder(null, "설정", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pPS.add(pSetting);
		pSetting.setLayout(new GridLayout(0, 2, 20, 0));
		
		btuGrade = new JButton("회원등급표");
		btuGrade.addActionListener(this);
		pSetting.add(btuGrade);
		
		btuLaundry = new JButton("세탁물코드표");
		btuLaundry.addActionListener(this);
		pSetting.add(btuLaundry);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btuSalesbyCt) {
			actionPerformedBtuSalesbyCt(e);
		}
		if (e.getSource() == btuSalesbyYear) {
			actionPerformedBtuSalesbyYear(e);
		}
		if (e.getSource() == btuSalesbyMonth) {
			actionPerformedBtuSalesbyMonth(e);
		}
		if (e.getSource() == btnOrder) {
			actionPerformedBtnOrder(e);
		}		
		if (e.getSource() == btuSalesbyLaundry) {
			actionPerformedBtuSales(e);
		}
		if (e.getSource() == btuCus) {
			actionPerformedBtuCus(e);
		}
		if (e.getSource() == btuLaundry) {
			actionPerformedBtuLaundry(e);
		}
		if (e.getSource() == btuGrade) {
			actionPerformedBtuGrade(e);
		}
	}
	protected void actionPerformedBtuGrade(ActionEvent e) {
		GradeFrameUI frame = new GradeFrameUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuLaundry(ActionEvent e) {
		LaundryFrameUI frame = new LaundryFrameUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuCus(ActionEvent e) {
		CustomerFrameUI frame = new CustomerFrameUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuSales(ActionEvent e) {
		salebylLaundryFrameUI frame = new salebylLaundryFrameUI();
		frame.setVisible(true);
	}	
	protected void actionPerformedBtnOrder(ActionEvent e) {
		OrderFrameUI frame = new OrderFrameUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuSalesbyMonth(ActionEvent e) {
		salebyMonthFrameUI frame = new salebyMonthFrameUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuSalesbyYear(ActionEvent e) {
		salebyYearFrameUI frame = new salebyYearFrameUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuSalesbyCt(ActionEvent e) {
		salebyCtFrameUI frame = new salebyCtFrameUI();
		frame.setVisible(true);
	}
}
