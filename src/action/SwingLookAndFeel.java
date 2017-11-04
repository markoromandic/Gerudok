package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import app.Core;
import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Akcija za promenu teme aplikacije
 * @author Romandic
 */
public class SwingLookAndFeel extends AbstractEditorAction implements ViewConstants
{
	public SwingLookAndFeel()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.SHIFT_MASK));
		putValue(NAME, SWING_LOOK_AND_FEEL_TITLE);
		putValue(SHORT_DESCRIPTION, SWING_LOOK_AND_FEEL_TOOLTIP);
//		putValue(SMALL_ICON, loadIcon(BRUSH_ICON)); 
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Core.getInstance().getView().crossPlatformLookAndFeel();
	}

}
