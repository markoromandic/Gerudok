package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Akcija za vracanje unazadjenje akcije 
 * @author Nemanja
 */
public class Redo extends AbstractEditorAction implements ViewConstants
{
	public Redo()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		putValue(NAME, REDO_TITLE);
		putValue(SHORT_DESCRIPTION, REDO_TOOLTIP);
//		putValue(SMALL_ICON, loadIcon(REDO_ICON)); 
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
//		JEREMIC RADI AKCIJE
	}
}
