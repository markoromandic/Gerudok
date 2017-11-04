package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import app.Core;
import constants.ViewConstants;
import view.menuBar.MenuBar;
/**
 * Glavni View cele aplikacije.
 * @author Marko Romandic
 */
public class View extends JFrame implements ViewConstants
{
	private MenuBar menuBar;
	private ButtonBar buttonBar;
	private Tree tree;
	private TreeStorage treeStorage;

	private JScrollPane scrollPaneTreeDirectory;
	private JScrollPane scrollPaneTreeDraft;
	private JSplitPane splitPaneTreeDesktop;
	private JDesktopPane desktop;

	private JSplitPane splitPaneTreeTree;
	/**
	 * Konstruktir za view.
	 * @author Marko Romandic
	 */
	public View()
	{
		initialize();
	}
	/**
	 * Geter za JDesktopPane
	 * @author Marko Romandic
	 * @return JDesktopPane
	 */
	public JDesktopPane getDesktop()
	{
		return desktop;
	}

	private void initialize()
	{
		initializeWorkspaceTree();
		initializeGui();
	}

	private void initializeGui()
	{
		menuBar = new MenuBar();

		setJMenuBar(menuBar);

		buttonBar = new ButtonBar();

		getContentPane().add(buttonBar, BorderLayout.NORTH);

		desktop = new JDesktopPane()
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};

		scrollPaneTreeDirectory = new JScrollPane(tree);
		
		scrollPaneTreeDraft = new JScrollPane(treeStorage);
		
		splitPaneTreeTree = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPaneTreeDirectory, scrollPaneTreeDraft);

		splitPaneTreeDesktop = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPaneTreeTree, desktop);

		splitPaneTreeDesktop.setDividerLocation(200);

		getContentPane().add(splitPaneTreeDesktop, BorderLayout.CENTER);

		setSize(1500, 1000);

		setLocationRelativeTo(null);

		setTitle(GERUDOK_TITLE);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		ImageIcon iconNotResized = new ImageIcon(GERUDOK_ICON);

		Image iconGeRuDok = iconNotResized.getImage();
		iconGeRuDok = iconGeRuDok.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

		setIconImage(iconGeRuDok);
	}

	private void initializeWorkspaceTree()
	{
		tree = new Tree(Core.getInstance().getModel().getRootNode());
		treeStorage = new TreeStorage(Core.getInstance().getModel().getFreeStorageAsNode());

		ToolTipManager.sharedInstance().registerComponent(tree);
	}

	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	public Tree getTree()
	{
		return tree;
	}
	/**
	 * Ovde ide opis
	 * @author Nemanja
	 * @return
	 */
	public TreeStorage getTreeStorage()
	{
		return treeStorage;
	}

	/**
	 * Menja temu aplikacije, shodno sistemu na uredjaju.
	 * @author Marko Romandic
	 */
	public void systemLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Menja temu na klasicnu swing temu.
	 * @author Marko Romandic
	 * @version 1.0
	 */
	public void crossPlatformLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Metoda pomocu koje uzimam stanje, koje je izabrano za prikazivanje projekata.
	 * @author Marko Romandic
	 * @return state
	 */
	public Integer getViewState()
	{
		return menuBar.getState();
	}
}