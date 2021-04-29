package project_yeop.ui.panel.insert;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import project_yeop.dto.Grade;
import project_yeop.exception.InvalidationException;

@SuppressWarnings("serial")
public class GradeInsertPanel extends AbstractInsertPanel<Grade> {
	private JTextField tfGrade;
	private JTextField tfDC;
	private JTextField tfLosal;
	private JTextField tfHiosal;

	public GradeInsertPanel() {
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
		tfGrade.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfGrade);
		tfGrade.setColumns(10);
		
		JLabel lblLosal = new JLabel("최저값");
		lblLosal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLosal);
		
		tfLosal = new JTextField();
		tfLosal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfLosal);
		tfLosal.setColumns(10);
		
		JLabel lblHiosal = new JLabel("최고값");
		lblHiosal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblHiosal);
		
		tfHiosal = new JTextField();
		tfHiosal.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfHiosal);
		tfHiosal.setColumns(10);

		JLabel lblDC = new JLabel("할 인 율");
		lblDC.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDC);

		tfDC = new JTextField();
		tfDC.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(tfDC);
		tfDC.setColumns(10);
	}

	@Override
	public void setItem(Grade item) {
		tfGrade.setText(String.valueOf(item.getgGrade()));
		tfLosal.setText(String.valueOf(item.getLosal()));
		tfHiosal.setText(String.valueOf(item.getHiosal()));
		tfDC.setText(String.valueOf(item.getDiscountRate()));
	}

	@Override
	public Grade getItem() {
		validCheck();
		String gGrade = tfGrade.getText().trim();		
		int losal = Integer.parseInt(tfLosal.getText().trim());
		int hiosal = Integer.parseInt(tfHiosal.getText().trim());
		int discountRate = Integer.parseInt(tfDC.getText().trim());
		return new Grade(gGrade,losal, hiosal,discountRate);
	}

	@Override
	public void validCheck() {
		if (tfGrade.getText().contentEquals("") || tfDC.getText().equals("")
				|| tfLosal.getText().contentEquals("") || tfHiosal.getText().equals("")) {
			throw new InvalidationException();
		}
	}

	@Override
	public void clearTf() {
		tfGrade.setText("");
		tfDC.setText("");
		tfLosal.setText("");
		tfHiosal.setText("");
		if (!tfGrade.isEditable()) {
			tfGrade.setEditable(true);
		}

	}

}
