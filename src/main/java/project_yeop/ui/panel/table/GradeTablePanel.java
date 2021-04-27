package project_yeop.ui.panel.table;

import javax.swing.SwingConstants;

import project_yeop.dto.Grade;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.GradeService;

@SuppressWarnings("serial")
public class GradeTablePanel extends AbstractTablePanel<Grade> {
	
	private GradeService service = new GradeService();
	
	public GradeTablePanel() {
	}	

	public void setService(GradeService service) {
		this.service = service;
	}

	@Override
	public void initList() {
		list = service.showGrades();
	}

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellWidth(100, 100);
	}

	@Override
	public Object[] toArray(Grade t) {
		return new Object[] { t.getgGrade(),
				t.getDiscountRate()+"%" };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "회원 등급", "할인율" };
	}

	@Override
	public Grade getItem() {
		int row = table.getSelectedRow();
		String gGrade = (String) table.getValueAt(row, 0);
		
		String dis = (String) table.getValueAt(row, 1);
		String t = dis.replace("%", "");
		int t1 = Integer.parseInt(t);
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		return new Grade(gGrade, t1);
	}

}
