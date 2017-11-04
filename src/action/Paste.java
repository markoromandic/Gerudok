package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Akcija koja nalepljuje element u grafickom editoru
 * @author Nemanja
 */
public class Paste extends AbstractEditorAction implements ViewConstants
{
	public Paste()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		putValue(NAME, PASTE_TITLE);
//		putValue(SMALL_ICON, loadIcon(PASTE_ICON)); 
		putValue(SHORT_DESCRIPTION, PASTE_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
//		JEREMIC RADI AKCIJE
	}
}