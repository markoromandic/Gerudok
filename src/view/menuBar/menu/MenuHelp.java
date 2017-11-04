package view.menuBar.menu;

import javax.swing.JMenu;

import com.sun.glass.events.KeyEvent;

import app.Core;
import constants.ViewConstants;
/**
 * Klasa MenuHelp nasledjuje JMenu i implementira ViewConstants
 * 
 * @author Marko Romandic
 * @version 1.0
 *
 */
public class MenuHelp extends JMenu  implements ViewConstants
{	
	public MenuHelp()
	{
		initialize();
	}
	
	public void initialize()
	{
		setText(HELP_TITLE_MENU);
		
		setMnemonic(KeyEvent.VK_H);
		add(Core.getInstance().getActionManager().getOpenHelp());
	}
}