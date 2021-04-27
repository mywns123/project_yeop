package project_yeop.ui.panel.table;

import java.util.Date;

import javax.swing.SwingConstants;

import project_yeop.dto.Laundry;
import project_yeop.dto.salebyDate;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.salebyDateService;

@SuppressWarnings("serial")
public class salebyMonthTablePanel extends AbstractTablePanel<salebyDate> {

	private salebyDateService service = new salebyDateService();

	public void setService(salebyDateService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showSaleMonth();

	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2,3);
		setTableCellWidth(100, 100,100, 150);

	}

	@Override
	public Object[] toArray(salebyDate t) {
		return new Object[] { t.getMonth(),  t.getlLaundryCode().getlLaundryCode(), t.getTotalCount(), t.getTotalPrice() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "월","세탁물 코드", "누정수량", "총 매출" };
	}

	@Override
	public salebyDate getItem() {
		int row = table.getSelectedRow();
		int month = (int) table.getValueAt(row, 0);
		Laundry lLaundryCode = (Laundry) table.getValueAt(row, 1);
		int TotalCount = (int) table.getValueAt(row, 2);
		int TotalPrice = (int) table.getValueAt(row, 3);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return new salebyDate(month,lLaundryCode, TotalCount, TotalPrice);

	}

}
