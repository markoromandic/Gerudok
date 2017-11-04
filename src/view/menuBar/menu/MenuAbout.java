package view.menuBar.menu;

import javax.swing.JMenu;

import com.sun.glass.events.KeyEvent;

import app.Core;
import constants.ViewConstants;
/**
 * Klasa MenuAbout nasledjuje JMenu i implementira ViewConstants
 * @author Marko Romandic
 * @version 1.0
 *
 */
public class MenuAbout extends JMenu implements ViewConstants
{	
	public MenuAbout()
	{
		initialize();
	}
	
	private void initialize()
	{
		setText(ABOUT_TITLE_MENU);
		
		setMnemonic(KeyEvent.VK_A);
		add(Core.getInstance().getActionManager().getOpenAbout());
	}
}