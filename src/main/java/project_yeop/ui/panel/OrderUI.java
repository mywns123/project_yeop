package project_yeop.ui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project_yeop.dto.Order;
import project_yeop.service.LaundryService;
import project_yeop.service.OrderService;
import project_yeop.ui.panel.insert.OrderInsertPanel;

@SuppressWarnings("serial")
public class OrderUI extends JPanel implements ActionListener {
	private JButton btnAddCart;
	private JButton btnClearCart;
	private JButton btnAdd;
	private JButton btnback;
	private JButton btnClear;
	private OrderService service;
	private JPanel pOd;
	private LaundryService lservice;

	public OrderUI() {
		service = new OrderService();
		lservice = new LaundryService();
		initialize();
	}

	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pNoth = new JPanel();
		add(pNoth);
		pNoth.setLayout(new BorderLayout(0, 0));

		pOd = new OrderInsertPanel();
		((OrderInsertPanel) pOd).setService(lservice);
		pNoth.add(pOd);

		JPanel pBtu = new JPanel();
		pNoth.add(pBtu, BorderLayout.SOUTH);

		btnAddCart = new JButton("담기");
		btnAddCart.addActionListener(this);
		pBtu.add(btnAddCart);

		btnClearCart = new JButton("취소");
		btnClearCart.addActionListener(this);
		pBtu.add(btnClearCart);

		JPanel pSouth = new JPanel();
		add(pSouth);
		pSouth.setLayout(new BorderLayout(0, 0));

		JPanel pCart = new JPanel();
		pSouth.add(pCart, BorderLayout.CENTER);

		JPanel pBtuCart = new JPanel();
		pSouth.add(pBtuCart, BorderLayout.SOUTH);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtuCart.add(btnAdd);

		btnback = new JButton("선택 삭제");
		btnback.addActionListener(this);
		pBtuCart.add(btnback);

		btnClear = new JButton("전체 취소");
		btnClear.addActionListener(this);
		pBtuCart.add(btnClear);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnback) {
			actionPerformedBtnback(e);
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
		Order order = ((OrderInsertPanel) pOd).getItem();
		service.addOrder(order);
		
		((OrderInsertPanel) pOd).clearTf();
		JOptionPane.showMessageDialog(null, order + " 추가했습니다.");
	}

	protected void actionPerformedBtnClearCart(ActionEvent e) {
		((OrderInsertPanel) pOd).clearTf();
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
	}

	protected void actionPerformedBtnback(ActionEvent e) {
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		
	}
}
