package com.schnee;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class CardEditor extends JPanel {

	Deck deck;
	JList cardList;
	JTextField side1, side2;
	boolean locked = false;
	
	public CardEditor() {
		String name=null;
		while(name==null) {
			name = JOptionPane.showInputDialog("Deck Name:");
		}
		deck = new Deck(name);
		cardList = deck.getList();
		createGUI();
	}
	public CardEditor(boolean empty) {}
	public CardEditor(Deck deck) {
		this.deck = deck;
		cardList = deck.getList();
		createGUI();
	}
	
	public void setDeck(Deck d) {
		deck = d;
		cardList = deck.getList();
		removeAll();
		createGUI();
		setVisible(false);
		setVisible(true);
	}
	public Deck getDeck() {
		return deck;
	}
	
	public void createGUI() {
		cardList.addListSelectionListener(new LSL());
		JPanel buttonPanel = new JPanel();
		JButton newButton = new JButton("New Card");
		newButton.setMnemonic('n');
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deck.addCard(new Card("New Card Front", "New Card Back"));
				cardList.setSelectedIndex(deck.size()-1);
				side1.requestFocusInWindow();
			}
		});
		buttonPanel.add(newButton);
		JButton deleteButton = new JButton("Delete");
		deleteButton.setMnemonic('d');
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = cardList.getSelectedIndex();
				if(selected != -1) { 
					deck.removeCard(selected);
					locked = true;
					if(selected<deck.size()) cardList.setSelectedIndex(selected);
					else cardList.setSelectedIndex(deck.size()-1);
				}
			}
		});
		buttonPanel.add(deleteButton);
		
		JScrollPane listPane = new JScrollPane(cardList);
		JPanel displayPanel = new JPanel();
		side1 = new JTextField(10);
		side1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				side2.requestFocusInWindow();
			}
		});
		side2 = new JTextField(10);
		side2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index;
				if ((index = cardList.getSelectedIndex())!=-1) { 
					deck.getCard(index).setSide(1, side1.getText());
					deck.getCard(index).setSide(2, side2.getText());
				}
			}
		});
		displayPanel.add(new JLabel("Side 1:"), BorderLayout.NORTH);
		displayPanel.add(side1, BorderLayout.NORTH);
		displayPanel.add(new JLabel("Side 2:"), BorderLayout.SOUTH);
		displayPanel.add(side2, BorderLayout.SOUTH);
		JSplitPane cardPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPane, displayPanel); 
		
		
		
		add(buttonPanel, BorderLayout.NORTH); 
		add(cardPane, BorderLayout.CENTER);
		setFocusable(true);
		setVisible(true);
	}
	
	public void cleanUp() {
		if (cardList.getSelectedIndex()!=-1) {
			deck.getCard(cardList.getSelectedIndex()).setSide(1,
					side1.getText());
			deck.getCard(cardList.getSelectedIndex()).setSide(2,
					side2.getText());
		}
	}
	
	private class LSL implements ListSelectionListener {

		private int previousSelection = -1;
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			int index;
			if (!e.getValueIsAdjusting()) { 
				if ((index = cardList.getSelectedIndex())!=-1) {
					if (side1.getText() != "" && side2.getText() != "" 
							&& previousSelection != -1 && previousSelection<deck.size() && !locked) {
						deck.getCard(previousSelection).setSide(1,
								side1.getText());
						deck.getCard(previousSelection).setSide(2,
								side2.getText());
					}
					side1.setText(deck.getCard(index).getSide(1));
					side2.setText(deck.getCard(index).getSide(2));
					previousSelection = cardList.getSelectedIndex();
					locked = false;
				}
			}
			
		}
		
	}
}