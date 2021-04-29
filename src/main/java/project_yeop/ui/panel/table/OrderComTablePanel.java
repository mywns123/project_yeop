package project_yeop.ui.panel.table;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;

import project_yeop.dto.Customer;
import project_yeop.dto.Laundry;
import project_yeop.dto.OdTable;
import project_yeop.dto.Order;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.OrderService;

@SuppressWarnings("serial")
public class OrderComTablePanel extends AbstractTablePanel<OdTable>{

	private OrderService service = new OrderService();

	public void setService(OrderService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showOdTableUnComplete();
		
	}

	public void setSearchList(List<OdTable> odList) {
		list = odList;
	}
	
	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5,6,7,8,10,12,13,14);
		setTableCellAlign(SwingConstants.RIGHT, 9,11);
		setTableCellWidth(100, 100, 100, 100, 100, 100,100, 100, 150, 150, 100, 150, 150, 150, 200);
		
	}

	@Override
	public Object[] toArray(OdTable t) {
		String complete =  t.getOrder().isComplete() == true? "출고": "미출고";
		DecimalFormat df = new DecimalFormat("#,###.#");
		String up = df.format( t.getLaundry().getUnitPrice());
		String tp = df.format(t.getPrice());
		
		return new Object[] {  complete,				
								t.getOrder().getNo(),
								t.getCtTable().getCustomer().getcNo(),
							    t.getCtTable().getCustomer().getcName(),
							    t.getGrade().getgGrade(),
							    t.getGrade().getDiscountRate() + "%",
							    t.getOrder().getColor(),
							    t.getLaundry().getlLaundryCode(),
							    t.getLaundry().getProduct(),
							    up + "원",
							    t.getOrder().getLaundryCount(),
							    tp + "원",
							    t.getOrder().getReceiveDate(),
							    t.getReleaseDate(),
							    t.getOrder().getEtc()		
		};
	}

	@Override
	public String[] getColumnNames() {
		return new String[] {  "완료", "주문번호","회원번호", "고객명", "회원등급","할인율", "색상", "세탁물코드", "제품명", "단가","수량", "총가격 ", "입고일", "출고일","기타사항" };

	}

	@Override
	public OdTable getItem() {
		int row = table.getSelectedRow();
		boolean complete = (boolean) table.getValueAt(row, 0).equals("출고") ? true : false;
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

		return new OdTable(new Order(complete, no, ctNo, LaundryCode, color, laundryCount, etc),releaseDate);
	}

	

}
