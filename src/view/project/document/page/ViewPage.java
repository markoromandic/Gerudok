package view.project.document.page;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Klasa predstavlja stranicu dokumenta.
 * @author Marko Romandic
 */
public class ViewPage extends JPanel
{
	private int id;
	
	private JLabel labelPage;
	private String title;
	
	public ViewPage(int id, String title)
	{
		this.title = title;
		this.id = id;
		initialize();
	}
	
	public int getId()
	{
		return id;
	}

	private void initialize()
	{			
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		labelPage = new JLabel(title);
		
		labelPage.setFont(new Font("Ariel", Font.BOLD, 25));
		
		labelPage.setAlignmentX(CENTER_ALIGNMENT);
		
		add(labelPage);
	}

	public void renameTitle(String title)
	{
		labelPage.setText(title);
	}
}