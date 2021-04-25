package project_yeop.control;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import project_yeop.ui.CustomerUI;
import project_yeop.ui.GradeUI;
import project_yeop.ui.LaundryUI;
import project_yeop.ui.SaleUI;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class Management extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btuGrade;
	private JButton btuLaundry;
	private JButton btuCus;
	private JButton btuSales;

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
		pOrder.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pNoth = new JPanel();
		pOrder.add(pNoth);
		pNoth.setLayout(new BorderLayout(0, 0));
		
		JPanel pOd = new JPanel();
		pNoth.add(pOd);
		
		JPanel pBtu = new JPanel();
		pNoth.add(pBtu, BorderLayout.SOUTH);
		
		JButton button = new JButton("New button");
		pBtu.add(button);
		
		JButton button_1 = new JButton("New button");
		pBtu.add(button_1);
		
		JPanel pSouth = new JPanel();
		pOrder.add(pSouth);
		pSouth.setLayout(new BorderLayout(0, 0));
		
		JPanel pCart = new JPanel();
		pSouth.add(pCart, BorderLayout.CENTER);
		
		JPanel pBtuCart = new JPanel();
		pSouth.add(pBtuCart, BorderLayout.SOUTH);
		
		JButton button_3 = new JButton("New button");
		pBtuCart.add(button_3);
		
		JButton button_4 = new JButton("New button");
		pBtuCart.add(button_4);
		
		JButton button_5 = new JButton("New button");
		pBtuCart.add(button_5);
		
		JPanel pReleased = new JPanel();
		tabbedPane.addTab("세탁물 출고", null, pReleased, null);
		
		JPanel pCheck = new JPanel();
		tabbedPane.addTab("조회 / 수정", null, pCheck, null);
		
		JPanel pUnReleased = new JPanel();
		tabbedPane.addTab("미출고", null, pUnReleased, null);
		
		JPanel pPS = new JPanel();
		tabbedPane.addTab("관리 및 설정", null, pPS, null);
		pPS.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pManagement = new JPanel();
		pManagement.setBorder(new TitledBorder(null, "\uAD00\uB9AC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pPS.add(pManagement);
		pManagement.setLayout(new GridLayout(0, 2, 20, 0));
		
		btuCus = new JButton("고객 관리");
		btuCus.addActionListener(this);
		pManagement.add(btuCus);
		
		btuSales = new JButton("매출 관리");
		btuSales.addActionListener(this);
		pManagement.add(btuSales);
		
		JPanel pSetting = new JPanel();
		pSetting.setBorder(new TitledBorder(null, "\uC124\uC815", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		GradeUI frame = new GradeUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuLaundry(ActionEvent e) {
		LaundryUI frame = new LaundryUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuCus(ActionEvent e) {
		CustomerUI frame = new CustomerUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtuSales(ActionEvent e) {
		SaleUI frame = new SaleUI();
		frame.setVisible(true);
	}
}
