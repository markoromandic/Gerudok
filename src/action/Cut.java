package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Isecanje elementa u grafickom editoru
 * @author Stefan
 */
public class Cut extends AbstractEditorAction implements ViewConstants
{	
	public Cut()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(NAME, CUT_TITLE);
		putValue(SMALL_ICON, loadIcon(CUT_ICON)); 
		putValue(SHORT_DESCRIPTION, CUT_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
