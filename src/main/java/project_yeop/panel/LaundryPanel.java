package project_yeop.panel;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LaundryPanel extends JPanel {
	private JTextField tfLaundry;
	private JTextField tflPro;
	private JTextField tfUP;

	public LaundryPanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 10, 20, 10));
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel lblLaundry = new JLabel("세탁물 코드");
		lblLaundry.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLaundry);
		
		tfLaundry = new JTextField();
		panel.add(tfLaundry);
		tfLaundry.setColumns(10);
		
		JLabel lblPro = new JLabel("제 품 명");
		lblPro.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPro);
		
		tflPro = new JTextField();
		tflPro.setColumns(10);
		panel.add(tflPro);
		
		JLabel lblUP = new JLabel("단    가");
		lblUP.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblUP);
		
		tfUP = new JTextField();
		tfUP.setColumns(10);
		panel.add(tfUP);
		
		JPanel pBU = new JPanel();
		add(pBU, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("추가");
		pBU.add(btnAdd);
		
		JButton btnClear = new JButton("취소");
		pBU.add(btnClear);
	}

}
