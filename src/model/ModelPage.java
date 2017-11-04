package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import work.CreateID;
import work.CreateName;
/**
 * Page
 * @author Nemanja
 */
public class ModelPage implements GeRuDocument{

	private String name = "";
	private ArrayList<ModelSlot> listSlots;
	private int id;
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public ModelPage(String name) {
		this.name=name;
		listSlots=new ArrayList<>();
		id = CreateID.getNewID();
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public ModelPage() {
		this.name=CreateName.getPageName();
		listSlots=new ArrayList<>();
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
	private void addSlotToList(ModelSlot slot){
		System.out.println("Na stranici "+name+" dodajem: "+ slot);
		listSlots.add(slot);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	public void printAllSlots(){
		System.out.println("Na stranici "+name+" se nalaze slotovi:");
		for (int i = 0; i < listSlots.size(); i++) {
			System.out.println(listSlots.get(i));
		}
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void removeSlotByIndex(int index){
		if(index>=0 && index<listSlots.size()){
			System.out.println("na stranici "+name+" brisem:"+ listSlots.get(index));
			listSlots.remove(index);
		}
		else System.out.println("GRESKA PRI BRISANJU: Na stranici "+ name + " ne postoji slot na indeksu "+ index);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 */
	private void removeSlotBySlot (ModelSlot slot){
		if(listSlots.contains(slot)){
			System.out.println("Na stranici "+name+" brisem:"+ slot);
			listSlots.remove(slot);
		} else System.out.println("GRESKA PRI BRISANJU: Na stranici "+name+" ne postoji objekat:"+ slot);
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return 
	 */
	public ArrayList<ModelSlot> getChildren(){
		return listSlots;
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
	public String toString() {
		return name;
	}
	@Override
	public NameAndID add(Object o) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) o;
		ModelPage parent = (ModelPage) parentNode.getUserObject();
		ModelSlot child = new ModelSlot();
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		parentNode.add(childNode);
		addSlotToList(child);
		return new NameAndID(child.getID(), child.getName());
	}
	@Override
	public void remove(Object o) {
		// TODO Auto-generated method stub
		ModelSlot slot = (ModelSlot) o;
		removeSlotBySlot(slot);
	}
	@Override
	public void rename(String name) {
		// TODO Auto-generated method stub
		changeName(name);
	}
	@Override
	public ArrayList<Object> getChildrenOwn(){
		ArrayList<Object> listObj = new ArrayList<>();
		for(ModelSlot part : getChildren()){
			listObj.add(part);
		}
		return listObj;
	}

}
