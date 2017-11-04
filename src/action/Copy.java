package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * kopiranje u grafickom editoru 
 * @author Stefan
 */
public class Copy extends AbstractEditorAction implements ViewConstants
{
	public Copy()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(NAME, COPY_TITLE);
//		putValue(SMALL_ICON, loadIcon(COPY_ICON)); 
		putValue(SHORT_DESCRIPTION, COPY_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}
