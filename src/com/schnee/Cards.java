package com.schnee;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Cards extends JFrame {


	private boolean isViewer = false;
	private boolean isEditor = false;
	private CardEditor editor;
	private CardViewer viewer;
	private static String title = "StudySmart";
	
	Deck mainDeck;
	JFileChooser fileChooser = new JFileChooser();
	
	
	public Cards() {
		super(title);
		setSize(700, 410);
		add(createGUI(), BorderLayout.NORTH);
		viewer = new CardViewer();
		editor = new CardEditor(true);
		loadViewer();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setTitle(String title)
	{
		super.setTitle(title);
	}
	
	public void updateTitle()
	{
		setTitle(mainDeck.toString() + " - " + title);
	}
	
	public void refresh()
	{
		super.setVisible(true);
	}
	
	public JMenuBar createGUI() {
		JMenuBar bar = new JMenuBar();	
		JMenu file = new JMenu("File");
		JMenu view = new JMenu("View");
		JMenuItem loadItem = new JMenuItem("Load Deck");
		loadItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int retVal = fileChooser.showOpenDialog(Cards.this);
				if(retVal == JFileChooser.APPROVE_OPTION) {
					if (mainDeck != null) {
						viewer.setDeck(mainDeck);
						editor.setDeck(mainDeck);
						setTitle(mainDeck.toString()+ " - " + title);
					}
				}

			}
		});
		file.add(loadItem);
		JMenuItem newItem = new JMenuItem("New Deck");
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadEditorNew();
			}
		});
		file.add(newItem);
		JMenuItem editItem = new JMenuItem("Editor");
		editItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadEditor();
			}
		});
		view.add(editItem);
		JMenuItem viewItem = new JMenuItem("Viewer");
		viewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadViewer();
			}
		});
		view.add(viewItem);

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.exit(0);
			}
		});
		file.add(exitItem);
		
		bar.add(file);
		bar.add(view);
		return bar;
	}
	
	public void loadViewer() {
		if (isEditor) {
			editor.cleanUp();
			mainDeck = editor.getDeck();
			remove(editor); 
			updateTitle();
		}
		if (mainDeck != null) {
			viewer = new CardViewer(mainDeck);
		}
		else viewer = new CardViewer();
		
		add(viewer, BorderLayout.CENTER);
		isViewer = true;
		isEditor = false;
		setVisible(true);
	}
	
	public void loadEditor() {
		if (mainDeck!=null) {
			editor = new CardEditor(mainDeck);
		}
		else {editor = new CardEditor();}
		if(isViewer) {
			remove(viewer);
		}
		else {
			remove(editor); 
		}
		add(editor, BorderLayout.CENTER);
		isEditor = true;
		isViewer = false;
		this.setVisible(true);
	}
	public void loadEditorNew()
	{
		editor = new CardEditor();
		if(isViewer) {
			remove(viewer); 
		}
		add(editor, BorderLayout.CENTER);
		isViewer = false;
		isEditor = true;
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new Cards();
	}

}