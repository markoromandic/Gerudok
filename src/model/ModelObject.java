package model;

import java.awt.Graphics;
import java.util.ArrayList;

import editor.TextEditor;

public class ModelObject {
	private int type;
	private ArrayList<Shape> listShapes=null;
	private TextObject textObject=null;
	public ModelObject(int type){
		this.type=type;
		if(this.type==1){
			listShapes = new ArrayList<>();
		}
		if (this.type==2){
			textObject = new TextObject();
		}
	}
	
	public ArrayList<Shape> getListShapes() {
		return listShapes;
	}
	
	public TextObject getTextObject() {
		return textObject;
	}
	
		
}
