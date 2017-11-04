package model;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.w3c.dom.stylesheets.LinkStyle;

import editor.GraphicsEditor;
import jdk.nashorn.internal.runtime.FindProperty;
import sun.security.provider.VerificationProvider;

public class SelectionState implements State {

	boolean prviProlaz=true;
	Shape selected=null;
//	ArrayList<Shape> listShapes;
	int pocXPomeraj, pocYPomeraj;
	GraphicsEditor editor;
	public SelectionState(GraphicsEditor editor) {
		// TODO Auto-generated constructor stub
		this.editor=editor;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	private Shape find(int x, int y){
		for(Shape current : editor.getListShapes()){
//			System.out.println("Object with type: "+current.getType()+" PocX: "+current.getPocX()+" RealX: "+current.getRealX()+" e.getX: "+ x +" PocY: "+ current.getPocY()+" RealY: "+ current.getRealY()+ " e.getY: "+y);
			if(current.getPocX()<=x && current.getPocY()<=y && current.getRealX()+current.getPocX()>=x && current.getRealY()+current.getPocY()>=y){
				pocXPomeraj = x-current.getPocX();
				pocYPomeraj = y-current.getPocY();
				return current;
			}
		}
		return null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(prviProlaz){
			prviProlaz=false;
			selected = find(e.getX(), e.getY());
			editor.setSelected(selected);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		prviProlaz=true;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(selected!=null){
			selected.setPocX(e.getX()-pocXPomeraj);
			selected.setPocY(e.getY()-pocYPomeraj);
		}
	}
	
	

}
