package project_yeop.ui.frame;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import project_yeop.dto.Laundry;
import project_yeop.exception.NotSelectedException;
import project_yeop.service.LaundryService;
import project_yeop.ui.panel.insert.AbstractInsertPanel;
import project_yeop.ui.panel.insert.LaundryInsertPanel;
import project_yeop.ui.panel.table.AbstractTablePanel;
import project_yeop.ui.panel.table.LaundryTablePanel;

@SuppressWarnings("serial")
public class LaundryFrameUI extends AbstractFrameUI<Laundry> {

	private LaundryService service;

	
	public LaundryFrameUI() {
		setTitle("세탁물 코드표");
	}

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
	protected AbstractInsertPanel<Laundry> creatPanel() {
		return new LaundryInsertPanel();
	}

	@Override
	protected AbstractTablePanel<Laundry> creatTablePanel() {
		return new LaundryTablePanel();
	}

	@Override
	protected void actionPerformdMenuUpdate() {
		Laundry upLaundry;
		try {
			upLaundry = pTable.getItem();
		} catch (Exception e1) {
			throw new NotSelectedException();
		}		
		pPanel.setItem(upLaundry);
		btnAdd.setText("수정");
	}

	@Override
	protected void actionPerformdMenuDelete() {
		Laundry delLaundry;
		try {
			delLaundry = pTable.getItem();
		} catch (Exception e1) {
			throw new NotSelectedException();
		}	
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
