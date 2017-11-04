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
 * Postavlja pregled projekata u dijagonalu
 * @author Romandic
 */
public class DiagonalView extends AbstractEditorAction implements ViewConstants
{	
	public DiagonalView()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F6, ActionEvent.SHIFT_MASK));
		putValue(NAME, DIAGONAL_TITLE);
//		putValue(SMALL_ICON, loadIcon(DIAGONAL_ICON)); 
		putValue(SHORT_DESCRIPTION, DIAGONAL_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int state = Core.getInstance().getView().getViewState();
				
		Viewers.getInstance().changeBounds(state);
	}
}