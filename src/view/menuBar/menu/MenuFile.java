package view.menuBar.menu;

import javax.swing.JMenu;

import com.sun.glass.events.KeyEvent;

import app.Core;
import constants.ViewConstants;
/**
 * Klasa MenuFile nasledjuje JMenu i implementira ViewConstants
 * i predstavlja meni aplikacije.
 * @author Marko Romandic
 * @version 1.0
 *
 */
public class MenuFile extends JMenu implements ViewConstants
{
	public MenuFile()
	{
		initialize();
	}
	
	public void initialize()
	{
		setText(FILE_TITLE_MENU);
		
		setMnemonic(KeyEvent.VK_F);

		add(Core.getInstance().getActionManager().getOpenWorkspace());
		add(Core.getInstance().getActionManager().getOpenProject());
		addSeparator();
		add(Core.getInstance().getActionManager().getCreate());
		add(Core.getInstance().getActionManager().getRemove());
		addSeparator();
		add(Core.getInstance().getActionManager().getSaveWorkspace());
		add(Core.getInstance().getActionManager().getSaveProject());
		addSeparator();
		add(Core.getInstance().getActionManager().getUndo());
		add(Core.getInstance().getActionManager().getRedo());
		addSeparator();
		add(Core.getInstance().getActionManager().getCopy());
		add(Core.getInstance().getActionManager().getCut());
		add(Core.getInstance().getActionManager().getPaste());
		addSeparator();
		add(Core.getInstance().getActionManager().getShareDocument());
		add((Core.getInstance().getActionManager().getRename()));
		addSeparator();
		add(Core.getInstance().getActionManager().getCloseApp());
	}
}
