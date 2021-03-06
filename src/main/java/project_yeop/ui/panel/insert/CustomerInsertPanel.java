package project_yeop.ui.panel.insert;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import project_yeop.dto.Customer;
import project_yeop.exception.InvalidationException;

@SuppressWarnings("serial")
public class CustomerInsertPanel extends AbstractInsertPanel<Customer> {
	public JTextField tfNo;
	private JTextField tfName;
	private JTextField tfPhon;
	private JTextField tfAddress;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	
	public CustomerInsertPanel() {
		initialize();		
	}
	
	private void initialize() {
		setBorder(new EmptyBorder(10, 20, 10, 20));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 10, 20, 10));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel lblNo = new JLabel("고객번호");
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setHorizontalAlignment(SwingConstants.CENTER);
		tfNo.setEditable(false);
		panel.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("고 객 명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblName);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblGender = new JLabel("성    별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGender);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		rdbtnMale = new JRadioButton("남");		
		buttonGroup.add(rdbtnMale);
		panel_1.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("여");		
		buttonGroup.add(rdbtnFemale);
		panel_1.add(rdbtnFemale);
		
		JLabel lblPhon = new JLabel("연 락 처");
		lblPhon.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPhon);
		
		tfPhon = new JTextField();
		tfPhon.setColumns(10);
		panel.add(tfPhon);
		
		JLabel lblAddress = new JLabel("주    소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddress);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		panel.add(tfAddress);
				
	}
	@Override
	public void setItem(Customer item) {	
		tfNo.setText(String.valueOf(item.getcNo()));
		tfName.setText(String.valueOf(item.getcName()));
		tfPhon.setText(String.valueOf(item.getPonNumber()));
		tfAddress.setText(String.valueOf(item.getAddress()));		
		if (item.isGender()) {
			rdbtnFemale.setSelected(true);
		} else {
			rdbtnMale.setSelected(true);
		}		
	}
	
	@Override
	public Customer getItem() {
		validCheck();
		/* int cNO = Integer.parseInt(tfNo.getText().trim()); */
		String cName = tfName.getText().trim();
		boolean gender = rdbtnFemale.isSelected() ? true : false;	
		String ponNumber = tfPhon.getText().trim();
		String address = tfAddress.getText().trim();		

		return new Customer(/* cNO, */cName,gender, ponNumber,address);
	}
	
	@Override
	public void validCheck() {
		if (tfName.getText().contentEquals("") || tfPhon.getText().equals("")
				|| tfAddress.getText().equals("")) {
			throw new InvalidationException();
		}		
	}
	
	@Override
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		rdbtnFemale.setSelected(true);
		tfPhon.setText("");
		tfAddress.setText("");				
	}

}
