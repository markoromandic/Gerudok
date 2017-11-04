package view.project.document;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Klasa koja predstavlja adapter za povezivanje page-a i dokumenta.
 * @author Marko Romandic
 */
public class ViewAdapterDocumentPage extends JPanel
{
	public ViewAdapterDocumentPage()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
}
