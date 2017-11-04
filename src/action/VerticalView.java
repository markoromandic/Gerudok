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
 * Postavlja pregled projekata u vertikalu
 * @author Romandic
 */
public class VerticalView extends AbstractEditorAction implements ViewConstants
{
	public VerticalView()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.SHIFT_MASK));
		putValue(NAME, VERTICAL_TITLE);
//		putValue(SMALL_ICON, loadIcon(VERTICAL_ICON)); 
		putValue(SHORT_DESCRIPTION, VERTICAL_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int state = Core.getInstance().getView().getViewState();
		
		Viewers.getInstance().changeBounds(state);
	}
}