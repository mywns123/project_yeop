package project_yeop.ui.panel.table;

import java.text.DecimalFormat;
import java.text.ParseException;

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
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellAlign(SwingConstants.RIGHT, 2);
		setTableCellWidth(100, 150, 100);
	}

	@Override
	public Object[] toArray(Laundry t) {
		DecimalFormat df = new DecimalFormat("#,###.#");
		String ret = df.format(t.getUnitPrice());		
		return new Object[] { t.getlLaundryCode(), t.getProduct(), ret + "원" };
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
		
		String UnitPrice = (String) table.getValueAt(row, 2);
		String t = UnitPrice.replace("원", "");
		DecimalFormat df2 = new DecimalFormat("0,000");
		int i = 0;
		try {
			i = df2.parse(t).intValue();
		} catch (ParseException e) {			
			e.printStackTrace();
		}		
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		return new Laundry(lLaundryCode, Product, i);

	}

}
