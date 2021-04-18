package project_yeop.panel;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GradePanel extends JPanel {
	private JTextField tfGrade;
	private JTextField tfDC;

	public GradePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 10, 20, 10));
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel lblGrade = new JLabel("등    급");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGrade);
		
		tfGrade = new JTextField();
		panel.add(tfGrade);
		tfGrade.setColumns(10);
		
		JLabel lblDC = new JLabel("할 인 율");
		lblDC.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDC);
		
		tfDC = new JTextField();
		panel.add(tfDC);
		tfDC.setColumns(10);
		
		JPanel pBu = new JPanel();
		add(pBu, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("추가");
		pBu.add(btnAdd);
		
		JButton btnClear = new JButton("취소");
		pBu.add(btnClear);
	}

}
