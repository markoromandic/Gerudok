package work;

import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
import model.ModelWorkspace;
/**
 * Ovde ide opis 
 * @author Nemanja
 */
public class CreateNewWorkspace {
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 */
	public CreateNewWorkspace(){
		ModelWorkspace newWorkspace = new ModelWorkspace(CreateName.getWorkspaceName());
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(newWorkspace);
		Core.getInstance().getModel().changeRoot(node);
		Core.getInstance().getView().getTree().changeRoot(node);
	}
}
