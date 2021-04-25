package project_yeop.ui.table;

import javax.swing.SwingConstants;

import project_yeop.dto.Customer;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerTablePanel extends AbstractTablePanel<Customer> {

	private CustomerService service = new CustomerService();

	public void setService(CustomerService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showCustomers();
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);
		setTableCellWidth(100, 100, 100, 100, 100, 100);
	}

	@Override
	public Object[] toArray(Customer t) {
		return new Object[] { t.getcNo(), t.getcName(), t.isGender(),
				t.getPonNumber(), t.getAddress(), t.getJoinDate()};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "고객번호", "고객명", "성별", "전화번호", "주소", "가입일"};
	}

	@Override
	public Customer getItem() {
		int row = table.getSelectedRow();	
		String gGrade = (String) table.getValueAt(row, 1);
		boolean gender = (boolean) table.getValueAt(row, 2);		
		String ponNumber = (String) table.getValueAt(row, 3);
		String address = (String) table.getValueAt(row, 4);

		if(row == -1) {
			throw new NotSelectedException();
		}
		
		return new Customer(gGrade,gender,ponNumber,address);		
	}
	
}
