package view.maker;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import action.Remove;
import app.Core;
import constants.ViewConstants;
import model.ModelDocument;
import model.ModelProject;
import view.project.ViewProject;
import view.project.document.PanelDocument;
import view.project.document.page.ViewPage;
import view.project.document.page.slot.PaperPage;

/**
 * Klasa za cuvanje referenci na segmente
 * 
 * @author Marko Romandic
 * @version 1.0
 */
public class Viewers implements ViewConstants
{
	private DefaultMutableTreeNode chosenElement = null;
	
	private static Viewers instance;
	
	private ArrayList<ViewProject> trackProjects;
	
	private ArrayList<PanelDocument> trackDocuments;
	
	private ArrayList<ViewPage> trackPages;
	
	private ArrayList<PaperPage> trackSlots;
	
	/**
	 * Singleton patern iskoriscen, radi pristupanja referencama
	 * 
	 * @author Marko Romandic
	 * @version 1.0
	 */
	public static Viewers getInstance()
	{
		if(instance == null)
		{
			instance = new Viewers();
			
			instance.initialize();
		}
		return instance;
	}
	
	private void initialize()
	{
		trackProjects = new ArrayList<>();
		trackDocuments = new ArrayList<>();
		trackPages = new ArrayList<>();
		trackSlots = new ArrayList<>();
	}
	
