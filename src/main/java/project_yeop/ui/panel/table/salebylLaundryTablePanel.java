package project_yeop.ui.panel.table;

import java.text.DecimalFormat;

import javax.swing.SwingConstants;

import project_yeop.dto.Laundry;
import project_yeop.dto.salebylLaundry;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.salebylLaundryService;

@SuppressWarnings("serial")
public class salebylLaundryTablePanel extends AbstractTablePanel<salebylLaundry> {

	private salebylLaundryService service = new salebylLaundryService();

	public void setService(salebylLaundryService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showSales();

	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellAlign(SwingConstants.RIGHT, 2);
		setTableCellWidth(100, 100, 150);

	}

	@Override
	public Object[] toArray(salebylLaundry t) {
		DecimalFormat df = new DecimalFormat("#,###.#");
		String ret = df.format(t.getTotalPrice());	
		return new Object[] { t.getlLaundryCode().getlLaundryCode(), t.getTotalCount(),  ret + "원"   };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "세탁물 코드", "누적수량", "누적 매출" };
	}

	@Override
	public salebylLaundry getItem() {
		int row = table.getSelectedRow();
		Laundry lLaundryCode = (Laundry) table.getValueAt(row, 0);
		int TotalCount = (int) table.getValueAt(row, 1);
		int TotalPrice = (int) table.getValueAt(row, 2);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return new salebylLaundry(lLaundryCode, TotalCount, TotalPrice);

	}

}
