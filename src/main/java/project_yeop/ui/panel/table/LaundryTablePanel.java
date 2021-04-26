package project_yeop.ui.panel.table;

import javax.swing.SwingConstants;

import project_yeop.dto.Laundry;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.LaundryService;

@SuppressWarnings("serial")
public class LaundryTablePanel extends AbstractTablePanel<Laundry> {

	private LaundryService service = new LaundryService();

	public void setService(LaundryService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showLaundrys();
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		setTableCellWidth(100, 150, 100);
	}

	@Override
	public Object[] toArray(Laundry t) {
		return new Object[] { t.getlLaundryCode(), t.getProduct(), t.getUnitPrice() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "세탁물 코드", "제품명", "단가" };
	}

	@Override
	public Laundry getItem() {
		int row = table.getSelectedRow();
		String lLaundryCode = (String) table.getValueAt(row, 0);
		String Product = (String) table.getValueAt(row, 1);
		int UnitPrice = (int) table.getValueAt(row, 2);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return new Laundry(lLaundryCode, Product, UnitPrice);

	}

}
