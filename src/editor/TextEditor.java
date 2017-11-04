package editor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;

import model.TextObject;


public class TextEditor extends JFrame{
	
	private JTextPane area = new JTextPane();
	private JButton apply = new JButton("Apply");
	TextObject textObj;
	String text;
	
	public TextEditor(TextObject textNew) {
		System.out.println("POZVAN SAM");
		textObj = textNew;
		this.text = textNew.getText();
		area.setText(this.text);
		JScrollPane scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroll,BorderLayout.CENTER);
		area.setPreferredSize(new Dimension(1200,600));
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		
		
		
		JPanel ToolBar = new JPanel();
		ToolBar.setLayout(new BorderLayout());
		
		
		
		
		//Fonts and Size
		JToolBar FontEditTools = new JToolBar();

	    
	    apply.setMaximumSize(new Dimension(60,50));
	    
		FontEditTools.add(Box.createRigidArea(new Dimension(10,10)));
		FontEditTools.add(apply);
		ToolBar.add(FontEditTools, BorderLayout.LINE_START);

		


		
		
		add(ToolBar,BorderLayout.NORTH);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
			}
		});
		pack();
		setVisible(true);
		


		
		
		apply.addActionListener((e)->{
			textObj.setText(area.getText());
			});
		
		
		
	
		
				
	}
	


}
