package project_yeop.ui.panel.table;

import java.util.List;

import javax.swing.SwingConstants;

import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerTablePanel extends AbstractTablePanel<CtTable> {

	private CustomerService service = new CustomerService();

	public void setService(CustomerService service) {
		this.service = service;
	}

	public void setSearchList(List<CtTable> ctList) {
		list = ctList;
	}
	
	@Override
	public void initList() {
		list = service.showCtTable();
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8);
		setTableCellWidth(100, 100, 150, 150, 150, 150, 100, 100, 100);
	}

	@Override
	public Object[] toArray(CtTable t) {
		String gender = t.getCustomer().isGender() == true ? "여성" : "남성";
		return new Object[] { t.getCustomer().getcNo(), t.getCustomer().getcName(), gender,
				t.getCustomer().getPonNumber(), t.getCustomer().getAddress(), t.getCustomer().getJoinDate(),
				t.getUnReleased(), t.getCount(), t.getcGrade() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "회원번호", "회원명", "성별", "전화번호", "주소", "가입일", "미출고주문", "누적이용도", "등급" };
	}

	@Override
	public CtTable getItem() {
		int row = table.getSelectedRow();
		int cNo = (int) table.getValueAt(row, 0);
		String name = (String) table.getValueAt(row, 1);
		boolean gender = (boolean) table.getValueAt(row, 2).equals("남성") ? false : true;
		String ponNumber = (String) table.getValueAt(row, 3);
		String address = (String) table.getValueAt(row, 4);		
		if (row == -1) {
			throw new NotSelectedException();
		}

		return new CtTable(new Customer(cNo, name,  gender, ponNumber, address));
	}

}
