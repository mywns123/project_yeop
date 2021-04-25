package project_yeop.ui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import project_yeop.dto.Grade;
import project_yeop.service.GradeService;
import project_yeop.ui.insert.AbstractPanel;
import project_yeop.ui.insert.GradePanel;
import project_yeop.ui.table.AbstractTablePanel;
import project_yeop.ui.table.GradeTablePanel;

@SuppressWarnings("serial")
public class GradeUI extends AbstractUI<Grade> {

	private GradeService service;

	@Override
	protected void setService() {
		service = new GradeService();
	}

	@Override
	protected void tableLoadData() {
		((GradeTablePanel) pTable).setService(service);
		pTable.loadData();
	}

	@Override
	protected AbstractPanel<Grade> creatPanel() {
		return new GradePanel();
	}

	@Override
	protected AbstractTablePanel<Grade> creatTablePanel() {
		return new GradeTablePanel();
	}

	@Override
	protected void actionPerformdMenuUpdate() {
		Grade updateGrade = pTable.getItem();
		pPanel.setItem(updateGrade);
		btnAdd.setText("수정");
	}

	@Override
	protected void actionPerformdMenuDelete() {
		Grade delGrade = pTable.getItem();
		service.removeGrade(delGrade);
		pTable.loadData();
		JOptionPane.showMessageDialog(null, delGrade + "삭제 되었습니다.");
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Grade updateGrade = pPanel.getItem();
		service.modifyGrade(updateGrade);
		pTable.loadData();
		pPanel.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, updateGrade.getgGrade() + "정보가 수정되었습니다.");
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Grade grade = pPanel.getItem();
		service.addGrade(grade);
		pTable.loadData();
		pPanel.clearTf();
		JOptionPane.showMessageDialog(null, grade + " 추가했습니다.");
	}

}
