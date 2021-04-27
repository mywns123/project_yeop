package project_yeop.ui.panel.table;

import java.util.Date;

import javax.swing.SwingConstants;

import project_yeop.dto.Customer;
import project_yeop.dto.Laundry;
import project_yeop.dto.OdTable;
import project_yeop.dto.Order;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.OrderService;

@SuppressWarnings("serial")
public class OrderRelTablePanel extends AbstractTablePanel<OdTable>{

	private OrderService service = new OrderService();

	public void setService(OrderService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showOdTablereleaseDate();
		
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14);
		setTableCellWidth(100, 100, 100, 100, 100, 100,100, 100, 100, 100, 100, 100, 150, 150, 200);
		
	}

	@Override
	public Object[] toArray(OdTable t) {
		String complete =  t.getOrder().isComplete() == true? "출고": "미출고";
		return new Object[] {   complete,
								t.getOrder().getNo(),
							    t.getCtTable().getCustomer().getcNo(),
							    t.getCtTable().getCustomer().getcName(),
							    t.getGrade().getgGrade(),
							    t.getGrade().getDiscountRate(),
							    t.getOrder().getColor(),
							    t.getLaundry().getlLaundryCode(),
							    t.getLaundry().getProduct(),
							    t.getLaundry().getUnitPrice(),
							    t.getOrder().getLaundryCount(),
							    t.getPrice(),
							    t.getOrder().getReceiveDate(),
							    t.getReleaseDate(),
							    t.getOrder().getEtc()		
		};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {  "완료", "접수번호","고객번호", "고객명", "회원등급","할인율", "색상", "세탁물코드", "제품명", "단가","수량", "총가격 ", "입고일", "출고일","기타사항" };

	}

	@Override
	public OdTable getItem() {
		int row = table.getSelectedRow();
		boolean complete = (boolean) table.getValueAt(row, 0);
		int no = (int) table.getValueAt(row, 1);
		Customer ctNo = new Customer ((int) table.getValueAt(row, 2));		
		Laundry LaundryCode = new Laundry((String) table.getValueAt(row, 7));		
		String color = (String) table.getValueAt(row, 6);
		int laundryCount = (int) table.getValueAt(row, 10);
		Date releaseDate = (Date) table.getValueAt(row, 13);
		String etc = (String) table.getValueAt(row, 14);		

		if (row == -1) {
			throw new NotSelectedException();
		}

		return new OdTable(new Order(complete, no, ctNo, LaundryCode,color, laundryCount, etc),releaseDate);
	}

}
