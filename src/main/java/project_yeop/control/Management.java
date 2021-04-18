package project_yeop.control;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Management extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		tabbedPane.addTab("세탁물 주문입력", null, pOrder, null);
		
		JPanel pNow = new JPanel();
		tabbedPane.addTab("접수현황", null, pNow, null);
		
		JPanel pLaundry = new JPanel();
		tabbedPane.addTab("세탁물분류", null, pLaundry, null);
		
		JPanel pCustomer = new JPanel();
		tabbedPane.addTab("회원관리", null, pCustomer, null);
		
		JPanel pGrade = new JPanel();
		tabbedPane.addTab("회원등급관리", null, pGrade, null);
		
		JPanel pSale = new JPanel();
		tabbedPane.addTab("매출관리", null, pSale, null);
	}

}
