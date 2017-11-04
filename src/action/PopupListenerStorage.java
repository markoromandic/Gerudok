package action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import app.Core;
import constants.ViewConstants;
import model.ModelDocument;
import model.ModelProject;
import view.PopupMenuDocument;
import view.PopupMenuOther;
/**
 * Osluskivac za prikazivanje iskakajuceg prozora nad Draft drvetom
 * @author Nemanja
 */
public class PopupListenerStorage extends MouseAdapter implements ViewConstants
{

	boolean open = true;
	
	 @Override
	public void mousePressed(MouseEvent e)
	 {
		 
		 
       if(SwingUtilities.isRightMouseButton(e)){
		    int selRow = Core.getInstance().getView().getTreeStorage().getRowForLocation(e.getX(), e.getY());
		    TreePath selPath = Core.getInstance().getView().getTreeStorage().getPathForLocation(e.getX(), e.getY());
		    Core.getInstance().getView().getTreeStorage().setSelectionPath(selPath); 
		    if (selRow>-1){
		       Core.getInstance().getView().getTreeStorage().setSelectionRow(selRow);
		    }
       }
		 
		 
		if(open){
			if (SwingUtilities.isRightMouseButton(e)){
				open = false;
				doPop(e);
			}
		 }
	 }
	 @Override
	public void mouseReleased(MouseEvent e)
	 {
		 open = true;
	 }
	 private void doPop(MouseEvent e)
	 {
		DefaultMutableTreeNode current = (DefaultMutableTreeNode) Core.getInstance().getView().getTreeStorage().getLastSelectedPathComponent();
		Object obj = current.getUserObject();
		if(obj instanceof ModelProject || obj instanceof ModelDocument){
			try{
				 int level = ((DefaultMutableTreeNode) Core.getInstance().getView().getTreeStorage().getLastSelectedPathComponent()).getLevel();
				 if(level==2){
					 PopupMenuDocument menuPopUp = new PopupMenuDocument(false);
					 menuPopUp.show(e.getComponent(), e.getX(), e.getY());
				 } else{
					 PopupMenuOther menuPopUp = new PopupMenuOther(false);
					 menuPopUp.show(e.getComponent(), e.getX(), e.getY());
				 }
			 } catch(Exception exception){
				 System.out.println(NOTHING_SELECTED_SYSTEM);
			 }
		}
	     
	 }
	
	
}
