package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
import constants.ViewConstants;
import editor.GraphicsEditor;
import editor.TextEditor;
import model.ModelElement;
import model.ModelSlot;

public class Edit extends AbstractEditorAction implements ViewConstants
{	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 */
	public Edit()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		putValue(NAME, EDIT_TITLE);
//		putValue(SMALL_ICON, loadIcon(CUT_ICON)); 
		putValue(SHORT_DESCRIPTION, EDIT_TOOLTIP);
	}
	
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) Core.getInstance().getView().getTree().getLastSelectedPathComponent();
		int level = currentNode.getLevel();
		if(level>4){
			ModelElement element = (ModelElement) currentNode.getUserObject();
			int type = element.getType();
			if(type==2){
				new TextEditor(element.getObject().getTextObject());
			} else if(type==1){
				int id;
				DefaultMutableTreeNode parent = (DefaultMutableTreeNode)currentNode.getParent();
				while(true){
					if(parent.getUserObject() instanceof ModelSlot){
						id=((ModelSlot)parent.getUserObject()).getID();
						break;
					}
					parent = (DefaultMutableTreeNode) parent.getParent();
				}
				
				
				new GraphicsEditor(element.getObject().getListShapes(), id);
			}
		}
	}
}
