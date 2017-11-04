package editor;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import model.EllipseShape;
import model.RectangleShape;
import model.SelectionState;
import model.State;

public class StateManager implements MouseListener, MouseMotionListener{

	GraphicsEditor graphicsFrame;
	private State state;
	JButton buttonCyrcle, buttonRectangle, buttonSelect;
	public StateManager(GraphicsEditor editor) {
		graphicsFrame = editor;
		// TODO Auto-generated constructor stub
		buttonCyrcle = editor.getButtonCyrcle();
		buttonRectangle=editor.getButtonRectangle();
		buttonSelect = editor.getButtonSelect();
		
		buttonCyrcle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EllipseShape current = new EllipseShape(graphicsFrame.getListShapes(), graphicsFrame);
				state = current;
			}
		});
		buttonRectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RectangleShape current = new RectangleShape(graphicsFrame.getListShapes(), graphicsFrame);
				state = current;
			}
		});
		buttonSelect.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelectionState current = new SelectionState(graphicsFrame);
				state = current;
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		state.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		state.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		state.mouseReleased(e);
		graphicsFrame.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
//		state.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
//		state.mouseExited(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		state.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		state.mouseMoved(e);
	}

}
