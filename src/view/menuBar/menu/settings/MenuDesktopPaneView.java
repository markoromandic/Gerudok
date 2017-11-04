package view.menuBar.menu.settings;

import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import app.Core;
import constants.ViewConstants;

/**
 * Klasa za prikazivanje u meniju, izbor za nacin prikazivanja projekata.
 * @author Marko Romandic
 */
public class MenuDesktopPaneView extends JMenu implements ViewConstants
{
	private String title;
	
	private JRadioButtonMenuItem menuRadioHorizontal;
	private JRadioButtonMenuItem menuRadioVertical;
	private JRadioButtonMenuItem menuRadioDiagonal;
	
	private ButtonGroup buttonGroupProjectViewer;
	
	/**
	 * Default konstruktor
	 * @author Marko Romandic
	 */
	public MenuDesktopPaneView()
	{
		initialize();
	}
	
	private void initialize()
	{
		setText(VIEW_TITLE_MENU);
		
		Icon icon = null;
		   
		ImageIcon iconNotResized = new ImageIcon(WINDOWS_ICON);
			
		Image imgResizing =	iconNotResized.getImage();
		imgResizing = imgResizing.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(imgResizing);
		
		setIcon(icon);
		
		menuRadioHorizontal = new JRadioButtonMenuItem(Core.getInstance().getActionManager().getHorizontalView());
		menuRadioDiagonal = new JRadioButtonMenuItem(Core.getInstance().getActionManager().getDiagonalView());
		menuRadioVertical = new JRadioButtonMenuItem(Core.getInstance().getActionManager().getVerticalView());
		
		buttonGroupProjectViewer = new ButtonGroup();
		buttonGroupProjectViewer.add(menuRadioHorizontal);
		buttonGroupProjectViewer.add(menuRadioDiagonal);
		buttonGroupProjectViewer.add(menuRadioVertical);
		
		add(menuRadioVertical);
		add(menuRadioDiagonal);
		add(menuRadioHorizontal);
	
		menuRadioDiagonal.setSelected(true);
	}

	/**
	 * Metoda pomocu koje uzimam stanje, koje je izabrano za prikazivanje projekata.
	 * @author Marko Romandic
	 * @return state
	 */
	public Integer getState()
	{
		boolean d = menuRadioDiagonal.isSelected();
		boolean v = menuRadioVertical.isSelected();
		boolean h = menuRadioHorizontal.isSelected();
		
		if(h)
			return 0;
		else if(d)
			return 1;
		else if(v)
			return 2;
		else
			System.err.println("FALSE VALUE");
		
		System.err.println("DOSAO SAM DOVDE");
		return 0;
	}
}