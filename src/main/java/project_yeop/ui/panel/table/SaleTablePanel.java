package project_yeop.ui.panel.table;

import javax.swing.SwingConstants;

import project_yeop.dto.Laundry;
import project_yeop.dto.Sale;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.SalesService;

@SuppressWarnings("serial")
public class SaleTablePanel extends AbstractTablePanel<Sale> {

	private SalesService service = new SalesService();

	public void setService(SalesService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showSales();

	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		setTableCellWidth(100, 100, 150);

	}

	@Override
	public Object[] toArray(Sale t) {
		return new Object[] { t.getlLaundryCode().getlLaundryCode(), t.getTotalCount(), t.getTotalPrice() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "세탁물 코드", "누정수량", "총 매출" };
	}

	@Override
	public Sale getItem() {
		int row = table.getSelectedRow();
		Laundry lLaundryCode = (Laundry) table.getValueAt(row, 0);
		int TotalCount = (int) table.getValueAt(row, 1);
		int TotalPrice = (int) table.getValueAt(row, 2);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return new Sale(lLaundryCode, TotalCount, TotalPrice);

	}

}
