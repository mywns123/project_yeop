package project_yeop.ui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import project_yeop.dto.Customer;
import project_yeop.service.CustomerService;
import project_yeop.ui.insert.AbstractPanel;
import project_yeop.ui.insert.CustomerPanel;
import project_yeop.ui.table.AbstractTablePanel;
import project_yeop.ui.table.CustomerTablePanel;

@SuppressWarnings("serial")
public class CustomerUI extends AbstractUI<Customer> {

	private CustomerService service;
	
	@Override
	protected void setService() {
		service = new CustomerService();
		
	}

	@Override
	protected void tableLoadData() {
		((CustomerTablePanel) pTable).setService(service);
		pTable.loadData();
		
	}

	@Override
	protected AbstractPanel<Customer> creatPanel() {
		return new CustomerPanel();

	}


	protected AbstractTablePanel<Customer> creatTablePanel() {
		return new CustomerTablePanel();
	}

	@Override
	protected void actionPerformdMenuUpdate() {
		Customer customer = pTable.getItem();
		pPanel.setItem(customer);
		btnAdd.setText("수정");
	}

	@Override
	protected void actionPerformdMenuDelete() {
		Customer customer = pTable.getItem();
		service.removeCustomer(customer);
		pTable.loadData();
		JOptionPane.showMessageDialog(null, customer + "삭제 되었습니다.");
		
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Customer customer = pPanel.getItem();
		service.modifyCustomer(customer);
		pTable.loadData();
		pPanel.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, customer + "정보가 수정되었습니다.");
		
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Customer customer = pPanel.getItem();
		service.addCustomer(customer);
		pTable.loadData();
		pPanel.clearTf();
		JOptionPane.showMessageDialog(null, customer + " 추가했습니다.");
		
	}

	protected void actionPerformedBtnClear(ActionEvent e) {
		pPanel.clearTf();

		if (btnAdd.getText().contentEquals("수정")) {
			btnAdd.setText("추가");
		}
	}
	

}
