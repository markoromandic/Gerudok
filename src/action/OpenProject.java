package action;

import java.awt.event.ActionEvent;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Akcija koja otvara projekat
 * @author Nemanja
 */
public class OpenProject extends AbstractEditorAction implements ViewConstants
{
	public OpenProject()
	{
		putValue(NAME, OPEN_PROJECT_TITLE);
		putValue(SHORT_DESCRIPTION, "Open existing project");
//		putValue(SMALL_ICON, loadIcon(PROJECT_ICON)); 
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
	}
}
