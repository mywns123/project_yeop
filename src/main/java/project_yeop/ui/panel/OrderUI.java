package project_yeop.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import project_yeop.control.Management;
import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;
import project_yeop.dto.Grade;
import project_yeop.dto.Order;
import project_yeop.exception.InvalidationException;
import project_yeop.exception.NotSelectedException;
import project_yeop.exception.NullException;
import project_yeop.exception.SqlConstraintException;
import project_yeop.service.CustomerService;
import project_yeop.service.GradeService;
import project_yeop.service.LaundryService;
import project_yeop.service.OrderService;
import project_yeop.ui.frame.CustomerFrameUI;
import project_yeop.ui.panel.insert.OrderInsertPanel;

@SuppressWarnings("serial")
public class OrderUI extends JPanel implements ActionListener {
	private JButton btnAddCart;
	private JButton btnClearCart;
	private JButton btnAdd;
	private JButton btnClear;
	private OrderService service;
	public OrderInsertPanel pOd;
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
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnCt;
	private JLabel lblNewLabel_1;
	private JTextField tfRecive;
	private JLabel lblNewLabel_3;
	private JTextField tfRel;

	private Management mgn;
	
	public OrderUI(Management mgn) {
		this.mgn = mgn;
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
		int no = service.showOdTables().size()+1;		
		pOd.tfNo.setText(no + "");
		pOd.setService(lservice);
		pNoth.add(pOd);

		JPanel pBtu = new JPanel();
		pNoth.add(pBtu, BorderLayout.SOUTH);
		pBtu.setLayout(new GridLayout(0, 3, 0, 0));

		panel = new JPanel();
		pBtu.add(panel);

		panel_1 = new JPanel();
		pBtu.add(panel_1);

		btnAddCart = new JButton("선택");
		panel_1.add(btnAddCart);

		btnClearCart = new JButton("다시입력");
		panel_1.add(btnClearCart);
		btnClearCart.addActionListener(this);
		btnAddCart.addActionListener(this);

		panel_2 = new JPanel();
		pBtu.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		panel_3 = new JPanel();
		panel_2.add(panel_3);

		btnCt = new JButton("회원가입");
		btnCt.addActionListener(this);
		panel_2.add(btnCt);

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
		tfNo.setEditable(false);
		tfNo.setBackground(new Color(240, 255, 240));
		tfNo.setDisabledTextColor(Color.BLACK);
		tfNo.setSelectionColor(Color.BLACK);
		tfNo.setFont(new Font("굴림", Font.BOLD, 14));
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(tfNo);
		tfNo.setColumns(10);

		lblcName = new JLabel("회 원 명");
		lblcName.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblcName);

		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setBackground(new Color(240, 255, 240));
		tfName.setDisabledTextColor(Color.BLACK);
		tfName.setSelectionColor(Color.BLACK);
		tfName.setFont(new Font("굴림", Font.BOLD, 14));
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setColumns(10);
		pCart.add(tfName);

