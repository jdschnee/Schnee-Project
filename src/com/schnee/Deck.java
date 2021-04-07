package com.schnee;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Deck {

	//max number of cards in a deck set to 100
	public static int DECKMAX = 100;
	
	ArrayList<Card> cards = new ArrayList<Card>();
	int currentCard=0;
	private int cardSide = 1;
	int currentSide = 1;
	String name;
	String fileName;
	private boolean saved = false;
	DefaultListModel listModel = new DefaultListModel();
	
	private static Card ENDOFDECKCARD = new Card("End of Deck", "End of Deck");
	
	Random rand = new Random();
	
	public Deck(ArrayList<Card> cards, String deckName) {
		this.cards = cards;
		name = deckName;
		for (int i=0; i<this.cards.size(); i++) {
			listModel.addElement(this.cards.get(i));
		}
	}
	public Deck(String deckName) {
		name = deckName;
	}
	
	public String toString() {
		return name + " (" + size() + " Cards)";
	}
	
	public int getCardSide()
	{
		return cardSide;
	}
	
	public String[] toSaveState() {
		String[] saveState = new String[2*cards.size()+1];
		saveState[0] = name + "\n";
		for (int i=0; i<cards.size(); i++) {
			saveState[2*i+1] = cards.get(i).getSide(1) + "\n";
			System.out.println("Saving deck[" + (i) + "] at index["+(2*i) + "]");
			saveState[2*i+2] = cards.get(i).getSide(2) + "\n";
		}
		return saveState;
	}
	
	public static Deck constructFromSaveState(String[] saveState) {
		Deck deck;
		try {
			deck = new Deck(saveState[0]);
			for (int i=1; i<saveState.length-1; i+=2) {
				deck.addCard(new Card(saveState[i], saveState[i+1]));
			}
		}catch(ArrayIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Cannot read requested file",
						"File Error", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		deck.setSaved(true);
		return deck;
	}
	
	public boolean isSaved() {return saved;}
	public void setSaved(boolean s) {saved = s;}
	
	public String getName() {
		return name;
	}
	
	public int size() {return cards.size();}
	
	public String getFullPath(String rootPath) {
		if(rootPath.endsWith("/")||rootPath.endsWith("\\")) {
			return rootPath + name + ".deck";
		}
		if(rootPath.contains("/")) {
			return rootPath + "/" + name + ".deck";
		}
		return rootPath + "\\" + name + ".deck";
	}
	
	public void addCard(Card c) {
		cards.add(c);
		listModel.addElement(c);
	}
	public void removeCard(Card c) {
		removeCard(cards.indexOf(c));
	}
	public void removeCard(int index) {
		cards.remove(index);
		listModel.remove(index);
	}
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	public void flipCard() {
		if(currentSide == 1) currentSide = 2;
		else currentSide = 1;
	}
	
	public void toggleCardSide() {
		if(cardSide == 1) cardSide = 2;
		else cardSide = 1;
		currentSide = cardSide;
	}
	
	public void resetCardSide() {
		System.out.println(currentSide);
		System.out.println(cardSide);
		currentSide = cardSide;
		
	}
	
	public Card getCurrentCard() { 
		if(currentCard == -1 || cards.size()==0) return ENDOFDECKCARD;
		return cards.get(currentCard);
	}

	public String getCurrentCardText() {
		return getCurrentCard().getSide(currentSide);
	}
	
	public void goToNextCard() {
		currentCard++;
		if(currentCard == cards.size()) {
			currentCard = -1;
		}
		currentSide = getCardSide();
	}
	public void goToPreviousCard() {
		currentCard--;
		if(currentCard < 0) currentCard = -1;
		currentSide = getCardSide();
	}
	public void goToCard(int index) {
		currentCard = index;
		currentSide = getCardSide();
	}
	
	public JList getList() {
		
		JList list = new JList(listModel);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return list;
	}
}