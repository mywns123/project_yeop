package project_yeop.ui.panel.table;

import javax.swing.SwingConstants;

import project_yeop.dto.CtTable;
import project_yeop.dto.Customer;
import project_yeop.dto.salebyCt;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.salebyCtService;

@SuppressWarnings("serial")
public class salebyCtTablePanel extends AbstractTablePanel<salebyCt> {

	private salebyCtService service = new salebyCtService();

	public void setService(salebyCtService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showSales();

	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2,3);
		setTableCellWidth(100, 100,100, 150);

	}

	@Override
	public Object[] toArray(salebyCt t) {
		return new Object[] { t.getCtTable().getCustomer().getcNo(), t.getCtTable().getCustomer().getcName(), t.getTotalCount(), t.getTotalPrice() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "고객 번호","고객명", "누정수량", "총 매출" };
	}

	@Override
	public salebyCt getItem() {
		int row = table.getSelectedRow();
		CtTable ctTable = new CtTable( new Customer((int) table.getValueAt(row, 0)));		
		int TotalCount = (int) table.getValueAt(row, 2);
		int TotalPrice = (int) table.getValueAt(row, 3);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return new salebyCt(ctTable, TotalCount, TotalPrice);

	}

}
