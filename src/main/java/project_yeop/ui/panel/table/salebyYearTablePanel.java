package project_yeop.ui.panel.table;

import java.text.DecimalFormat;

import javax.swing.SwingConstants;

import project_yeop.dto.salebyDate;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.salebyDateService;

@SuppressWarnings("serial")
public class salebyYearTablePanel extends AbstractTablePanel<salebyDate> {

	private salebyDateService service = new salebyDateService();

	public void setService(salebyDateService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showSaleYear();

	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellAlign(SwingConstants.RIGHT, 2);
		setTableCellWidth(100, 100, 150);

	}

	@Override
	public Object[] toArray(salebyDate t) {
		DecimalFormat df = new DecimalFormat("#,###.#");
		String ret = df.format(t.getTotalPrice());	
		return new Object[] { t.getMonth(), t.getTotalCount(), ret + "원" };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "월", "누적수량", "누적 매출" };
	}

	@Override
	public salebyDate getItem() {
		int row = table.getSelectedRow();
		int month = (int) table.getValueAt(row, 0);
		int TotalCount = (int) table.getValueAt(row, 1);
		int TotalPrice = (int) table.getValueAt(row, 2);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return new salebyDate(month, TotalCount, TotalPrice);

	}

}
