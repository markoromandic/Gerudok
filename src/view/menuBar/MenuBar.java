package view.menuBar;

import javax.swing.JMenuBar;

import view.menuBar.menu.MenuAbout;
import view.menuBar.menu.MenuFile;
import view.menuBar.menu.MenuHelp;
import view.menuBar.menu.MenuSettings;

/**
 * Klasa MenuBar nasledjuje klasu JMenuBar i kreira menije.
 * @author Marko Romandic
 * @version 2.0
 *
 */
public class MenuBar extends JMenuBar
{
	private MenuFile menuFile;
	private MenuAbout menuAbout;
	private MenuHelp menuHelp;
	private MenuSettings menuSettings;
	
	/**
	 * Default konstruktor
	 * @author Marko Romandic
	 * @version 2.0
	 *
	 */
	public MenuBar()
	{
		initialize();
	}
	
	private void initialize()
	{
		menuFile = new MenuFile();
		
		menuSettings = new MenuSettings();
		
		menuAbout = new MenuAbout();
		
//		menuHelp = new MenuHelp();
		
		add(menuFile);
		add(menuSettings);
//		add(menuHelp);
		add(menuAbout);
	}
	
	/**
	 * Metoda pomocu koje uzimam stanje, koje je izabrano za prikazivanje projekata.
	 * @author Marko Romandic
	 * @return state
	 */
	public Integer getState()
	{
		return menuSettings.getViewState();
	}
}