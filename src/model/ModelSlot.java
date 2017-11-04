package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import app.Core;
import work.CreateID;
import work.CreateName;
import work.TypeShape;
/**
 * Slot
 * @author Nemanja
 */
public class ModelSlot implements GeRuDocument{
	
	private String name = "";
	private ModelElement element;
	private int id;
	private int type;
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public ModelSlot(String name){
		this.type = Core.getInstance().getModel().getTypeForSlot().getType();
		this.name=name;
		id=CreateID.getNewID();
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public ModelSlot(){
		this.type = Core.getInstance().getModel().getTypeForSlot().getType();
		this.name=CreateName.getSlotName();
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
	
	private boolean addElementToSlot(ModelElement element){
		if(this.element==null){
			System.out.println("Na slot "+name+" dodajem: "+ element);
			this.element=element;
			return true;
		} else {
			System.out.println("GRESKA PRI DODAVANJU: Na slotu "+name+" vec postoji element "+ this.element);
			return false;
		}
	}
	
	public void printElement(){
		System.out.println("Na slotu "+name+" se nalazi element "+ element.toString());
	}
	
	private void removeElement(){
		System.out.println("Na slotu "+name+" brisem:"+ element);
		element=null;	
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return 
	 */
	public ModelElement getChild(){
		return element;
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
	public int getID(){
		return id;
	}
	
	private int getType() {
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
		ModelSlot parent = (ModelSlot) parentNode.getUserObject();
		ModelElement child = new ModelElement(parent.getType());
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		boolean added = addElementToSlot(child);
		if(added){
			parentNode.add(childNode);
			return new NameAndID(child.getID(), child.getName());
		}
		return new NameAndID(-1, null);
	}
	@Override
	public void remove(Object o) {
		// TODO Auto-generated method stub
		removeElement();
	}
	@Override
	public void rename(String name) {
		// TODO Auto-generated method stub
		changeName(name);
	}
	@Override
	public ArrayList<Object> getChildrenOwn(){
		ArrayList<Object> listObj = new ArrayList<>();
			listObj.add(getChild());
		return listObj;
	}
	
}
