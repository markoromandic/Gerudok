package view;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import action.PopupListener;
import action.PopupListenerStorage;
import app.Core;
/**
 * Ovde ide opis klase
 * @author Nemanja
 */
public class TreeStorage extends JTree implements TreeSelectionListener{
	
	DefaultTreeModel treeModel;
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public TreeStorage(DefaultMutableTreeNode defMut)
	{
		super(defMut);
		DefaultTreeModel newModel = new DefaultTreeModel(Core.getInstance().getModel().getFreeStorageAsNode());
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
		addMouseListener(new PopupListenerStorage());
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
	 */
	@Override
	public void valueChanged(TreeSelectionEvent e)
	{
//		Core.getInstance().getActionManager().getCreate().actionPerformed(null);
	}

}
