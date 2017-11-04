package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Akcija za zatvaranje aplikacije 
 * @author Nemanja
 */
public class CloseApp extends AbstractEditorAction implements ViewConstants
{	
	public CloseApp()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		putValue(NAME, CLOSE_TITLE);
//		putValue(SMALL_ICON, loadIcon(CLOSE_ICON)); 
		putValue(SHORT_DESCRIPTION, CLOSE_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}
