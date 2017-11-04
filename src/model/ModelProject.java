package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import work.CreateID;
import work.CreateName;
/**
 * Projekat
 * @author Nemanja
 */
public class ModelProject implements GeRuDocument{

	private String name = "";
	private ArrayList<ModelDocument> listDocuments;
	private int id;
	
	public ModelProject(String name){
		this.name=name;
		listDocuments = new ArrayList<>();
		id=CreateID.getNewID();
	}
	
	public ModelProject(){
		this.name=CreateName.getProjectName();
		listDocuments = new ArrayList<>();
		id=CreateID.getNewID();
	}
	
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return 
	 */
	public String getName() {
		return name;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return 
	 */
	@Override
	public int getID(){
		return id;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void addDocumentToList(ModelDocument document){
		System.out.println("U projektu "+name+" dodajem: "+ document);
		listDocuments.add(document);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void printAllDocuments(){
		System.out.println("U projektu "+name+" se nalaze dokumenti:");
		for (int i = 0; i < listDocuments.size(); i++) {
			System.out.println(listDocuments.get(i));
		}
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja 
	 */
	private void removeDocumentByIndex(int index){
		if(index>=0 && index<listDocuments.size()){
			System.out.println("U projektu "+name+" brisem:"+ listDocuments.get(index));
			listDocuments.remove(index);
		}
		else System.out.println("GRESKA PRI BRISANJU: U projektu "+ name + " ne postoji dokument na indeksu "+ index);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void removeDocumentByDocument (ModelDocument document){
		if(listDocuments.contains(document)){
			System.out.println("U projektu "+name+" brisem:"+ document);
			listDocuments.remove(document);
		} else System.out.println("GRESKA PRI BRISANJU: U projektu "+name+" ne postoji objekat:"+ document);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public ArrayList<ModelDocument> getChildren(){
		return listDocuments;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja 
	 */
	private void changeName(String name) {
		System.out.println("Promena naziva iz "+this.name+" u "+ name);
		this.name=name;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return 
	 */
	@Override
	public String toString()
	{
		return name;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return 
	 */
	public String ispisi(){
		return "pisi mi pisi";
	}
	@Override
	public NameAndID add(Object o) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) o;
		ModelProject parent = (ModelProject) parentNode.getUserObject();
		ModelDocument child = new ModelDocument();
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		parentNode.add(childNode);
		addDocumentToList(child);
		return new NameAndID(child.getID(), child.getName());
	}
	@Override
	public void remove(Object o) {
		// TODO Auto-generated method stub
		ModelDocument document = (ModelDocument) o;
		removeDocumentByDocument(document);
	}
	@Override
	public void rename(String name) {
		// TODO Auto-generated method stub
		changeName(name);
	}
	@Override
	public ArrayList<Object> getChildrenOwn(){
		ArrayList<Object> listObj = new ArrayList<>();
		for(ModelDocument part : getChildren()){
			listObj.add(part);
		}
		return listObj;
	}

}
