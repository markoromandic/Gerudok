package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
import model.GeRuDocument;
import model.Model;
import model.ModelDocument;
import model.ModelElement;
import model.ModelPage;
import model.ModelProject;
import model.ModelSlot;
import view.maker.Viewers;
/**
 * Akcija koja uklanja element iz drveta
 * @author Nemanja
 */
public class Remove extends AbstractEditorAction implements ViewConstants
{
	public Remove()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.ALT_MASK));
		putValue(NAME, REMOVE_TITLE);
//		putValue(SMALL_ICON, loadIcon(REMOVE_ICON)); 
		putValue(SHORT_DESCRIPTION, REMOVE_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try{
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)Core.getInstance().getView().getTree().getLastSelectedPathComponent();
			int level = currentNode.getLevel();
			int id = -1;
			
			if(level!=0)
			{
				if(level == 1){
					GeRuDocument current = (GeRuDocument) currentNode.getUserObject();
					Core.getInstance().getModel().getFreeStorage().addDocumentsListToDocuments(current.getChildrenOwn());
					Core.getInstance().getModel().getRoot().remove(current);
					id = current.getID();
				} 
				else{
					GeRuDocument current = (GeRuDocument) currentNode.getUserObject();
					DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) currentNode.getParent();
					GeRuDocument parent = (GeRuDocument) parentNode.getUserObject();
					parent.remove(current);
					id = current.getID();
				}
				
				Core.getInstance().getView().getTree().removeNodeFromTree(currentNode);
				
				Viewers.getInstance().remove(level, id);
			} 
			else
			{
				GeRuDocument current = (GeRuDocument) Core.getInstance().getModel().getRoot();
				id = current.getID();
				Core.getInstance().getModel().getFreeStorage().addProjectListToProjects(Core.getInstance().getModel().getRoot().getChildrenOwn());
				Core.getInstance().getModel().removeRoot();
				//dodato da ne bi model udarao na view
				Core.getInstance().getView().getTree().removeRoot();
				
				Viewers.getInstance().removeWorkspace();
			}
			
		} 
		catch (Exception exception) 
		{
			System.out.println(NOTHING_SELECTED_SYSTEM);
		}
	}
}