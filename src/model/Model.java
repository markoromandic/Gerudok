package model;

import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
/**
 * Ovde ide opis klase
 * @author Nemanja
 * @version 1.0
 */
import work.TypeShape;
import work.TypeForSlot;
public class Model
{
	DefaultMutableTreeNode rootNode;
	ModelWorkspace root;
	FreeStorage storage;
	TypeForSlot typeForSlot;
	
	private boolean workspaceExists;
	/**
	 * Glavna klasa modela. Sadrzi root kao Workspace i FreeStorage za GeRuDokumente bez roditelja
	 * @author Nemanja
	 */
	public Model()
	{
		typeForSlot = new TypeForSlot();
		storage = new FreeStorage();
		workspaceExists = false;
//		root = new ModelWorkspace("Prvi workspace");
//		rootNode = new DefaultMutableTreeNode(root);
		
	}
	public DefaultMutableTreeNode getFreeStorageAsNode(){
		DefaultMutableTreeNode storageNode = new DefaultMutableTreeNode(storage);
		return storageNode;
	}
	public FreeStorage getFreeStorage(){
		return storage;
	}
	public DefaultMutableTreeNode getRootNode(){
		return rootNode;
	}
	public ModelWorkspace getRoot(){
		return root;
	}
	public void removeRoot(){
		root=null;
		rootNode=null;
//		pod komentarom da ne bi udarao u view
//		Core.getInstance().getView().getTree().removeRoot();
		workspaceExists=false;
	}
	public void changeRoot(DefaultMutableTreeNode newRoot){
		rootNode = newRoot;
		root = (ModelWorkspace) newRoot.getUserObject();
//		pod komentarom da ne bi udarao na view
//		Core.getInstance().getView().getTree().changeRoot(newRoot);
		workspaceExists=true;
	}
	public void writeModelInConsole(){
		if(root==null){
			System.out.println("Nothing");
		} else{
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("W: "+root);
			for(ModelProject project : root.getChildren()){
				stringBuilder.append("\n");
				stringBuilder.append("PR:   "+project);
				for(ModelDocument document : project.getChildren()){
					stringBuilder.append("\n");
					stringBuilder.append("D:      "+document);
					for(ModelPage page : document.getChildren()){
						stringBuilder.append("\n");
						stringBuilder.append("PA:       "+page);
						for(ModelSlot slot : page.getChildren()){
							stringBuilder.append("\n");
							stringBuilder.append("S:         "+slot);
							ModelElement ele = slot.getChild();
							stringBuilder.append("\n");
							stringBuilder.append("E:           "+ele);
						}
					}
				}
			}
			stringBuilder.append("\n\n----------------\n\n");
			
			System.out.println(stringBuilder);
		}
	}
	public boolean getWorkspaceExists(){
		return workspaceExists;
	}
	public void changeWorkspaceExists(){
		workspaceExists = !workspaceExists;
	}
	public TypeForSlot getTypeForSlot() {
		return typeForSlot;
	}
	public ModelSlot getSlotUsingId(int id){
		for(ModelProject currentProject : root.getChildren()){
			for(ModelDocument currentDocument : currentProject.getChildren()){
				for(ModelPage currentPage : currentDocument.getChildren()){
					for(ModelSlot currentSlot : currentPage.getChildren()){
						if(currentSlot.getID() == id){
							return currentSlot;
						}
					}
				}
			}
		}
		return null;
	}
}
