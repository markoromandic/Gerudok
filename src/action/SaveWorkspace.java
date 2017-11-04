package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

import app.Core;
import constants.ViewConstants;
import files.WorkspaceFileExtension;
import model.ModelProject;
import model.ModelWorkspace;
/**
 * Akcija za cuvanje radnog prostora
 * @author Nemanja
 */
public class SaveWorkspace extends AbstractEditorAction implements ViewConstants
{
	public SaveWorkspace()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(NAME, SAVE_WORKSPACE_TITLE);
//		putValue(SMALL_ICON, loadIcon(SAVE_WORKSPACE_ICON)); 
		putValue(SHORT_DESCRIPTION, SAVE_WORKSPACE_TOOLTIP);
	}

	/**
	 * Akcija za cuvanje workspacea
	 * @author Uros
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
	}
	private void SaveProject(ModelProject childAt, String newPath) {
		// TODO Auto-generated method stub
		
	}
}