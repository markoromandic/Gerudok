package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import work.CreateID;
import work.CreateName;
import work.TypeShape;
/**
 * Element
 * @author Nemanja
 */
public class ModelElement implements GeRuDocument{
	
	private String name = "";
	private ArrayList<ModelElement> listElements;
	private ModelObject object;
	
	private int type, id;
	/**
	 * Ovde ide opis metode
	 * @author Nemanja
	 */
	public ModelElement(String name, int type){
		this.name=name;
		this.type=type;
		id = CreateID.getNewID();
		listElements = new ArrayList<>();
		object = new ModelObject(getType());
	}
	/**
	 * Ovde ide opis metode
	 * @author Nemanja
	 */
	public ModelElement(int type){
		this.name=CreateName.getElementName();
		this.type=type;
		System.out.println("NAPRAVLJEN SAM! Evo moj tip: "+getType());
		id = CreateID.getNewID();
		listElements = new ArrayList<>();
		object = new ModelObject(getType());
	}
	
	
	public ModelObject getObject() {
		return object;
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
	private void addElementToList(ModelElement element){
		if(element.getType()==type){
			System.out.println("Na element "+name+" dodajem: "+ element);
			listElements.add(element);
		} else System.out.println("GRESKA PRI DODAVANJU: Tip elementa "+name+" se ne podudara sa tipom elementa "+element.toString()+ " koji dodajemo");
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja 
	 */
	public void printAllElements(){
		System.out.println("Na elementu "+name+" se nalaze elementi:");
		for (int i = 0; i < listElements.size(); i++) {
			System.out.println(listElements.get(i));
		}
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja 
	 */
	private void removeElementByIndex(int index){
		if(index>=0 && index<listElements.size()){
			System.out.println("U elementu "+name+" brisem:"+ listElements.get(index));
			listElements.remove(index);
		}
		else System.out.println("GRESKA PRI BRISANJU: U elementu "+ name + " ne postoji element na indeksu "+ index);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void removeElementByElement (ModelElement element){
		if(listElements.contains(element)){
			System.out.println("U elementu "+name+" brisem:"+ element);
			listElements.remove(element);
		} else System.out.println("GRESKA PRI BRISANJU: U elementu "+name+" ne postoji objekat:"+ element);
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
	public ArrayList<ModelElement> getChildren(){
		return listElements;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return 
	 */
	public int getType(){
		return type;
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
	@Override
	public NameAndID add(Object o) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) o;
		ModelElement parent = (ModelElement) parentNode.getUserObject();
		if(parent.getType()==2){
			return new NameAndID(-1, "nema");
		}
		ModelElement child = new ModelElement(parent.getType());
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		parentNode.add(childNode);
		addElementToList(child);
		return new NameAndID(child.getID(), child.getName());
	}
	@Override
	public void remove(Object o) {
		// TODO Auto-generated method stub
		ModelElement element = (ModelElement) o;
		removeElementByElement(element);
	}
	@Override
	public void rename(String name) {
		// TODO Auto-generated method stub
		changeName(name);
	}
	@Override
	public ArrayList<Object> getChildrenOwn(){
		ArrayList<Object> listObj = new ArrayList<>();
		for(ModelElement part : getChildren()){
			listObj.add(part);
		}
		return listObj;
	}

}
