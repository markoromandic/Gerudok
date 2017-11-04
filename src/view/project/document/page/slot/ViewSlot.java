package view.project.document.page.slot;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.ViewConstants;

public class ViewSlot extends JPanel implements ViewConstants, MouseListener
{
	private BufferedImage imageSlot;
	private File fileImageSlot;
	private JLabel slot;
	
	public ViewSlot()
	{
		initialize();
	}
	
	private void initialize()
	{
		setLayout(null);
		
		fileImageSlot = new File(SLOT_IMAGE);
		
		try
		{
			imageSlot = ImageIO.read(fileImageSlot);
		}
		catch (Exception e)
		{
			System.err.println("FILE: " + fileImageSlot.toString() + "does not exist.");
		}
		
		ImageIcon slotPart = new ImageIcon(imageSlot);
		
		JLabel paper = new JLabel("", slotPart, JLabel.CENTER);
		paper.setBounds(0, 0, slotPart.getIconWidth(), slotPart.getIconWidth());
		
		add(paper);
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		System.err.println("TRACE");
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
