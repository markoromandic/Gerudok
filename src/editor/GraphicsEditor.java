package editor;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.prism.shader.DrawCircle_Color_AlphaTest_Loader;

import app.Core;
import command.Action;
import command.RedoCommand;
import command.UndoCommand;
import model.ModelSlot;
import model.Shape;
import view.maker.Viewers;
import view.project.document.page.slot.PaperPage;
import work.TypeShape;

public class GraphicsEditor extends JFrame{
	Shape selected=null;
	Graphics graphics;
	JButton buttonCyrcle, buttonRectangle, buttonSelect, buttonCopy, buttonCut, buttonPaste, buttonDelete, buttonUndo, buttonRedo;
	ArrayList<Shape> listShapes;
	Stack<Action> undo, redo;
	GraphicsEditor thisEditor;
	Shape cutten = null;
	int slotId;
	
	public JButton getButtonCopy() {
		return buttonCopy;
	}
	public JButton getButtonCut() {
		return buttonCut;
	}
	public JButton getButtonPaste() {
		return buttonPaste;
	}
	StateManager manager;
	public GraphicsEditor(ArrayList<Shape> listShapes, int id){
		slotId=id;
		undo = new Stack<>();
		redo = new Stack<>();
		thisEditor=this;
		this.listShapes =listShapes;
		buttonCyrcle = new JButton("Cyrcle");
		buttonRectangle = new JButton("Rectangle");
		buttonSelect = new JButton("Select");
		buttonCopy = new JButton("Copy");
		buttonCut = new JButton("Cut");
		buttonPaste = new JButton("Paste");
		buttonDelete = new JButton("Delete");
		buttonUndo = new JButton("Undo");
		buttonRedo = new JButton("Redo");
		
		manager = new StateManager(this);
		
		
		addMouseListener(manager);
		addMouseMotionListener(manager);
		
		setSize(450, 600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JToolBar toolBarButtons = new JToolBar();
		
//		toolBarButtons.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		toolBarButtons.add(buttonSelect);
		toolBarButtons.addSeparator();
		toolBarButtons.add(buttonCyrcle);
		toolBarButtons.add(buttonRectangle);
		toolBarButtons.addSeparator();
		toolBarButtons.add(buttonCopy);
		toolBarButtons.add(buttonCut);
		toolBarButtons.add(buttonPaste);
		toolBarButtons.addSeparator();
		toolBarButtons.add(buttonDelete);
		toolBarButtons.add(buttonUndo);
		toolBarButtons.add(buttonRedo);
		
		add(toolBarButtons, BorderLayout.NORTH);
		
//		butt
		
		setVisible(true);
		
		setUpButtons();
		
		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				// TODO Auto-generated method stub
				super.windowClosing(e);
				PaperPage currentPaperPage = Viewers.getInstance().getPaperPageUsingID(slotId);
				ModelSlot currentModelSlot = Core.getInstance().getModel().getSlotUsingId(slotId);
				currentPaperPage.drawShapes(currentModelSlot);
			}
		});
	}
	
	private void continueDrawing(Graphics g){
//
//		System.out.println("continueDrawing");
//		System.out.println("SIZE: "+ listShapes.size());
		for(Shape currentShape : listShapes){
			if(currentShape.getType()==TypeShape.RECTANGLE){
				g.drawRect(currentShape.getPocX(), currentShape.getPocY(), currentShape.getRealX(), currentShape.getRealY());
			} else if(currentShape.getType() == TypeShape.ELLIPSE){
				g.drawOval(currentShape.getPocX(), currentShape.getPocY(), currentShape.getRealX(), currentShape.getRealY());
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		continueDrawing(g);
	}
	
	public JButton getButtonCyrcle() {
		return buttonCyrcle;
	}
	public JButton getButtonRectangle() {
		return buttonRectangle;
	}
	public JButton getButtonSelect() {
		return buttonSelect;
	}
	public ArrayList<Shape> getListShapes() {
		return listShapes;
	}
	public Shape getSelected() {
		return selected;
	}
	public void setSelected(Shape selected) {
		this.selected = selected;
	}
	
	private void setUpButtons(){
		buttonDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(selected!=null){
					listShapes.remove(selected);
					undo.push(new Action("delete", selected, thisEditor));
					redo.clear();
					selected=null;
					repaint();
					
					
				}
			}
		});
		
		buttonCopy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(selected!=null){
					Shape copied = new Shape();
					copied.setPocX(selected.getPocX()+5);
					copied.setPocY(selected.getPocY()+5);
					copied.setRealX(selected.getRealX());
					copied.setRealY(selected.getRealY());
					copied.setType(selected.getType());
					Clipboard.current = copied;
					
					cutten=null;
				}
			}
		});
		
		buttonPaste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Clipboard.current!=null){
					
					if(cutten!=null){
						listShapes.remove(cutten);
						if (selected==cutten) selected=null;
						
						undo.push(new Action("delete", cutten, thisEditor));
						cutten=null;
						
						
					}
					
					listShapes.add(Clipboard.current);
					undo.push(new Action("paste", Clipboard.current, thisEditor));
					redo.clear();
					Shape copied = new Shape();
					copied.setPocX(Clipboard.current.getPocX()+5);
					copied.setPocY(Clipboard.current.getPocY()+5);
					copied.setRealX(Clipboard.current.getRealX());
					copied.setRealY(Clipboard.current.getRealY());
					copied.setType(Clipboard.current.getType());
					Clipboard.current = copied;
					
					
					
					repaint();
				}
			}
		});
		
		buttonCut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(selected!=null){
					Shape copied = new Shape();
					copied.setPocX(selected.getPocX()+5);
					copied.setPocY(selected.getPocY()+5);
					copied.setRealX(selected.getRealX());
					copied.setRealY(selected.getRealY());
					copied.setType(selected.getType());
					Clipboard.current = copied;
					
					cutten=selected;
					
					
					
//					repaint();
				}
			}
		});
		
		buttonUndo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("UNDO");
				if(!undo.isEmpty()){
					System.out.println("NIJE EMPTY");
					Action currentAction = undo.pop();
					UndoCommand undo = new UndoCommand(currentAction);
					redo.push(currentAction);
				}
			}
		});
		
		buttonRedo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!redo.isEmpty()){
					Action currentAction = redo.pop();
					RedoCommand redo = new RedoCommand(currentAction);
					undo.push(currentAction);
				}
			}
		});
	}
	public Stack<Action> getUndo() {
		return undo;
	}
	public Stack<Action> getRedo() {
		return redo;
	}
	
	
	
	
}
