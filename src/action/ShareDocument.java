package action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.jndi.toolkit.ctx.StringHeadTail;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import app.Core;
import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
import javafx.scene.layout.Border;
import model.ModelDocument;
import model.ModelElement;
import model.ModelPage;
import model.ModelProject;
import model.ModelSlot;
import view.maker.Viewers;
/**
 * Akcija za podelu dokumenta sa drugim projektom
 * @author Nemanja
 */
public class ShareDocument extends AbstractEditorAction implements ViewConstants
{
	DefaultMutableTreeNode currentNode;
	ModelDocument current;
	
	public ShareDocument()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		putValue(NAME, SHARE_DOCUMENT_TITLE);
//		putValue(SMALL_ICON, loadIcon(SHARE_DOCUMENT_ICON)); 
		putValue(SHORT_DESCRIPTION, SHARE_DOCUMENT_TOOLTIP);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		currentNode = (DefaultMutableTreeNode) Core.getInstance().getView().getTree().getLastSelectedPathComponent();
		current = (ModelDocument) currentNode.getUserObject();
		
		Viewers.getInstance().getShareProject(Core.getInstance().getView().getTree().getAllProjectsNodes());
		
		
	}
	/**
	 * Metoda koja se poziva nakon sto se odabere drugi projkat
	 * @author Nemanja
	 */
	public void doShare(DefaultMutableTreeNode parentNode) throws CloneNotSupportedException{
				ModelProject parent = (ModelProject) parentNode.getUserObject();
				parent.addDocumentToList(current);
				DefaultMutableTreeNode clone = (DefaultMutableTreeNode)currentNode.clone();
				parentNode.add(clone);
				
				addPages(current, clone);
				
				Core.getInstance().getView().getTree().getTreeModel().reload();
				
				int idProject = ((ModelProject) parentNode.getUserObject()).getID();
				int idDocument = current.getID();
				
				String title = current.getName();
				
				Viewers.getInstance().addSharedDocumentView(idProject, idDocument, title);
				
				Core.getInstance().getView().setVisible(true);
	}
	/**
	 * Pomocna metoda za popunjavanje strukture ispod dokumenta 
	 * @author Nemanja
	 */
	public void addPages (ModelDocument document, DefaultMutableTreeNode documentNode){
		DefaultMutableTreeNode currentNode;
		for(ModelPage page : document.getChildren()){
			currentNode = new DefaultMutableTreeNode(page);
			documentNode.add(currentNode);
			addSlots(page, currentNode);
		}
	}
	/**
	 * Pomocna metoda za popunjavanje strukture ispod dokumenta
	 * @author Nemanja
	 */
	public void addSlots(ModelPage page, DefaultMutableTreeNode pageNode){
		DefaultMutableTreeNode currentNode;
		for(ModelSlot slot : page.getChildren()){
			currentNode = new DefaultMutableTreeNode(slot);
			pageNode.add(currentNode);
			addElementToSlot(slot, currentNode);
		}
	}
	/**
	 * Pomocna metoda za popunjavanje strukture ispod dokumenta
	 * @author Nemanja
	 */
	public void addElementToSlot(ModelSlot slot, DefaultMutableTreeNode slotNode){
		DefaultMutableTreeNode currentNode;
		ModelElement element = slot.getChild();
		if(element!=null){
			currentNode = new DefaultMutableTreeNode(element);
			slotNode.add(currentNode);
			addElementToElement(element, currentNode);
		}
		
	}
	/**
	 * Pomocna metoda za popunjavanje strukture ispod dokumenta
	 * @author Nemanja
	 */
	public void addElementToElement(ModelElement parentElement, DefaultMutableTreeNode parentElementNode){
		DefaultMutableTreeNode currentNode;
		for(ModelElement childElement : parentElement.getChildren()){
			currentNode = new DefaultMutableTreeNode(childElement);
			parentElementNode.add(currentNode);
			addElementToElement(childElement, currentNode);
		}
	}
	
	
}