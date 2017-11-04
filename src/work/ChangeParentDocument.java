package work;

import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
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
public class ChangeParentDocument {
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 */
	public ChangeParentDocument(ModelDocument child, ModelProject parent, DefaultMutableTreeNode parentNode){
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		parentNode.add(childNode);
		parent.addDocumentToList(child);
		addPages(child, childNode);
		Core.getInstance().getView().getTreeStorage().removeNodeFromTree(childNode);
		Core.getInstance().getView().getTree().getTreeModel().reload();
		Core.getInstance().getView().getTreeStorage().getTreeModel().reload();
	}
	/**
	 * Ovde ide opis 
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
	 * Ovde ide opis 
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
	 * Ovde ide opis 
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
	 * Ovde ide opis 
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
