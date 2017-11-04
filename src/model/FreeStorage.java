package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import app.Core;
/**
 * Klasa za GeRuDokumente bez roditelja
 *@author Nemanja
 */
public class FreeStorage implements TreeNode{

	private ArrayList<ModelProject> listStorageProject;
	private ArrayList<ModelDocument> listStorageDocument;
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public FreeStorage(){
		listStorageProject = new ArrayList<>();
		listStorageDocument = new ArrayList<>();
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void addProjectToStorage(ModelProject project){
		listStorageProject.add(project);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void addDocumentToStorage(ModelDocument document){
		listStorageDocument.add(document);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void removeProjectFromStorage(ModelProject project){
		listStorageProject.remove(project);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void removeDocumentFromStorage(ModelDocument document){
		listStorageDocument.remove(document);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public ArrayList<ModelProject> getListStorageProject() {
		return listStorageProject;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public ArrayList<ModelDocument> getListStorageDocument() {
		return listStorageDocument;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void addProjectListToProjects(ArrayList<Object> objects){
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) Core.getInstance().getView().getTreeStorage().getTreeModel().getRoot();
		ArrayList<ModelProject> projects = new ArrayList<>();
		for(Object part : objects) 
			projects.add((ModelProject) part);
		listStorageProject.addAll(projects);
		DefaultMutableTreeNode defMut;
		for(ModelProject pro : projects){
			defMut = new DefaultMutableTreeNode(pro);
			root.add(defMut);
			addDocuments(pro, defMut);
		}
		Core.getInstance().getView().getTreeStorage().getTreeModel().reload();
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void addDocumentsListToDocuments(ArrayList<Object> objects){
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) Core.getInstance().getView().getTreeStorage().getTreeModel().getRoot();
		ArrayList<ModelDocument> documents = new ArrayList<>();
		for(Object part : objects) 
			documents.add((ModelDocument) part);
		listStorageDocument.addAll(documents);
		DefaultMutableTreeNode defMut;
		for(ModelDocument doc : documents){
			defMut = new DefaultMutableTreeNode(doc);
			root.add(defMut);
			addPages(doc, defMut);
		}
		Core.getInstance().getView().getTreeStorage().getTreeModel().reload();
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void addDocuments (ModelProject project, DefaultMutableTreeNode projectNode){
		DefaultMutableTreeNode currentNode;
		for(ModelDocument document : project.getChildren()){
			currentNode = new DefaultMutableTreeNode(document);
			projectNode.add(currentNode);
			addPages(document, currentNode);
		}
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
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	@Override
	public String toString(){
		return "DRAFT";
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return 
	 */
	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}
}
