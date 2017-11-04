package action;

import java.awt.event.ActionEvent;

import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
import constants.ViewConstants;
import model.GeRuDocument;
import view.maker.Viewers;
/**
 * Akcija koja otvara pregled odabranog projekta
 * @author Romandic
 */
public class OpenViewProject extends AbstractEditorAction implements ViewConstants
{
	public OpenViewProject()
	{
		putValue(NAME, OPEN_EXISTING_PROJECT_TITLE);
		putValue(SHORT_DESCRIPTION, OPEN_EXISTING_PROJECT_TOOLTIP);
//		putValue(SMALL_ICON, loadIcon(OPEN_EXISTING_PROJECT_ICON)); 
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)Core.getInstance().getView().getTree().getLastSelectedPathComponent();
		GeRuDocument current = (GeRuDocument) currentNode.getUserObject();
		int id = current.getID();
		
		Viewers.getInstance().openSelectedProject(id);
	}
}