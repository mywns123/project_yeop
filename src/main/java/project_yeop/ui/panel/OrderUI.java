package project_yeop.ui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;
import project_yeop.dto.Grade;
import project_yeop.dto.Order;
import project_yeop.service.CustomerService;
import project_yeop.service.GradeService;
import project_yeop.service.LaundryService;
import project_yeop.service.OrderService;
import project_yeop.ui.panel.insert.OrderInsertPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class OrderUI extends JPanel implements ActionListener {
	private JButton btnAddCart;
	private JButton btnClearCart;
	private JButton btnAdd;
	private JButton btnClear;
	private OrderService service;
	private OrderInsertPanel pOd;
	private LaundryService lservice;
	private JLabel lblcNo;
	private JTextField tfNo;
	private JLabel lblcName;
	private JTextField tfName;
	private JLabel lblgrade;
	private JTextField tfGrade;
	private JLabel lblDis;
	private JTextField tfDis;
	private JLabel lblCode;
	private JTextField tfPro; 
	private JTextField tfUp;
	private JTextField tfCount;
	private JLabel lblCount;
	private JTextField tfPrice;
	private JLabel lblPrice;
	private JTextField tfCode;
	private CustomerService cService;
	private GradeService gService;
	private JLabel lblPro;
	private JLabel lblUp;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;

	public OrderUI() {
		service = new OrderService();
		lservice = new LaundryService();
		cService = new CustomerService();
		gService = new GradeService();
		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pNoth = new JPanel();
		add(pNoth);
		pNoth.setLayout(new BorderLayout(0, 0));

		pOd = new OrderInsertPanel();
		pOd.setService(lservice);
		pNoth.add(pOd);

		JPanel pBtu = new JPanel();
		pNoth.add(pBtu, BorderLayout.SOUTH);

		btnAddCart = new JButton("선택");
		btnAddCart.addActionListener(this);
		pBtu.add(btnAddCart);

		btnClearCart = new JButton("다시입력");
		btnClearCart.addActionListener(this);
		pBtu.add(btnClearCart);

		JPanel pSouth = new JPanel();
		add(pSouth);
		pSouth.setLayout(new BorderLayout(0, 0));

		JPanel pCart = new JPanel();
		pSouth.add(pCart, BorderLayout.CENTER);
		pCart.setLayout(new GridLayout(0, 4, 0, 0));
		
		lblcNo = new JLabel("회원번호");
		lblcNo.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblcNo);
		
		tfNo = new JTextField();
		tfNo.setBackground(Color.WHITE);
		tfNo.setDisabledTextColor(Color.BLACK);
		tfNo.setSelectionColor(Color.BLACK);
		tfNo.setFont(new Font("굴림", Font.BOLD, 14));
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfNo.setEnabled(false);
		pCart.add(tfNo);
		tfNo.setColumns(10);
		
		lblcName = new JLabel("회원명");
		lblcName.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblcName);
		
		tfName = new JTextField();
		tfName.setBackground(Color.WHITE);
		tfName.setDisabledTextColor(Color.BLACK);
		tfName.setSelectionColor(Color.BLACK);
		tfName.setFont(new Font("굴림", Font.BOLD, 14));
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setEnabled(false);
		tfName.setColumns(10);
		pCart.add(tfName);
		
		lblgrade = new JLabel("회원등급");
		lblgrade.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblgrade);
		
		tfGrade = new JTextField();
		tfGrade.setBackground(Color.WHITE);
		tfGrade.setDisabledTextColor(Color.BLACK);
		tfGrade.setSelectionColor(Color.BLACK);
		tfGrade.setFont(new Font("굴림", Font.BOLD, 14));
		tfGrade.setHorizontalAlignment(SwingConstants.CENTER);
		tfGrade.setEnabled(false);
		tfGrade.setColumns(10);
		pCart.add(tfGrade);
		
		lblDis = new JLabel("할인율");
		lblDis.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblDis);
		
		tfDis = new JTextField();
		tfDis.setBackground(Color.WHITE);
		tfDis.setDisabledTextColor(Color.BLACK);
		tfDis.setSelectionColor(Color.BLACK);
		tfDis.setFont(new Font("굴림", Font.BOLD, 14));
		tfDis.setHorizontalAlignment(SwingConstants.CENTER);
		tfDis.setEnabled(false);
		tfDis.setColumns(10);
		pCart.add(tfDis);
		
		lblCode = new JLabel("세탁코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblCode);
		
		tfCode = new JTextField();
		tfCode.setBackground(Color.WHITE);
		tfCode.setDisabledTextColor(Color.BLACK);
		tfCode.setSelectionColor(Color.BLACK);
		tfCode.setFont(new Font("굴림", Font.BOLD, 14));
		tfCode.setHorizontalAlignment(SwingConstants.CENTER);
		tfCode.setEnabled(false);
		pCart.add(tfCode);
		tfCode.setColumns(10);
		
		lblPro = new JLabel("제품명");
		lblPro.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblPro);
		
		tfPro = new JTextField();
		tfPro.setBackground(Color.WHITE);
		tfPro.setDisabledTextColor(Color.BLACK);
		tfPro.setSelectionColor(Color.BLACK);
		tfPro.setFont(new Font("굴림", Font.BOLD, 14));
		tfPro.setHorizontalAlignment(SwingConstants.CENTER);
		tfPro.setEnabled(false);
		pCart.add(tfPro);
		tfPro.setColumns(10);
		
		lblCount = new JLabel("수 량");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblCount);
		
		tfCount = new JTextField();
		tfCount.setBackground(Color.WHITE);
		tfCount.setDisabledTextColor(Color.BLACK);
		tfCount.setSelectionColor(Color.BLACK);
		tfCount.setFont(new Font("굴림", Font.BOLD, 14));
		tfCount.setHorizontalAlignment(SwingConstants.CENTER);
		tfCount.setEnabled(false);
		pCart.add(tfCount);
		tfCount.setColumns(10);
		
		lblUp = new JLabel("제품단가");
		lblUp.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblUp);
		
		tfUp = new JTextField();
		tfUp.setBackground(Color.WHITE);
		tfUp.setDisabledTextColor(Color.BLACK);
		tfUp.setSelectionColor(Color.BLACK);
		tfUp.setFont(new Font("굴림", Font.BOLD, 14));
		tfUp.setHorizontalAlignment(SwingConstants.RIGHT);
		tfUp.setEnabled(false);
		pCart.add(tfUp);
		tfUp.setColumns(10);
		
		lblNewLabel_2 = new JLabel("금액산정");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("제품 단가 * 수량 * (1 - 할인율)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblNewLabel);
		
		lblPrice = new JLabel("받을  금액");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setBackground(Color.WHITE);
		tfPrice.setDisabledTextColor(Color.BLACK);
		tfPrice.setSelectionColor(Color.BLACK);
		tfPrice.setFont(new Font("굴림", Font.BOLD, 14));
		tfPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPrice.setEnabled(false);
		pCart.add(tfPrice);
		tfPrice.setColumns(10);

		JPanel pBtuCart = new JPanel();
		pSouth.add(pBtuCart, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtuCart.add(btnAdd);

		btnClear = new JButton("취소");
		btnClear.addActionListener(this);
		pBtuCart.add(btnClear);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
		if (e.getSource() == btnClearCart) {
			actionPerformedBtnClearCart(e);
		}
		if (e.getSource() == btnAddCart) {
			actionPerformedBtnAddCart(e);
		}
	}

	protected void actionPerformedBtnAddCart(ActionEvent e) {
		Order order = pOd.getItem();
		int no = order.getCtNo().getcNo();
		CtTable ctTable = new CtTable(new Customer(no));
		String name = cService.showCtTableNO(ctTable).getCustomer().getcName();
		String grade = cService.showCtTableNO(ctTable).getcGrade();
		Grade g = new Grade(grade);		
		int dis  = gService.showGrade(g).getDiscountRate();
		
		int up =order.getLaundryCode().getUnitPrice();
		int count = order.getLaundryCount();
		DecimalFormat df = new DecimalFormat("#,###.#");
		String unp = df.format(up);	
		String tp = df.format(up*count*(1-dis*0.01));
		tfNo.setText(no+"");		
		tfName.setText(name +"");
		tfGrade.setText(grade +"");
		tfDis.setText(dis +"%");		
		tfCode.setText(order.getLaundryCode().getlLaundryCode()+"");
		tfPro.setText(order.getLaundryCode().getProduct()+"");
		tfUp.setText(unp+"원");
		tfCount.setText(count+"");
		tfPrice.setText(tp+"원");
	}

	protected void actionPerformedBtnClearCart(ActionEvent e) {
		pOd.clearTf();
		
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Order order = pOd.getItem();
		service.addOrder(order);
		
		pOd.clearTf();
		JOptionPane.showMessageDialog(null, order + " 추가했습니다.");
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pOd.clearTf();
		tfNo.setText("");
		tfName.setText("");
		tfGrade.setText("");
		tfDis.setText("");
		tfCode.setText("");
		tfPro.setText("");
		tfUp.setText("");
		tfCount.setText("");
		tfPrice.setText("");		
	}
}
