package project_yeop.ui.insert;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class AbstractPanel<T> extends JPanel {

	public abstract void setItem(T item);

	public abstract T getItem();

	public abstract void validCheck();

	public abstract void clearTf();
}
