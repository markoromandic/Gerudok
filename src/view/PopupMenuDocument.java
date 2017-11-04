package view;

import javax.swing.JPopupMenu;

import app.Core;
/**
 * Klasa PopupMenuDocument nasledjuje JPopMenu.
 * @author Marko Romandic
 *@version 2.0
 */
public class PopupMenuDocument extends JPopupMenu
{
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public PopupMenuDocument(boolean mainTree)
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
		add(Core.getInstance().getActionManager().getShareDocument());
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
