package view.project.document;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.project.document.page.ViewPage;

/**
 * Klasa predstavlja dokument.
 * @author Marko Romandic
 */
public class PanelDocument extends JPanel implements Cloneable
{
	private int id;
	private int pageCounter = 0;
	private JScrollPane paperScroll;
	private ViewAdapterDocumentPage viewAdapterDocumentPage;
	
	public PanelDocument(int id)
	{
		this.id = id;
		
		setLayout(new BorderLayout());
		viewAdapterDocumentPage = new ViewAdapterDocumentPage();
		
		paperScroll = new JScrollPane(viewAdapterDocumentPage);
		
		add(paperScroll, BorderLayout.CENTER);
	}
	
	public void addPage(ViewPage vPage)
	{
		viewAdapterDocumentPage.add(vPage);
	}
	
	public int getId()
	{
		return id;
	}

	public int getPageCounter()
	{
		return pageCounter;
	}

	public void increasePageCounter()
	{
		pageCounter++;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}