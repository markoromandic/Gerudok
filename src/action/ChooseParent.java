package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
import constants.ViewConstants;
import model.ModelDocument;
import model.ModelProject;
import model.ModelWorkspace;
import view.maker.Viewers;
import work.ChangeParentDocument;
import work.ChangeParentProject;
/**
 * Akcija za vracanje iz Drafta u glavnu strukturu
 * @author Nemanja
 */
public class ChooseParent extends AbstractEditorAction implements ViewConstants
{
	DefaultMutableTreeNode currentNode;
	ModelProject currentProject;
	ModelDocument currentDocument;
	
	public ChooseParent()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		putValue(NAME, CHOOSEPARENT_TITLE);
//		putValue(SMALL_ICON, loadIcon(CHOOSEPARENT_ICON)); 
		putValue(SHORT_DESCRIPTION, CHOOSEPARENT_TOOLTIP);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		currentNode = (DefaultMutableTreeNode) Core.getInstance().getView().getTreeStorage().getLastSelectedPathComponent();
		if(currentNode.getUserObject() instanceof ModelProject)
		{

			if(Core.getInstance().getModel().getWorkspaceExists()){
				currentProject = (ModelProject) currentNode.getUserObject();
				
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) Core.getInstance().getView().getTree().getTreeModel().getRoot();
				String nameParent = ((ModelWorkspace) parentNode.getUserObject()).getName();
				String nameProject = currentProject.getName();
				//OVDE POZOVI ONAJ KOJI SAM TRAZI POTVRDU ZA WORKSPACE
				int option = Viewers.getInstance().checkForProject(parentNode, nameParent, nameProject);
			} else System.err.println("Ne postoji aktivan workspace");
		} 
		else if(currentNode.getUserObject() instanceof ModelDocument)
		{
			currentDocument = (ModelDocument) currentNode.getUserObject();
			
			Viewers.getInstance().getChooseParentProject(Core.getInstance().getView().getTree().getAllProjectsNodes());	
		}
	}
	
	public void doChangeToWorkspace(DefaultMutableTreeNode parentNode){
		ModelWorkspace parent = (ModelWorkspace) parentNode.getUserObject();
		
		parentNode.add(currentNode);
		new ChangeParentProject(currentProject, parent, parentNode);
	}
	
	public void doChangeToProject(DefaultMutableTreeNode parentNode){
		ModelProject parent = (ModelProject) parentNode.getUserObject();
		parentNode.add(currentNode);
		new ChangeParentDocument(currentDocument, parent, parentNode);
		Viewers.getInstance().addDrafDocument(currentDocument.getName(), parent.getID(), currentDocument.getID());
	}

}
