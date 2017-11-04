package view;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import app.Core;
/**
 * Klasa ButtonBar koja nasledjuje JToolBar i u njoj se postavlja ButtonBar
 * @author Marko Romandic
 * @version 2.0
 */
public class ButtonBar extends JToolBar
{
	/**
	 * Pravljenje button bara.
	 * @author Marko Romandic
	 */
	public ButtonBar()
	{
		super(SwingConstants.HORIZONTAL);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		initialize();
	}

	private void initialize()
	{
		add(Core.getInstance().getActionManager().getCreate());
		add(Core.getInstance().getActionManager().getRemove());
		add(Core.getInstance().getActionManager().getShareDocument());
		addSeparator();
		add(Core.getInstance().getActionManager().getSaveWorkspace());
		add(Core.getInstance().getActionManager().getSaveProject());
		addSeparator();
		add(Core.getInstance().getActionManager().getUndo());
		add(Core.getInstance().getActionManager().getRedo());
	}
}
