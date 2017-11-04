package work;
/**
 * Ovde ide opis 
 * @author Nemanja
 */
public class CreateName {

	private static int workspaceName = 0, projectNumber = 0, documentName = 0, pageNumber = 0, slotNumber = 0, elementNumber = 0;
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public static String getWorkspaceName(){
		return "Workspace " + workspaceName++;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public static String getProjectName(){
		return "Project "+ projectNumber++;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public static String getDocumentName(){
		return "Document " + documentName++;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public static String getPageName(){
		return "Page "+ pageNumber++;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public static String getSlotName(){
		return "Slot "+ slotNumber++;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public static String getElementName(){
		return "Element "+ elementNumber++;
	}
}
