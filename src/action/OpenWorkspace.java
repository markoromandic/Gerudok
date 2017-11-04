package action;

import java.awt.event.ActionEvent;

import constants.IconPaths;
import constants.TitleTexts;
import constants.ViewConstants;
/**
 * Akcija koja ucitava radni prostor
 * @author Nemanja
 */
public class OpenWorkspace extends AbstractEditorAction implements ViewConstants
{
	public OpenWorkspace()
	{
		putValue(NAME, SWITCH_WORKSPACE_TITLE);
		putValue(SHORT_DESCRIPTION, SWITCH_WORKSPACE_TOOLTIP);
//		putValue(SMALL_ICON, loadIcon(WORKSPACE_ICON)); 
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
//		JEREMIC RADI AKCIJE
	}
}