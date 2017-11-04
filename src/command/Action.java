package command;

import java.util.ArrayList;

import editor.GraphicsEditor;
import model.Shape;

public class Action {
	private String name;
	private Shape shape;
	private ArrayList<Shape> listShape;
	private GraphicsEditor editor;
	public Action(String name, Shape shape, GraphicsEditor editor) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.shape=shape;
		this.listShape=editor.getListShapes();
		this.editor = editor;
	}
	
	public void undo(){
		if(name.equals("delete")){
			listShape.add(shape);
		} else if(name.equals("paste")){
			listShape.remove(shape);
		} else if(name.equals("add")){
			listShape.remove(shape);
		}
		editor.repaint();
	}
	public void redo(){
		if(name.equals("delete")){
			listShape.remove(shape);
		} else if(name.equals("paste")){
			listShape.add(shape);
		} else if(name.equals("add")){
			listShape.add(shape);
		}
		editor.repaint();
	}
}
