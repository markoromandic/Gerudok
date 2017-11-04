package model;

import java.awt.event.MouseEvent;

public interface State {
	public abstract void mouseClicked(MouseEvent e);
	public abstract void mousePressed(MouseEvent e);
	public abstract void mouseReleased(MouseEvent e);
	public abstract void mouseDragged(MouseEvent e);
}
