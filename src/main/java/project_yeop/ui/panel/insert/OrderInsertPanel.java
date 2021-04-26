package project_yeop.ui.panel.insert;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import project_yeop.dto.Customer;
import project_yeop.dto.Laundry;
import project_yeop.dto.Order;
import project_yeop.exception.InvalidationException;
import project_yeop.service.LaundryService;

@SuppressWarnings("serial")
public class OrderInsertPanel extends AbstractInsertPanel<Order> {
	private LaundryService service;
	
	private JTextField tfNum;
	private JTextField tfCount;
	private JTextField tfColor;
	private JTextField tfEtc;
	private JComboBox<Laundry> comCode;
	
	
	public OrderInsertPanel() {
		initialize();
	}
	
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 10, 20, 10));
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 20, 10));
		
		JLabel lblNum = new JLabel("고객번호");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNum);
		
		tfNum = new JTextField();
		tfNum.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(tfNum);
		tfNum.setColumns(10);
		
		JLabel lblCode = new JLabel("세탁물코드");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCode);
		
		comCode = new JComboBox<Laundry>();
		panel.add(comCode);
		
		JLabel lblCount = new JLabel("수    량");
		lblCount.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCount);
		
		tfCount = new JTextField();
		tfCount.setHorizontalAlignment(SwingConstants.LEFT);
		tfCount.setColumns(10);
		panel.add(tfCount);
		
		JLabel lblColor = new JLabel("색    상");
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblColor);
		
		tfColor = new JTextField();
		tfColor.setHorizontalAlignment(SwingConstants.LEFT);
		tfColor.setColumns(10);
		panel.add(tfColor);
		
		JLabel lblEtc = new JLabel("기타사항");
		lblEtc.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEtc);
		
		tfEtc = new JTextField();
		tfEtc.setHorizontalAlignment(SwingConstants.LEFT);
		tfEtc.setColumns(10);
		panel.add(tfEtc);
	}
	
	public LaundryService getService() {
		return service;
	}
	
	public void setService(LaundryService service) {
		this.service = service;
		
		List<Laundry> list = service.showLaundrys();
		DefaultComboBoxModel<Laundry> model = new DefaultComboBoxModel<>(new Vector<>(list));
		comCode.setModel(model);
		
		comCode.setSelectedIndex(-1);
	}
	
	@Override
	public void setItem(Order item) {
		tfNum.setText(String.valueOf(item.getCtNo()));
		comCode.setSelectedItem(item.getLaundryCode());
		tfCount.setText(String.valueOf(item.getLaundryCount()));	
		tfColor.setText(String.valueOf(item.getColor()));
		tfEtc.setText(String.valueOf(item.getEtc()));	
	}
	
	@Override
	public Order getItem() {
		validCheck();
		Customer ctNo = new Customer(Integer.parseInt(tfNum.getText().trim()));
		Laundry LaundryCode = (Laundry)comCode.getSelectedItem();		
		int laundryCount = Integer.parseInt(tfCount.getText().trim());
		String color = tfColor.getText().trim();
		String ect = tfEtc.getText().trim();		

		return new Order(ctNo, LaundryCode,color,laundryCount,ect);
	}
	@Override
	public void validCheck() {
		if (tfNum.getText().contentEquals("") || tfCount.getText().equals("")
				|| tfColor.getText().equals("")|| tfEtc.getText().equals("")
				|| comCode.getSelectedIndex() == -1) {
			throw new InvalidationException();
		}			
	}
	
	@Override
	public void clearTf() {
		tfNum.setText("");
		comCode.setSelectedIndex(-1);
		tfCount.setText("");
		tfColor.setText("");
		tfEtc.setText("");		
	}		
	
}
