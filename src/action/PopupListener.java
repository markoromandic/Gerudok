package action;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import app.Core;
import constants.ViewConstants;
import view.PopupMenuDocument;
import view.PopupMenuElement;
import view.PopupMenuOther;
import view.PopupMenuProject;
/**
 * Osluskivac za iskakajuci prozor nad drvetom
 * @author Nemanja
 */
public class PopupListener extends MouseAdapter implements ViewConstants
{
	boolean open = true;
	
	 @Override
	public void mousePressed(MouseEvent e)
	 {
		 
		 
        if(SwingUtilities.isRightMouseButton(e)){
		    int selRow = Core.getInstance().getView().getTree().getRowForLocation(e.getX(), e.getY());
		    TreePath selPath = Core.getInstance().getView().getTree().getPathForLocation(e.getX(), e.getY());
		    Core.getInstance().getView().getTree().setSelectionPath(selPath); 
		    if (selRow>-1){
		       Core.getInstance().getView().getTree().setSelectionRow(selRow);
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
			 try{
			 int level = ((DefaultMutableTreeNode) Core.getInstance().getView().getTree().getLastSelectedPathComponent()).getLevel();
			 if(level==2){
				 PopupMenuDocument menuPopUp = new PopupMenuDocument(true);
				 menuPopUp.show(e.getComponent(), e.getX(), e.getY());
			 } else if(level==1){
				 PopupMenuProject menuPopUp = new PopupMenuProject(true);
				 menuPopUp.show(e.getComponent(), e.getX(), e.getY());
				 
			 } else if(level>4){
				 PopupMenuElement menuPopUp = new PopupMenuElement(true);
				 menuPopUp.show(e.getComponent(), e.getX(), e.getY());
			 }else{
				 PopupMenuOther menuPopUp = new PopupMenuOther(true);
				 menuPopUp.show(e.getComponent(), e.getX(), e.getY());
			 }
		 } catch(Exception exception){
			 System.out.println(NOTHING_SELECTED_SYSTEM);
		 }
	     
	 }
}
