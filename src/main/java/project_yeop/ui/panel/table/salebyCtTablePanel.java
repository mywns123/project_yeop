package project_yeop.ui.panel.table;

import java.text.DecimalFormat;
import java.text.ParseException;

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
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		setTableCellAlign(SwingConstants.RIGHT, 3);

		setTableCellWidth(100, 100,100, 150);

	}

	@Override
	public Object[] toArray(salebyCt t) {
		DecimalFormat df = new DecimalFormat("#,###.#");
		String ret = df.format(t.getTotalPrice());	
		return new Object[] { t.getCtTable().getCustomer().getcNo(), t.getCtTable().getCustomer().getcName(), t.getTotalCount(), ret + "원" };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "회원번호","회원명", "누정수량", "누적 매출" };
	}

	@Override
	public salebyCt getItem() {
		int row = table.getSelectedRow();
		CtTable ctTable = new CtTable( new Customer((int) table.getValueAt(row, 0)));		
		int TotalCount = (int) table.getValueAt(row, 2);
		String TotalPrice = (String) table.getValueAt(row, 3);
		String t = TotalPrice.replace("원", "");
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
		return new salebyCt(ctTable, TotalCount, i);

	}

}
