package project_yeop.ui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class OrderUI extends JPanel {

	
	public OrderUI() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		JPanel pNoth = new JPanel();
		add(pNoth);
		pNoth.setLayout(new BorderLayout(0, 0));
		
		JPanel pOd = new JPanel();
		pNoth.add(pOd);
		
		JPanel pBtu = new JPanel();
		pNoth.add(pBtu, BorderLayout.SOUTH);
		
		JButton btnAddCart = new JButton("담기");
		pBtu.add(btnAddCart);
		
		JButton btnClearCart = new JButton("취소");		
		pBtu.add(btnClearCart);
		
		JPanel pSouth = new JPanel();
		add(pSouth);
		pSouth.setLayout(new BorderLayout(0, 0));
		
		JPanel pCart = new JPanel();
		pSouth.add(pCart, BorderLayout.CENTER);
		
		JPanel pBtuCart = new JPanel();
		pSouth.add(pBtuCart, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("추가");
		pBtuCart.add(btnAdd);
		
		JButton btnback = new JButton("선택 취소");
		pBtuCart.add(btnback);
		
		JButton btnClear = new JButton("전체 취소");
		pBtuCart.add(btnClear);
		
	}

}
