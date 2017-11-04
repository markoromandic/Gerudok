package view;

import javax.swing.JPopupMenu;

import app.Core;

public class PopupMenuElement extends JPopupMenu{
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public PopupMenuElement(boolean mainTree)
	{
		if(mainTree)
			initializeMain();
		else
			initializeStorage();
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void initializeMain()
	{
		add(Core.getInstance().getActionManager().getCreate());
		add(Core.getInstance().getActionManager().getRename());
		add(Core.getInstance().getActionManager().getEdit());
		addSeparator();
		add(Core.getInstance().getActionManager().getRemove());
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void initializeStorage()
	{
		add(Core.getInstance().getActionManager().getChooseParent());
	}

}
