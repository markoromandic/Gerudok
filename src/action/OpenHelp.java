package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Akcija koja otvara pomoc
 * @author Nemanja
 */
public class OpenHelp extends AbstractEditorAction implements ViewConstants
{
	public OpenHelp()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.SHIFT_MASK));
		putValue(NAME, HELP_TITLE);
//		putValue(SMALL_ICON, loadIcon(HELP_ICON)); 
		putValue(SHORT_DESCRIPTION, HELP_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("OTVARACE SE HELP");
	}
}
