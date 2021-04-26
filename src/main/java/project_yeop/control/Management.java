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
import project_yeop.ui.frame.SaleFrameUI;

@SuppressWarnings("serial")
public class Management extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btuGrade;
	private JButton btuLaundry;
	private JButton btuCus;
	private JButton btuSales;
	private JButton btnOrder;

	public Management() {
		initialize();
	}
	
	private void initialize() {
		setTitle("세탁물 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel pOrder = new JPanel();
		tabbedPane.addTab("주문입력", null, pOrder, null);		
		
		JPanel pCheck = new JPanel();
		tabbedPane.addTab("조회 / 수정", null, pCheck, null);		
				
		JPanel pReleased = new JPanel();
		tabbedPane.addTab("세탁물 출고", null, pReleased, null);		
				
		JPanel pUnReleased = new JPanel();
		tabbedPane.addTab("미출고", null, pUnReleased, null);
		
		JPanel pOdState = new JPanel();
		tabbedPane.addTab("전체주문현황", null, pOdState, null);
		
		JPanel pCtState = new JPanel();
		tabbedPane.addTab("회원 조회", null, pCtState, null);
		
		JPanel pPS = new JPanel();
		tabbedPane.addTab("관리 및 설정", null, pPS, null);
		pPS.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pManagement = new JPanel();
		pManagement.setBorder(new TitledBorder(null, "관리", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pPS.add(pManagement);
		pManagement.setLayout(new GridLayout(0, 2, 20, 0));
		
		btuCus = new JButton("고객 관리");
		btuCus.addActionListener(this);
		
		btnOrder = new JButton("주문 관리");
		btnOrder.addActionListener(this);
		pManagement.add(btnOrder);
		pManagement.add(btuCus);
		
		btuSales = new JButton("매출 관리");
		btuSales.addActionListener(this);
		pManagement.add(btuSales);
		
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
		if (e.getSource() == btnOrder) {
			actionPerformedBtnOrder(e);
		}		
		if (e.getSource() == btuSales) {
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
		SaleFrameUI frame = new SaleFrameUI();
		frame.setVisible(true);
	}	
	protected void actionPerformedBtnOrder(ActionEvent e) {
		OrderFrameUI frame = new OrderFrameUI();
		frame.setVisible(true);
	}
}
