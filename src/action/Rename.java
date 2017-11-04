package action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import app.Core;
import constants.ViewConstants;
import view.maker.Viewers;
import work.RenameDo;
/**
 * Akcija za promene naziva GeRuDokumenata
 * @author Nemanja
 */
public class Rename extends AbstractEditorAction implements ViewConstants{
	public Rename()
	{
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		putValue(NAME, RENAME_TITLE);
		putValue(SHORT_DESCRIPTION, RENAME_TOOLTIP);
//		putValue(SMALL_ICON, loadIcon(RENAME_ICON)); 
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)Core.getInstance().getView().getTree().getLastSelectedPathComponent();
			int level = currentNode.getLevel();
			
			String newTitle = JOptionPane.showInputDialog(Core.getInstance().getView(), "Rename segment");

			RenameDo rename = new RenameDo();
			
			int id = rename.doAndreturnId(currentNode, level, newTitle);
			
			Viewers.getInstance().rename(level, id, newTitle);
		
			
		} 
		catch (Exception exception) 
		{
			System.out.println(NOTHING_SELECTED_SYSTEM);
		}
	}
}
