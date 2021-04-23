package project_yeop.ui.insert;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import project_yeop.dto.Laundry;
import project_yeop.exception.InvalidationException;

@SuppressWarnings("serial")
public class LaundryPanel extends AbstractPanel<Laundry> {
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
	}
	
	@Override
	public void setItem(Laundry item) {
		tfLaundry.setText(String.valueOf(item.getlLaundryCode()));
		tflPro.setText(String.valueOf(item.getProduct()));
		tfUP.setText(String.valueOf(item.getUnitPrice()));
	}
	
	@Override
	public Laundry getItem() {
		validCheck();
		String lLaundryCode = tfLaundry.getText().trim();
		String product = tflPro.getText().trim();
		int unitPrice = Integer.parseInt(tfUP.getText().trim());

		return new Laundry(lLaundryCode, product,unitPrice);
	}
	
	@Override
	public void validCheck() {
		if (tfLaundry.getText().contentEquals("") || tflPro.getText().equals("")
				|| tfUP.getText().equals("")) {
			throw new InvalidationException();
		}		
	}
	
	@Override
	public void clearTf() {
		tfLaundry.setText("");
		tflPro.setText("");
		tfUP.setText("");
		
		if (!tfLaundry.isEditable()) {
			tfLaundry.setEditable(true);
		}
	}

}
