package view.menuBar.menu;

import javax.swing.JMenu;

import constants.ViewConstants;
import view.menuBar.menu.settings.MenuDesktopPaneView;
import view.menuBar.menu.settings.MenuLookAndFeel;
/**
 * Klasa MenuSettings nasledjuje JMenu i implementira ViewConstants
 * @author Marko Romandic
 * @version 1.0
 *
 */
public class MenuSettings extends JMenu implements ViewConstants
{
	
	private MenuLookAndFeel menuLookAndFeel;
	private MenuDesktopPaneView menuDesktopPaneView;
	
	public MenuSettings()
	{
		initialize();
	}
	
	private void initialize()
	{
		setText(SETTINGS_TITLE_MENU);
		
		menuLookAndFeel = new MenuLookAndFeel();
		menuDesktopPaneView = new MenuDesktopPaneView();
		
		add(menuLookAndFeel);
		add(menuDesktopPaneView);	
	}

	/**
	 * Metoda pomocu koje uzimam stanje, koje je izabrano za prikazivanje projekata.
	 * @author Marko Romandic
	 * @return state
	 */
	public Integer getViewState()
	{	
		return menuDesktopPaneView.getState();
	}
}