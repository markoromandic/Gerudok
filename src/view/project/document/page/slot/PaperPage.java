package view.project.document.page.slot;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import action.SlotMouseController;
import constants.ViewConstants;
import model.ModelElement;
import model.ModelSlot;
import model.Shape;
import work.TypeShape;

/**
 * Klasa predstavlja slot u stranici.
 * @author Marko Romandic
 */
public class PaperPage extends JPanel implements ViewConstants
{
	private int id;

	private BufferedImage imageSlot;
	private File fileImageSlot;
	private String image;
	
	public PaperPage(int id, String image)
	{
		this.id = id;
		this.image = image;
		initialize();
	}

	private void initialize()
	{
		fileImageSlot = new File(image);
		
		try 
	    {                
			imageSlot = ImageIO.read(fileImageSlot);
	    } 
		catch (IOException ex) 
		{
			System.err.println("FILE: " + fileImageSlot.toString() + "does not exist.");
	    }
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ImageIcon imageLabelSlot = new ImageIcon(imageSlot);
		
		JLabel slot = new JLabel("", imageLabelSlot, JLabel.CENTER);
		slot.setBounds(0, 0, imageLabelSlot.getIconWidth(), imageLabelSlot.getIconHeight());
		
		slot.setAlignmentX(CENTER_ALIGNMENT);
		
		add(slot);
		
		addMouseListener(new SlotMouseController());
	}

	public int getId()
	{
		return id;
	}
	
	public void drawShapes(ModelSlot slot){
		goThroughAll(slot.getChild());
	}
	
	private void goThroughAll(ModelElement element){
		//ovde iscrtavaj element
		
		for(ModelElement child : element.getChildren()){
			goThroughAll(child);
		}
	}
	
	private void iscrtajShape(ModelElement element){
		for(Shape currentShape: element.getObject().getListShapes()){
			if(currentShape.getType()==TypeShape.RECTANGLE){
				
			}
		}
	}
	
	@Override
	public void paint(Graphics g)
	{
		// TODO Auto-generated method stub
		super.paint(g);
		
	}
}