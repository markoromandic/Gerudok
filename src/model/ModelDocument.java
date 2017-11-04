package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import work.CreateID;
import work.CreateName;
/**
 * Dokument
 * @author Nemanja
 * 
 */
public class ModelDocument implements GeRuDocument{
	
	private String name = "";
	private int id;
	private ArrayList<ModelPage> listPages;
	/**
	 * Ovde ide opis
	 * @author Nemanja 
	 */
	public ModelDocument(String name){
		this.name=name;
		listPages = new ArrayList<>();
		id = CreateID.getNewID();
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja 
	 */
	public ModelDocument(){
		this.name=CreateName.getDocumentName();
		listPages = new ArrayList<>();
		id = CreateID.getNewID();
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
	public void addPageToList(ModelPage page){
		System.out.println("U dokumentu "+name+" dodajem: "+ page);
		listPages.add(page);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void printAllPages(){
		System.out.println("U dokumentu "+name+" se nalaze straice:");
		for (int i = 0; i < listPages.size(); i++) {
			System.out.println(listPages.get(i));
		}
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void removePageByIndex(int index){
		if(index>=0 && index<listPages.size()){
			System.out.println("U dokumentu "+name+" brisem:"+ listPages.get(index));
			listPages.remove(index);
		}
		else System.out.println("GRESKA PRI BRISANJU: U dokumentu "+ name + " ne postoji stranica na indeksu "+ index);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void removePageByPage (ModelPage page){
		if(listPages.contains(page)){
			System.out.println("U dokumentu "+name+" brisem:"+ page);
			listPages.remove(page);
		} else System.out.println("GRESKA PRI BRISANJU: U dokumentu "+name+" ne postoji objekat:"+ page);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	public ArrayList<ModelPage> getChildren(){
		return listPages;
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
		ModelDocument parent = (ModelDocument) parentNode.getUserObject();
		ModelPage child = new ModelPage();
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		parentNode.add(childNode);
		addPageToList(child);
		return new NameAndID(child.getID(), child.getName());
	}
	@Override
	public void remove(Object o) {
		// TODO Auto-generated method stub
		ModelPage page = (ModelPage) o;
		removePageByPage(page);
	}
	@Override
	public void rename(String name) {
		// TODO Auto-generated method stub
		changeName(name);
	}
	@Override
	public ArrayList<Object> getChildrenOwn(){
		ArrayList<Object> listObj = new ArrayList<>();
		for(ModelPage part : getChildren()){
			listObj.add(part);
		}
		return listObj;
	}

}