		lblgrade = new JLabel("회원등급");
		lblgrade.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblgrade);

		tfGrade = new JTextField();
		tfGrade.setEditable(false);
		tfGrade.setBackground(new Color(240, 255, 240));
		tfGrade.setDisabledTextColor(Color.BLACK);
		tfGrade.setSelectionColor(Color.BLACK);
		tfGrade.setFont(new Font("굴림", Font.BOLD, 14));
		tfGrade.setHorizontalAlignment(SwingConstants.CENTER);
		tfGrade.setColumns(10);
		pCart.add(tfGrade);

		lblDis = new JLabel("할 인 율");
		lblDis.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblDis);

		tfDis = new JTextField();
		tfDis.setEditable(false);
		tfDis.setBackground(new Color(240, 255, 240));
		tfDis.setDisabledTextColor(Color.BLACK);
		tfDis.setSelectionColor(Color.BLACK);
		tfDis.setFont(new Font("굴림", Font.BOLD, 14));
		tfDis.setHorizontalAlignment(SwingConstants.CENTER);
		tfDis.setColumns(10);
		pCart.add(tfDis);

		lblCode = new JLabel("세탁코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblCode);

		tfCode = new JTextField();
		tfCode.setEditable(false);
		tfCode.setBackground(new Color(240, 255, 240));
		tfCode.setDisabledTextColor(Color.BLACK);
		tfCode.setSelectionColor(Color.BLACK);
		tfCode.setFont(new Font("굴림", Font.BOLD, 14));
		tfCode.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(tfCode);
		tfCode.setColumns(10);

		lblPro = new JLabel("제 품 명");
		lblPro.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblPro);

		tfPro = new JTextField();
		tfPro.setEditable(false);
		tfPro.setBackground(new Color(240, 255, 240));
		tfPro.setDisabledTextColor(Color.BLACK);
		tfPro.setSelectionColor(Color.BLACK);
		tfPro.setFont(new Font("굴림", Font.BOLD, 14));
		tfPro.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(tfPro);
		tfPro.setColumns(10);

		lblCount = new JLabel("수   량");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblCount);

		tfCount = new JTextField();
		tfCount.setEditable(false);
		tfCount.setBackground(new Color(240, 255, 240));
		tfCount.setDisabledTextColor(Color.BLACK);
		tfCount.setSelectionColor(Color.BLACK);
		tfCount.setFont(new Font("굴림", Font.BOLD, 14));
		tfCount.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(tfCount);
		tfCount.setColumns(10);

		lblUp = new JLabel("제품단가");
		lblUp.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblUp);

		tfUp = new JTextField();
		tfUp.setEditable(false);
		tfUp.setBackground(new Color(240, 255, 240));
		tfUp.setDisabledTextColor(Color.BLACK);
		tfUp.setSelectionColor(Color.BLACK);
		tfUp.setFont(new Font("굴림", Font.BOLD, 14));
		tfUp.setHorizontalAlignment(SwingConstants.RIGHT);
		pCart.add(tfUp);
		tfUp.setColumns(10);

		lblNewLabel_2 = new JLabel("금액산정");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblNewLabel_2);

		lblNewLabel = new JLabel("제품 단가 * 수량 * (1 - 할인율)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblNewLabel);

		lblPrice = new JLabel("받을 금액");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblPrice);

		tfPrice = new JTextField();
		tfPrice.setEditable(false);
		tfPrice.setBackground(new Color(240, 255, 240));
		tfPrice.setDisabledTextColor(Color.BLACK);
		tfPrice.setSelectionColor(Color.BLACK);
		tfPrice.setFont(new Font("굴림", Font.BOLD, 14));
		tfPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		pCart.add(tfPrice);
		tfPrice.setColumns(10);

		lblNewLabel_1 = new JLabel("입 고 일");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblNewLabel_1);

		tfRecive = new JTextField();
		tfRecive.setBackground(new Color(240, 255, 240));
		tfRecive.setForeground(Color.BLACK);
		tfRecive.setSelectionColor(Color.WHITE);
		tfRecive.setFont(new Font("굴림", Font.BOLD, 14));
		tfRecive.setHorizontalAlignment(SwingConstants.CENTER);
		tfRecive.setEditable(false);
		pCart.add(tfRecive);
		tfRecive.setColumns(10);

		lblNewLabel_3 = new JLabel("출고예정일");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		pCart.add(lblNewLabel_3);

		tfRel = new JTextField();
		tfRel.setBackground(new Color(240, 255, 240));
		tfRel.setForeground(Color.BLACK);
		tfRel.setSelectionColor(Color.WHITE);
		tfRel.setFont(new Font("굴림", Font.BOLD, 14));
		tfRel.setHorizontalAlignment(SwingConstants.CENTER);
		tfRel.setEditable(false);
		pCart.add(tfRel);
		tfRel.setColumns(10);

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
		try {

			if (e.getSource() == btnCt) {
				actionPerformedBtnCt(e);
			}
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
		} catch (InvalidationException | SqlConstraintException | NullException | NotSelectedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	protected void actionPerformedBtnAddCart(ActionEvent e) {

		Order order = pOd.getItem();
		int no = order.getCtNo().getcNo();
		CtTable ctTable = new CtTable(new Customer(no));
		String name = cService.showCtTableNO(ctTable).getCustomer().getcName();
		String grade = cService.showCtTableNO(ctTable).getcGrade().getgGrade();
		Grade g = new Grade(grade);
		int dis = gService.showGrade(g).getDiscountRate();
		Date recive = new Date();
		Date rel = new Date(recive.getTime() + (7 * 1000 * 60 * 60 * 24));
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

		int up = order.getLaundryCode().getUnitPrice();
		int count = order.getLaundryCount();
		DecimalFormat df = new DecimalFormat("#,###.#");
		String unp = df.format(up);
		String tp = df.format(up * count * (1 - dis * 0.01));
		tfNo.setText(no + "");
		tfName.setText(name + "");
		tfGrade.setText(grade + "");
		tfDis.setText(dis + "%");
		tfCode.setText(order.getLaundryCode().getlLaundryCode() + "");
		tfPro.setText(order.getLaundryCode().getProduct() + "");
		tfUp.setText(unp + "원");
		tfCount.setText(count + "");
		tfPrice.setText(tp + "원");
		tfRecive.setText(date.format(recive));
		tfRel.setText(date.format(rel));
	}

	protected void actionPerformedBtnClearCart(ActionEvent e) {
		pOd.clearTf();
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Order order = pOd.getItem();
		service.addOrder(order);

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
		tfRecive.setText("");
		tfRel.setText("");
		JOptionPane.showMessageDialog(null, order.getNo() + " 추가했습니다.");
		
		mgn.reloadTableData();
		
		int no = service.showOdTables().size()+1;		
		pOd.tfNo.setText(no + "");
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
		tfRecive.setText("");
		tfRel.setText("");
	}

	protected void actionPerformedBtnCt(ActionEvent e) {
		CustomerFrameUI frame = new CustomerFrameUI(mgn);
		frame.setVisible(true);
	}
}
