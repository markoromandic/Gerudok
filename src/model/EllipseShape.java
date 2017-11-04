package model;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;

import command.Action;
import editor.GraphicsEditor;
import work.TypeShape;

public class EllipseShape implements State {
	ArrayList<Shape> listShape;
	Shape shape;
	Stack<Action> undo, redo;
	GraphicsEditor graphicsEditor;
	public EllipseShape(ArrayList<Shape> listShape, GraphicsEditor graphicsEditor){
		this.listShape=listShape;
		this.graphicsEditor=graphicsEditor;
		this.undo=graphicsEditor.getUndo();
		this.redo=graphicsEditor.getRedo();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		shape=new Shape();
		shape.setType(TypeShape.ELLIPSE);
		shape.setX(e.getX());
		shape.setY(e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(e.getX() < shape.getX()){
			shape.setRealX(shape.getX() - e.getX());
			shape.setPocX(e.getX());
		}
		else{
			shape.setRealX(e.getX() - shape.getX());
			shape.setPocX(shape.getX());
		}
		if(e.getY() < shape.getY()){
			shape.setRealY(shape.getY() - e.getY());
			shape.setPocY(e.getY());
		}
		else{
			shape.setRealY(e.getY() - shape.getY());
			shape.setPocY(shape.getY());
		}
		listShape.add(shape);
		undo.push(new Action("add", shape, graphicsEditor));
		redo.clear();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
