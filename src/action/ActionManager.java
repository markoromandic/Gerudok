package action;
/**
 * Ovde ide opis 
 * @author Nemanja
 */
public class ActionManager
{
	private SaveProject saveProject;
	private OpenProject openProject;
	private Undo undo;
	private Redo redo;
	private Copy copy;
	private Paste paste;
	private OpenWorkspace openWorkspace;
	private CloseApp closeApp;
	private SaveWorkspace saveWorkspace;
	private ShareDocument shareDocument;
	private Remove remove;
	private SystemLookAndFeel systemLookAndFeel;
	private SwingLookAndFeel swingLookAndFeel;
	private Create create;
	private VerticalView verticalView;
	private HorizontalView horizontalView;
	private DiagonalView diagonalView;
	private OpenHelp openHelp;
	private OpenAbout openAbout;
	private Cut cut;
	private Rename rename;
	private ChooseParent chooseParent;
	private OpenViewProject openViewProject;
	private Edit edit;
	/**
	 * Klasa koja cuva reference ka svim akcijama
	 * @author Nemanja
	 */
	public ActionManager()
	{
		systemLookAndFeel = new SystemLookAndFeel();
		swingLookAndFeel = new SwingLookAndFeel();
		openProject = new OpenProject();
		saveProject = new SaveProject();
		undo = new Undo();
		redo = new Redo();
		copy = new Copy();
		paste = new Paste();
		openWorkspace = new OpenWorkspace();
		closeApp = new CloseApp();
		saveWorkspace = new SaveWorkspace();
		shareDocument = new ShareDocument();
		remove = new Remove();
		create = new Create();
		horizontalView = new HorizontalView();
		diagonalView = new DiagonalView();
		verticalView = new VerticalView();
		openHelp = new OpenHelp();
		openAbout = new OpenAbout();
		cut = new Cut();
		rename = new Rename();
		chooseParent = new ChooseParent();
		openViewProject = new OpenViewProject();
		edit=new Edit();
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public OpenViewProject getOpenViewProject()
	{
		return openViewProject;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public Cut getCut()
	{
		return cut;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public OpenAbout getOpenAbout()
	{
		return openAbout;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public OpenHelp getOpenHelp()
	{
		return openHelp;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public VerticalView getVerticalView()
	{
		return verticalView;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public HorizontalView getHorizontalView()
	{
		return horizontalView;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public DiagonalView getDiagonalView()
	{
		return diagonalView;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public SystemLookAndFeel getSystemLookAndFeel()
	{
		return systemLookAndFeel;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public SwingLookAndFeel getSwingLookAndFeel()
	{
		return swingLookAndFeel;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public Remove getRemove()
	{
		return remove;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public ShareDocument getShareDocument()
	{
		return shareDocument;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public CloseApp getCloseApp()
	{
		return closeApp;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public OpenWorkspace getOpenWorkspace()
	{
		return openWorkspace;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public SaveWorkspace getSaveWorkspace()
	{
		return saveWorkspace;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public SaveProject getSaveProject()
	{
		return saveProject;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public OpenProject getOpenProject()
	{
		return openProject;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public Undo getUndo()
	{
		return undo;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public Redo getRedo()
	{
		return redo;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public Copy getCopy()
	{
		return copy;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public Paste getPaste()
	{
		return paste;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public Create getCreate(){
		return create;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public Rename getRename(){
		return rename;
	}
	/**
	 * Ovde ide opis 
	 * @author Nemanja
	 * @return
	 */
	public ChooseParent getChooseParent(){
		return chooseParent;
	}
	public Edit getEdit(){
		return edit;
	}
	
}
