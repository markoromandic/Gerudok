package view;

import javax.swing.JPopupMenu;

import app.Core;

public class PopupMenuProject extends JPopupMenu{
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public PopupMenuProject(boolean mainTree)
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
		add(Core.getInstance().getActionManager().getOpenViewProject());
		add(Core.getInstance().getActionManager().getRename());
		addSeparator();
		add(Core.getInstance().getActionManager().getRemove());
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void initializeStorage(){
		add(Core.getInstance().getActionManager().getChooseParent());
	}
}
