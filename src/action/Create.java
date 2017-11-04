package action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.glass.ui.CommonDialogs.Type;

import app.Core;
import constants.ViewConstants;
import model.GeRuDocument;
import model.Model;
import model.NameAndID;
import view.maker.Viewers;
import work.CreateNewElementOnElement;
import work.CreateNewElementOnSlot;
import work.CreateNewWorkspace;
/**
 * Kreiranje novog GeRuDokumenta (Workspace, Project, Document,...)
 * @author Nemanja
 */
public class Create extends AbstractEditorAction implements ViewConstants
{
	public Create()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		putValue(NAME, CREATE_TITLE);
//		putValue(SMALL_ICON, loadIcon(CREATE_ICON)); 
		putValue(SHORT_DESCRIPTION, CREATE_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(Core.getInstance().getModel().getWorkspaceExists()){
			try{
				DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)(Core.getInstance().getView().getTree().getLastSelectedPathComponent());
				int level = currentNode.getLevel();
				if(level==3){
					JDialog dialog = new JDialog(Core.getInstance().getView(), "Choose slot type");
					dialog.setLocation(50, 50);
					dialog.setLocationRelativeTo(null);
					dialog.setSize(190, 90);
					dialog.setVisible(true);
					dialog.setLayout(new BorderLayout());
					JButton btn1 = new JButton("Graphical");
					btn1.setSize(80, 80);
					JButton btn2 = new JButton("Text");
					btn2.setSize(80,80);
					dialog.add(btn1, BorderLayout.WEST);
					dialog.add(btn2, BorderLayout.EAST);
					
					Core.getInstance().getView().setEnabled(false);
					
					dialog.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							// TODO Auto-generated method stub
							super.windowClosing(e);
							Core.getInstance().getView().setEnabled(true);
						}
					});
					
					btn1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							Core.getInstance().getModel().getTypeForSlot().setType(1);
							GeRuDocument current = (GeRuDocument) currentNode.getUserObject();
							NameAndID childNameAndId = current.add(currentNode);
							if(childNameAndId.getId()!=-1){
								Core.getInstance().getView().getTree().getTreeModel().reload(currentNode);
								Viewers.getInstance().addSlot(current.getID(), childNameAndId.getId(), GRAPHIC_SLOT_IMAGE);
							}
							Core.getInstance().getView().setEnabled(true);
							dialog.dispose();
						}
					});
					
					btn2.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							Core.getInstance().getModel().getTypeForSlot().setType(2);
							GeRuDocument current = (GeRuDocument) currentNode.getUserObject();
							NameAndID childNameAndId = current.add(currentNode);
							if(childNameAndId.getId()!=-1){
								Core.getInstance().getView().getTree().getTreeModel().reload(currentNode);
								Viewers.getInstance().addSlot(current.getID(), childNameAndId.getId(), TEXT_SLOT_IMAGE);
							}
							Core.getInstance().getView().setEnabled(true);
							dialog.dispose();
						}
					});
				}else{
					GeRuDocument current = (GeRuDocument) currentNode.getUserObject();
					NameAndID childNameAndId = current.add(currentNode);
					if(childNameAndId.getId()!=-1){
						Core.getInstance().getView().getTree().getTreeModel().reload(currentNode);
						
						//current ti je parent, childNameAndId ima name i id kao podatak od deteta odnosno novo napravljenog
						if(level == 0) {Viewers.getInstance().initalizeGuiProject(childNameAndId.getName(), childNameAndId.getId());}
						else if(level == 1){Viewers.getInstance().initializeTabDocument(childNameAndId.getName(), current.getID(), childNameAndId.getId());}
						else if(level == 2) {Viewers.getInstance().addPage(current.getID(), childNameAndId.getId(), childNameAndId.getName());}
						else if(level==3) {Viewers.getInstance().addSlot(current.getID(), childNameAndId.getId(), SLOT_IMAGE);}
						else if(level==4) {new CreateNewElementOnSlot(currentNode);}
						else if(level>4){new CreateNewElementOnElement(currentNode);}
					}
				}
				
			} catch (Exception exception) {
				System.out.println(NOTHING_SELECTED_SYSTEM);
			}
		} else{
			new CreateNewWorkspace();
		}
		
	}

}
