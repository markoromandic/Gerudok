package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
import view.ViewAbout;

public class OpenAbout extends AbstractEditorAction implements ViewConstants
{
	/**
	 * Akcija koja otvara prozor o programerima 
	 * @author Nemanja
	 */
	public OpenAbout()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.SHIFT_MASK));
		putValue(NAME, ABOUT_TITLE);
//		putValue(SMALL_ICON, loadIcon(ABOUT_ICON)); 
		putValue(SHORT_DESCRIPTION, ABOUT_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		ViewAbout viewAbout = new ViewAbout();
		viewAbout.setVisible(true);
	}
}
