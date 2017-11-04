package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import app.Core;
import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
import view.maker.Viewers;
/**
 * Postavlja pregled projekata u horizontalu 
 * @author Romandic
 */
public class HorizontalView extends AbstractEditorAction implements ViewConstants
{
	public HorizontalView()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F7, ActionEvent.SHIFT_MASK));
		putValue(NAME, HORIZONTAL_TITLE);
//		putValue(SMALL_ICON, loadIcon(HORIZONTAL_ICON)); 
		putValue(SHORT_DESCRIPTION, HORIZONTAL_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int state = Core.getInstance().getView().getViewState();
		
		Viewers.getInstance().changeBounds(state);
	}
}