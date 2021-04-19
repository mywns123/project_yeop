package project_yeop.panel;

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
public class GradePanel extends AbstractPanel<Grade> {
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
	}

	@Override
	public void setItem(Grade item) {
		tfGrade.setText(String.valueOf(item.getgGrade()));
		tfDC.setText(String.valueOf(item.getDiscountRate()));
	}

	@Override
	public Grade getItem() {
		validCheck();
		String gGrade = tfGrade.getText().trim();
		int discountRate = Integer.parseInt(tfDC.getText().trim());

		return new Grade(gGrade, discountRate);
	}

	@Override
	public void validCheck() {
		if (tfGrade.getText().contentEquals("") || tfDC.getText().equals("")) {
			throw new InvalidationException();
		}
	}

	@Override
	public void clearTf() {
		tfGrade.setText("");
		tfDC.setText("");

		if (!tfGrade.isEditable()) {
			tfGrade.setEditable(true);
		}

	}

}
