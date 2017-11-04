package view;

import java.util.ArrayList;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import action.PopupListener;
import app.Core;
import model.ModelProject;
/**
 * Ovde ide opis
 * @author Nemanja
 * 
 */
public class Tree extends JTree implements TreeSelectionListener
{
	DefaultTreeModel treeModel;
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public Tree(DefaultMutableTreeNode defMut)
	{
		super(defMut);
		DefaultTreeModel newModel = new DefaultTreeModel(Core.getInstance().getModel().getRootNode());
		this.setModel(newModel);
		addTreeSelectionListener(this);
		initialize();
		treeModel = (DefaultTreeModel) this.getModel();
		
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void removeNodeFromTree(DefaultMutableTreeNode node) {
		treeModel.removeNodeFromParent(node);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void initialize()
	{
		addMouseListener(new PopupListener());
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void changeRoot(DefaultMutableTreeNode newRoot){
		treeModel.setRoot(newRoot);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void removeRoot(){
		treeModel.setRoot(null);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	public ArrayList<DefaultMutableTreeNode> getAllProjectsNodes(){
		
		if(getTreeModel().getRoot()!=null){
			DefaultMutableTreeNode root = (DefaultMutableTreeNode)getTreeModel().getRoot();
			ArrayList<DefaultMutableTreeNode> projects = new ArrayList<>();
			DefaultMutableTreeNode currentNode;
			
			for(int i = 0; i<root.getChildCount(); i++){
				currentNode = (DefaultMutableTreeNode) this.getTreeModel().getChild(root, i);
				projects.add(currentNode);
			}
			
			return projects;
		}
		return null;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	@Override
	public void valueChanged(TreeSelectionEvent e)
	{
//		Core.getInstance().getActionManager().getCreate().actionPerformed(null);
	}

}
