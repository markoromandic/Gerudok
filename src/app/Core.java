package app;

import javax.swing.JFrame;

import action.ActionManager;
import model.Model;
import view.View;
import work.TypeForSlot;
/**
 * Klasa koja sadrzi reference ka controleru, view i modelu.
 * Singleton
 * MVC je zadrzan kroz ceo projekat
 *@author Nemanja
 * 
 */
public class Core extends JFrame
{
	private static Core instance = null;
	
	private ActionManager actionManager;
	
	private View view;
	private Model model;
	
	public static Core getInstance()
	{
		if(instance == null)
		{
			instance = new Core();
			
			instance.initialize();
		}
		return instance;
	}
	
	private void initialize()
	{
		actionManager = new ActionManager();
		model = new Model();
		view = new View();
	}
	
	public ActionManager getActionManager()
	{
		return actionManager;
	}

	public View getView()
	{
		return view;
	}

	public Model getModel() {
		return model;
	}
	
}