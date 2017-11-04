package work;

import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
import model.GeRuDocument;
import model.ModelDocument;
import model.ModelElement;
import model.ModelPage;
import model.ModelProject;
import model.ModelSlot;
import model.ModelWorkspace;
/**
 * Ovde ide opis 
 * @author Nemanja
 */
public class RenameDo {
	int id;
	public RenameDo(){
		
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public int doAndreturnId(DefaultMutableTreeNode currentNode, int level, String newName){
		GeRuDocument current = (GeRuDocument) currentNode.getUserObject();
		current.rename(newName);
		id = current.getID();

		Core.getInstance().getView().getTree().getTreeModel().reload();
		return id;
	}
}
