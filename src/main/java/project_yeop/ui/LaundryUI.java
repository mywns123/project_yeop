package project_yeop.ui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import project_yeop.dto.Laundry;
import project_yeop.service.LaundryService;
import project_yeop.ui.insert.AbstractPanel;
import project_yeop.ui.insert.LaundryPanel;
import project_yeop.ui.table.AbstractTablePanel;
import project_yeop.ui.table.LaundryTablePanel;

@SuppressWarnings("serial")
public class LaundryUI extends AbstractUI<Laundry> {

	private LaundryService service;

	@Override
	protected void setService() {
		service = new LaundryService();
	}

	@Override
	protected void tableLoadData() {
		((LaundryTablePanel) pTable).setService(service);
		pTable.loadData();
	}

	@Override
	protected AbstractPanel<Laundry> creatPanel() {
		return new LaundryPanel();
	}

	@Override
	protected AbstractTablePanel<Laundry> creatTablePanel() {
		return new LaundryTablePanel();
	}

	@Override
	protected void actionPerformdMenuUpdate() {
		Laundry upLaundry = pTable.getItem();
		pPanel.setItem(upLaundry);
		btnAdd.setText("수정");
	}

	@Override
	protected void actionPerformdMenuDelete() {
		Laundry delLaundry = pTable.getItem();
		service.removeLaundry(delLaundry);
		pTable.loadData();
		JOptionPane.showMessageDialog(null, delLaundry + "삭제 되었습니다.");
	}

	@Override
	protected void actionPerformedBtnUpdate(ActionEvent e) {
		Laundry upLaundry = pPanel.getItem();
		service.modifyLaundry(upLaundry);
		pTable.loadData();
		pPanel.clearTf();
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, upLaundry.getlLaundryCode() + "정보가 수정되었습니다.");
	}

	@Override
	protected void actionPerformedBtnAdd(ActionEvent e) {
		Laundry laundry = pPanel.getItem();
		service.addLaundry(laundry);
		pTable.loadData();
		pPanel.clearTf();
		JOptionPane.showMessageDialog(null, laundry + " 추가했습니다.");
	}

}
