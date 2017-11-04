package view.project;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import app.Core;
import constants.ViewConstants;
import view.project.document.PanelDocument;
import view.project.document.ViewDocument;

/**
 * Klasa predstavlja projekat.
 * @author Marko Romandic
 */
public class ViewProject extends JInternalFrame implements ViewConstants, InternalFrameListener
{
	private static int PROJECT_COUNTER = 0;
	private ViewDocument viewDocument;
	private int id;
	private String title;
	
	public ViewProject(String title, int id)
	{	
		super("" , true,true, true, true);
		this.id = id;
		this.title = title;
		initialize();
	}
	
	public ViewDocument getViewDocument()
	{
		return viewDocument;
	}

	private void initialize()
	{	
		setSize(575,675);
		setTitle(title);
		addInternalFrameListener(this);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		viewDocument = new ViewDocument();
		
		add(viewDocument);
		
		PROJECT_COUNTER++;
		
		int viewState = Core.getInstance().getView().getViewState();
		
		if(viewState == 0)
			setLocation(X * PROJECT_COUNTER, Y);
		else if(viewState == 1)
			setLocation(X * PROJECT_COUNTER, Y * PROJECT_COUNTER);
		else
			setLocation(X, Y * PROJECT_COUNTER);
		
		setIconifiable(true);
		setClosable(true);
		setVisible(true);
		setResizable(false);
		
		Icon icon = null;
		
		String imageURL = "images/iconProject.png";
		      
		ImageIcon iconNotResized = new ImageIcon(imageURL);
		
		Image imgResizing =	iconNotResized.getImage();
		imgResizing = imgResizing.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(imgResizing);
		
		setFrameIcon(icon);
	}
	
	
	public int getId()
	{
		return id;
	}
	
	public void setDocumentTab(String title, PanelDocument panelDocument, int id)
	{
		viewDocument.addTab(title, panelDocument);
		viewDocument.addIcon();
		viewDocument.setId(id);
	}
	
	public String getTitle(int documentId)
	{
		String title = null;
		
		for (int i : viewDocument.getDocumentsIDs())
		{
			if(viewDocument.getDocumentsIDs().get(id) == documentId)
			{
				title = viewDocument.getTitleAt(i);
				break;
			}
		}
		
		return title;
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e)
	{

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e)
	{
		PROJECT_COUNTER--;
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
