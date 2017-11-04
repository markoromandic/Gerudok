package model;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import work.CreateID;
import work.CreateName;
/**
 * Radni prostor
 * @author Nemanja
 */
public class ModelWorkspace implements GeRuDocument
{
	private String name = "";
	private ArrayList<ModelProject> listProjects;
	private int id;
	
	public ModelWorkspace(String name)
	{
		// TODO Auto-generated constructor stub
		this.name=name;
		listProjects = new ArrayList<>();
		id = CreateID.getNewID();
	}
	public ModelWorkspace()
	{
		// TODO Auto-generated constructor stub
		this.name=CreateName.getWorkspaceName();
		listProjects = new ArrayList<>();
		id = CreateID.getNewID();
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public int getID(){
		return id;
	}
	public void addProjectToList(ModelProject project){
		System.out.println("U workspaceu "+name+" dodajem: "+ project);
		listProjects.add(project);
	}
	public void printAllProjects(){
		System.out.println("U workspaceu "+name+" se nalaze projekti:");
		for (int i = 0; i < listProjects.size(); i++) {
			System.out.println(listProjects.get(i));
		}
	}
	private void removeProjectByIndex(int index){
		if(index>=0 && index<listProjects.size()){
			System.out.println("U workspaceu "+name+" brisem:"+ listProjects.get(index));
			listProjects.remove(index);
		}
		else System.out.println("GRESKA PRI BRISANJU: U workspaceu "+ name + " ne postoji projekat na indeksu "+ index);
	}
	private void removeProjectByProject (ModelProject project){
		if(listProjects.contains(project)){
			System.out.println("U workspaceu "+name+" brisem:"+ project);
			listProjects.remove(project);
		} else System.out.println("GRESKA PRI BRISANJU: U workspaceu "+name+" ne postoji objekat:"+ project);
	}
	public ArrayList<ModelProject> getChildren(){
		return listProjects;
	}
	private void changeName(String name){
		System.out.println("Promena naziva iz "+this.name+" u "+ name);
		this.name=name;
	}
	@Override
	public String toString()
	{
		return name;
	}
	@Override
	public NameAndID add(Object o) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) o;
		ModelWorkspace parent = (ModelWorkspace) parentNode.getUserObject();
		ModelProject child = new ModelProject();
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
		parentNode.add(childNode);
		addProjectToList(child);
		return new NameAndID(child.getID(), child.getName());
	}
	@Override
	public void remove(Object o) {
		// TODO Auto-generated method stub
		ModelProject project = (ModelProject) o;
		removeProjectByProject(project);
	}
	@Override
	public void rename(String name) {
		// TODO Auto-generated method stub
		changeName(name);
	}
	@Override
	public ArrayList<Object> getChildrenOwn(){
		ArrayList<Object> listObj = new ArrayList<>();
		for(ModelProject part : getChildren()){
			listObj.add(part);
		}
		return listObj;
	}

}
