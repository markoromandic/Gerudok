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
 * Klasa u kojoj pravim meni, za biranje teme aplikacije.
 * @author Marko Romandic
 * @return state
 */
public class MenuLookAndFeel extends JMenu implements ViewConstants
{

	private JRadioButtonMenuItem menuRadioSystemLookAndFeel;
	private JRadioButtonMenuItem menuRadioCrossPlatformLookAndFeel;
	
	private ButtonGroup buttonGroupLookAndFeel;
	
	public MenuLookAndFeel()
	{
		initialize();
	}
	
	private void initialize()
	{
		setText(THEMES_TITLE_MENU);
		
		Icon icon = null;
		   
		ImageIcon iconNotResized = new ImageIcon(THEMES_ICON);
			
		Image imgResizing =	iconNotResized.getImage();
		imgResizing = imgResizing.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(imgResizing);
		
		setIcon(icon);
		
		menuRadioSystemLookAndFeel = new JRadioButtonMenuItem(Core.getInstance().getActionManager().getSystemLookAndFeel());
		menuRadioCrossPlatformLookAndFeel = new JRadioButtonMenuItem(Core.getInstance().getActionManager().getSwingLookAndFeel());
		
		buttonGroupLookAndFeel = new ButtonGroup();
		buttonGroupLookAndFeel.add(menuRadioSystemLookAndFeel);
		buttonGroupLookAndFeel.add(menuRadioCrossPlatformLookAndFeel);

		add(menuRadioCrossPlatformLookAndFeel);
		add(menuRadioSystemLookAndFeel);
		
		menuRadioCrossPlatformLookAndFeel.setSelected(true);
	}
}
