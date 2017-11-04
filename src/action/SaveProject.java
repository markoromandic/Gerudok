package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import constants.ViewConstants;
import files.ProjectFileExtension;
/**
 * Akcija za cuvanje odabranog projekta
 * @author Nemanja
 */
public class SaveProject extends AbstractEditorAction implements ViewConstants
{
	public SaveProject()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(NAME, SAVE_PROJECT_TITLE);
//		putValue(SMALL_ICON, loadIcon(SAVE_PROJECT_ICON)); 
		putValue(SHORT_DESCRIPTION, SAVE_PROJECT_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
	}
}