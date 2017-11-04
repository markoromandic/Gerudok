package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Akcija za vracanje akcije u grafickom editoru 
 * @author Stefan
 */
public class Undo extends AbstractEditorAction implements ViewConstants
{
	public Undo()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		putValue(NAME, UNDO_TITLE);
//		putValue(SMALL_ICON, loadIcon(UNDO_ICON)); 
		putValue(SHORT_DESCRIPTION, UNDO_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
//		JEREMIC RADI AKCIJE
	}
}