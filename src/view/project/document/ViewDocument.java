package view.project.document;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

import constants.ViewConstants;

/**
 * Klasa pravi tabove u projektu.
 * @author Marko Romandic
 */
public class ViewDocument extends JTabbedPane implements ViewConstants
{
	private ArrayList<Integer> documentsIDs;
	
	public ViewDocument()
	{
		documentsIDs = new ArrayList<>();
	}
	
	public void addIcon()
	{
		ImageIcon iconNotResized = new ImageIcon(DOCUMENT_ICON);
		
		Image imgResizing =	iconNotResized.getImage();
		imgResizing = imgResizing.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(imgResizing);
		
		setIconAt(getTabCount() - 1, icon);
	}
	
	public void setId(int id)
	{
		documentsIDs.add(id);
	}

	public ArrayList<Integer> getDocumentsIDs()
	{
		return documentsIDs;
	}
}