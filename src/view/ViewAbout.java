package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.ViewConstants;
/**
 * ViewAbout klasa
 * @author Marko Romandic
 */
public class ViewAbout extends JFrame implements ViewConstants
{
	private ImageIcon iconAbout;
	private JPanel panelAbout;
	/**
	 * Default konstruktor
	 * @author Marko Romandic
	 */
	public ViewAbout()
	{
		initialize();
	}

	private void initialize()
	{
		setSize(470, 500);
		setLocationRelativeTo(null); 
		setResizable(false);
		
		ImageIcon iconNotResized = new ImageIcon(GERUDOK_ICON);
		
		Image iconGeRuDok =	iconNotResized.getImage();
		iconGeRuDok = iconGeRuDok.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
		setIconImage(iconGeRuDok);
		
		iconAbout = new ImageIcon(ABOUT_PANEL_ICON);
		
		Image imageResizing = iconAbout.getImage();
		imageResizing = imageResizing.getScaledInstance(470, 470, Image.SCALE_SMOOTH);
		iconAbout = new ImageIcon(imageResizing);
		
		panelAbout = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				g.drawImage(iconAbout.getImage(), 0, 0, null);
	
			}
		};
		
		add(panelAbout);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