	public PaperPage getPaperPageUsingID(int id){
		for (int i = 0; i < trackSlots.size(); i++)
		{
			if (trackSlots.get(i).getId()==id)
			{
				return trackSlots.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metoda koja pravi view projekta, kojoj se prosledjuju dva parametra.
	 *
	 * @param title
	 * @param id
	 * @author Marko Romandic
	 * @version 1.0
	 */
	public void initalizeGuiProject(String title, int id)
	{	
		ViewProject viewProject = new ViewProject(title, id);
		
		Core.getInstance().getView().getDesktop().add(viewProject);
		
		trackProjects.add(viewProject);
	
		try
		{
			viewProject.setSelected(true);
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
	
	/**
	 * Metoda koja pravi view dokument u izabranom projektu, 
	 * kojoj se prosledjuju tri parametra.
	 *
	 * @param title
	 * @param parentId
	 * @param childId
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void initializeTabDocument(String title, int parentId, int childId)
	{
		PanelDocument newPanelDocument = new PanelDocument(childId);
		
		for(int i = 0; i < trackProjects.size(); i++)
		{
			if(trackProjects.get(i).getId() == parentId)
			{
				trackProjects.get(i).setDocumentTab(title, newPanelDocument, childId);
				break;
			}
		}
		
		trackDocuments.add(newPanelDocument);
	}
	
	/**
	 * Metoda koja pravi view page u izabranom dokument, 
	 * kojoj se prosledjuju tri parametra.
	 *
	 * @param title
	 * @param parentId
	 * @param childId
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void addPage(int parentId, int childId, String title)
	{
		ViewPage newPage = new ViewPage(childId, title);
		
		for(int i = 0; i < trackDocuments.size(); i++)
		{
			if(trackDocuments.get(i).getId() == parentId)
			{
				trackDocuments.get(i).addPage(newPage);
				break;
			}
		}
		
		for(int i = 0; i < trackProjects.size(); i++)
		{
			for(int j = 0; j < trackProjects.get(i).getViewDocument().getDocumentsIDs().size(); j++)
			{
				if(trackProjects.get(i).getViewDocument().getDocumentsIDs().get(j) == parentId)
				{
					trackProjects.get(i).getViewDocument().setSelectedIndex(j);
				}
			}
		}
		
		trackPages.add(newPage);
	}
	
	/**
	 * Metoda koja pravi view slot na izabranoj stranici, 
	 * kojoj se prosledjuju tri parametra.
	 *
	 * @param picturePath
	 * @param parentId
	 * @param childId
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void addSlot(int parentId, int childId, String picture)
	{
		PaperPage paperPage = new PaperPage(childId, picture);
		
		for(int i = 0; i < trackPages.size(); i++)
		{
			if(trackPages.get(i).getId() == parentId)
			{
				trackPages.get(i).add(paperPage);
				break;
			}
		}
		
		trackSlots.add(paperPage);
	}
	
	/**
	 * Metoda koja pozicionira projekte dijagonalno, horizontalno ili vertikalno 
	 * zavisnosti od prosledjenog, parametra.
	 *
	 * @param state
	 * @author Marko Romandic
	 * @version 1.0
	 */
	public void changeBounds(int state)
	{
		int h = 0, v = 0;
		
		for(int i = 0; i < trackProjects.size(); i++)
		{
			if(state == 0)
			{
				v = 1;
				h = i;
			}
			else if(state == 1)
			{
				h = i;
				v = i;
			}
			else if(state == 2)
			{	
				v = i;
				h = 1;
			}
			
			trackProjects.get(i).setLocation(X + X * h, Y + Y * v);
			
			try
			{
				trackProjects.get(i).setSelected(true);
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * Metoda koja menja naziv segmenta,
	 * kojoj se prosledjuje parametar level,
	 * pomocu kojeg se zna sta se menja.
	 *
	 * @param title
	 * @param level
	 * @param childId
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void rename(int level, int id, String title)
	{
		if(level == 1)
		{
			for(int i = 0; i < trackProjects.size(); i++)
			{
				if(trackProjects.get(i).getId() == id)
				{
					trackProjects.get(i).setTitle(title);
				}
			}
		}
		if(level == 2)
		{
			for(int i = 0; i < trackProjects.size(); i++)
			{
				for(int j = 0; j < trackProjects.get(i).getViewDocument().getDocumentsIDs().size(); j++)
				{
					if(trackProjects.get(i).getViewDocument().getDocumentsIDs().get(j) == id)
						trackProjects.get(i).getViewDocument().setTitleAt(j, title);			
				}
			}
		}
		if(level == 3)
		{
			for(int i = 0; i < trackPages.size(); i++)
			{
				if(trackPages.get(i).getId() == id)
				{
					trackPages.get(i).renameTitle(title);
				}
			}
		}
	
	}
	
	/**
	 * Metoda koja brise segment, 
	 * kojoj se prosledjuju dva parametra, pomocu kojih zna 
	 * sta treba da izbrise.
	 *
	 * @param level
	 * @param id
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void remove(int level, int id)
	{
		if(level == 1)
		{
			for(int i = 0; i < trackProjects.size(); i++)
			{
				if(trackProjects.get(i).getId() == id)
				{
					trackProjects.get(i).dispose();
					trackProjects.remove(i);
				}
			}
		}
		if(level == 2)
		{
			for(int i = 0; i < trackProjects.size(); i++)
			{
				for(int j = 0; j < trackProjects.get(i).getViewDocument().getDocumentsIDs().size(); j++)
				{
					if(trackProjects.get(i).getViewDocument().getDocumentsIDs().get(j) == id)
					{
						trackProjects.get(i).getViewDocument().remove(j);
						trackProjects.get(i).getViewDocument().getDocumentsIDs().remove(j);
					}
				}
			}
			
			for(int i = 0; i < trackDocuments.size(); i++)
			{
				trackDocuments.remove(trackDocuments.get(i));
			}
		}
		if(level == 3)
		{
			for(int i = 0; i < trackPages.size(); i++)
			{
				if(trackPages.get(i).getId() == id)
				{
					ViewPage vpRemove = trackPages.get(i);
					vpRemove.removeAll();
					trackPages.remove(vpRemove);
				}
			}
		}
		if(level == 4)
		{
			for(int i = 0; i < trackSlots.size(); i++)
			{
				if(trackSlots.get(i).getId() == id)
				{
					PaperPage ppRemove = trackSlots.get(i);
					ppRemove.removeAll();
					trackSlots.remove(ppRemove);
				}
			}
		}
	}
	
	/**
	 * Metoda koja izbacuje JDialog gde se ispisuju svi projekti, 
	 * gde biramo u koji projekat cemo da kloniramo dokument.
	 *
	 * @param Projects
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void getShareProject(ArrayList<DefaultMutableTreeNode> allProjects)
	{
		Core.getInstance().getView().setEnabled(false);
		
		JDialog dialogProjects = new JDialog(Core.getInstance().getView(), "Select projects");
		dialogProjects.setLocation(50, 50);
		dialogProjects.setSize(250, 250);
		dialogProjects.setLocationRelativeTo(null);
		dialogProjects.setVisible(true);
		dialogProjects.setLayout(new BorderLayout());
		
		DefaultListModel<DefaultMutableTreeNode> defaultListModelAllProjects = new DefaultListModel<>();
		
		for (DefaultMutableTreeNode project : allProjects)
		{
			defaultListModelAllProjects.addElement(project);
		}
		
		JList<DefaultMutableTreeNode> listProjects = new JList<>(defaultListModelAllProjects);
		
		dialogProjects.add(listProjects, BorderLayout.CENTER);
		
		JButton buttonOk = new JButton("Ok");
		
		dialogProjects.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		dialogProjects.add(buttonOk, BorderLayout.SOUTH);
		
		buttonOk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				chosenElement = listProjects.getSelectedValue();
				dialogProjects.dispose();
				Core.getInstance().getView().setEnabled(true);
				try
				{
					Core.getInstance().getActionManager().getShareDocument().doShare(chosenElement);
				}
				catch (CloneNotSupportedException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		dialogProjects.addWindowListener(new java.awt.event.WindowAdapter() 
		{
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
		        Core.getInstance().getView().setEnabled(true);
		    }
		});
		
	}
	
	/**
	 * Metoda koja vraca dokument iz drafta u workspace.
	 * Prosledjuju se svi projekti radi biranja u koji projekat stavljamo.
	 *
	 * @param projects
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void getChooseParentProject(ArrayList<DefaultMutableTreeNode> allProjects)
	{
		
		Core.getInstance().getView().setEnabled(false);
		
		JDialog dialogProjects = new JDialog(Core.getInstance().getView(),"Select projects");
		dialogProjects.setLocation(50, 50);
		dialogProjects.setSize(250, 250);
		dialogProjects.setLocationRelativeTo(null);
		dialogProjects.setVisible(true);
		dialogProjects.setLayout(new BorderLayout());
		
		DefaultListModel<DefaultMutableTreeNode> defaultListModelAllProjects = new DefaultListModel<>();
		
		for (DefaultMutableTreeNode project : allProjects)
		{
			defaultListModelAllProjects.addElement(project);
		}
		
		JList<DefaultMutableTreeNode> listProjects = new JList<>(defaultListModelAllProjects);
		
		dialogProjects.add(listProjects, BorderLayout.CENTER);
		
		JButton buttonOk = new JButton("Ok");
		
		dialogProjects.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		dialogProjects.add(buttonOk, BorderLayout.SOUTH);
		
		buttonOk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				chosenElement = listProjects.getSelectedValue();
				dialogProjects.dispose();
				Core.getInstance().getView().setEnabled(true);
				Core.getInstance().getActionManager().getChooseParent().doChangeToProject(chosenElement);
			}
		});
		
		dialogProjects.addWindowListener(new java.awt.event.WindowAdapter() 
		{
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) 
		    {
		        Core.getInstance().getView().setEnabled(true);
		    }
		});
		
	}
	
	/**
	 *Metoda koja klonira dokument i sve ispod njega, na drugu referencu,
	 * pomocu javinog interfejsa za kloniranje. Prosledjuju se tri parametra.
	 *
	 * @param title
	 * @param idProject
	 * @param idDocument
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void addSharedDocumentView(int idProject, int idDocument, String title) throws CloneNotSupportedException
	{
		PanelDocument sharedPanelDocument = null;
		for(int i = 0; i < trackDocuments.size(); i++)
		{
			if(trackDocuments.get(i).getId() == idDocument)
			{
				sharedPanelDocument = (PanelDocument)trackDocuments.get(i).clone();
				trackDocuments.add(sharedPanelDocument);
				break;
			}
		}
		
		for(int i = 0; i < trackProjects.size(); i++)
		{
			if(trackProjects.get(i).getId() == idProject)
			{
				trackProjects.get(i).getViewDocument().addTab(title, sharedPanelDocument);
				trackProjects.get(i).getViewDocument().getDocumentsIDs().add(idDocument);
				trackProjects.get(i).getViewDocument().setIconAt(trackProjects.get(i).getViewDocument().getDocumentsIDs().size() - 1, makeIcon(SHARE_DOCUMENT_ICON));
				break;
			}
		}
	}
	
	/**
	 *Metod pravi ikonu
	 *
	 * @param path
	 * @author Marko Romandic
	 * @version 2.0
	 */
	private Icon makeIcon(String path)
	{
		ImageIcon iconNotResized = new ImageIcon(path);
		
		Image imgResizing =	iconNotResized.getImage();
		imgResizing = imgResizing.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(imgResizing);
		
		return icon;
	}
	
	/**
	 *Metoda koja otvara izabrani projekat.
	 *
	 * @param id
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void openSelectedProject(int id)
	{
		for(int i = 0; i < trackProjects.size(); i++)
		{
			if(trackProjects.get(i).getId() == id)
			{
				if(trackProjects.get(i).isVisible())
				{
					try 
					{
						trackProjects.get(i).setSelected(true);
				    } 
					catch (java.beans.PropertyVetoException e2) {}
				}
				else
				{
					trackProjects.get(i).setVisible(true);
				}
			}
		}
	}
	
	/**
	 *Metoda koja pravi JOptionPane, gde se pita da li hocemo da izabrani projekat vratimo u workspace.
	 *
	 * @param parentNode
	 * @param nameWorkspace
	 * @param nameProject
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public int checkForProject(DefaultMutableTreeNode parentNode, String nameWorkspace, String nameProject)
	{
		int option = JOptionPane.showConfirmDialog(Core.getInstance().getView(), "Return " + nameProject + " to " + nameWorkspace, "No", JOptionPane.YES_NO_OPTION);
	      if (option == JOptionPane.YES_OPTION)
	      {
	    	  Core.getInstance().getActionManager().getChooseParent().doChangeToWorkspace(parentNode);
	      }
      
      return option;
	}
	
	/**
	 *Metoda koja usled brisanja workspace-a, zatvara sve projekte.
	 *
	 * @author Marko Romandic
	 * @version 2.0
	 */	
	public void removeWorkspace()
	{
		for(int i = 0; i < trackProjects.size(); i++)
		{
			trackProjects.get(i).setVisible(false);
		}
	}
	
	/**
	 *Metoda koja dodaje dokument iz drafta na projekat i view.
	 *
	 * @param title
	 * @param idProject
	 * @param idDocument
	 * @author Marko Romandic
	 * @version 2.0
	 */
	public void addDrafDocument(String title, int parentId, int childId)
	{
		PanelDocument draft = null;
		for(int i = 0; i < trackDocuments.size(); i++)
		{
			if(trackDocuments.get(i).getId() == childId)
			{
				draft = trackDocuments.get(i);
			}
		}
		for(int i = 0; i < trackProjects.size(); i++)
		{
			if(trackProjects.get(i).getId() == parentId)
			{
				trackProjects.get(i).setDocumentTab(title, draft, childId);
			}
		}
	}
}