package com.schnee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardViewer extends JPanel implements ActionListener{

	Deck deck=null;
	Font font = new Font("MyFont", Font.PLAIN, 80);
	JLabel cardText = new JLabel("", JLabel.CENTER);
	
	int cardsFlipped = 0;
	String flippedText = "Cards Flipped: ";
	JLabel flippedLabel = new JLabel(flippedText + cardsFlipped);
	
	JButton flipButton, nextButton, prevButton;
	boolean loaded = false;
	
	Timer timer = new Timer(1000, this);
	JTextField timeText = new JTextField("0:00");
	JButton timeStart = new JButton("Start");
	JButton timeStop = new JButton("Stop");
	JButton timeButton = new JButton("Start");
	int time = 0;
	int timeMode = 1;
	
	public CardViewer() {
		createGUI();
		setEnabledAll(false);
	}
	public CardViewer(Deck d) {
		deck = d;
		loaded = true;
		createGUI();
		setEnabledAll(true);
		displayCard();
	}
	
	public void setEnabledAll(boolean b) {
		flipButton.setEnabled(b);
		nextButton.setEnabled(b);
		prevButton.setEnabled(b);
	}
	
	public void adjustCardsFlipped(int d) {
		cardsFlipped += d;
		flippedLabel.setText(flippedText + cardsFlipped);
	}
	
	public void createGUI() {
		cardText.setFont(font);
		JPanel buttonPanel = new JPanel();
		//JPanel buttonPanel2 = new JPanel();
		JPanel displayPanel = new JPanel();
		JPanel timePanel = new JPanel();
		JPanel topButtons = new JPanel();
		JPanel bottomButtons = new JPanel();
		
		buttonPanel.setLayout(new BorderLayout());
		
		flipButton = new JButton("Flip");
		flipButton.setFocusable(false);
		flipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deck.flipCard();
				displayCard();
			}
		});
		topButtons.add(flipButton);
		nextButton = new JButton("Next");
		nextButton.setFocusable(false);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deck.goToNextCard();
				displayCard();
				adjustCardsFlipped(1);
			}
		});
		topButtons.add(nextButton);

		prevButton = new JButton("Previous");
		prevButton.setFocusable(false);
		prevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deck.goToPreviousCard();
				displayCard();
				adjustCardsFlipped(-1);
			}
		});
		bottomButtons.add(prevButton);


		buttonPanel.add(topButtons, BorderLayout.NORTH);
		buttonPanel.add(bottomButtons, BorderLayout.SOUTH);
		
		cardText.setPreferredSize(new Dimension(600, 200));
		
		timeText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parseTime(timeText.getText());
			}
		});
		System.out.println(timeText.getText().charAt(1));
		JRadioButton timerOption = new JRadioButton("Timer");
		timerOption.setActionCommand("Timer");
		timerOption.addActionListener(this);
		timerOption.setFocusable(false);
		JRadioButton stopwatchOption = new JRadioButton("Stopwatch");
		stopwatchOption.setActionCommand("Stopwatch");
		stopwatchOption.setSelected(true);
		stopwatchOption.setFocusable(false);
		stopwatchOption.addActionListener(this);
		ButtonGroup timeGroup = new ButtonGroup();
		timeGroup.add(timerOption);
		timeGroup.add(stopwatchOption);
		
		timeButton.setActionCommand("StartStop");
		timeButton.setFocusable(false);
		timeButton.addActionListener(this);
		timer.setActionCommand("Increment_Timer");
		timePanel.add(timerOption);
		timePanel.add(stopwatchOption);
		timePanel.add(timeText);
		timePanel.add(timeButton);
		timePanel.add(flippedLabel);
		
		add(timePanel, BorderLayout.NORTH);
		displayPanel.add(cardText, BorderLayout.CENTER);
		add(displayPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		addKeyListener(new KL());
		setFocusable(true);
	}
	
	public void setDeck(Deck d) {
		deck = d;
		loaded = true;
		displayCard();
		setEnabledAll(true);
	}
	public Deck getDeck() {
		return deck;
	}
	
	public void displayCard() {
		cardText.setText(deck.getCurrentCardText());
	}
	
	public String tick() {
		time += timeMode;
		if(time<0) {
			time = 0;
			setTimerRunning(false);
		}
		int h = time / 60;
		int m = time % 60;
		String min = Integer.toString(m);
		if(min.length()<2) min = "0" + min;
		return h + ":" + min;
	}
	
	public void parseTime(String t) {
		int i = t.indexOf(":");
		if(i == -1) {
			timeText.setText("0:00");
			time = 0;
			return;
		}
		int h = Integer.parseInt(t.substring(0, i));
		int m = Integer.parseInt(t.substring(i+1));
		time = h*60 + m;
	}
	
	public void setTimerRunning(boolean b) {
		if(!b) {
			timer.stop();
			timeButton.setText("Start");
		}
		else {
			parseTime(timeText.getText());
			timer.start();
			timeButton.setText("Stop ");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Timer")) timeMode = -1;
		else if(e.getActionCommand().equals("Stopwatch")) timeMode = 1;
		else if(e.getActionCommand().equals("StartStop")) {
			if(timer.isRunning()) setTimerRunning(false);
			else setTimerRunning(true);
		}
		else timeText.setText(tick());
	}
	
	private class KL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			System.out.println("Key Typed");
			int key = e.getKeyCode();

		}
	}
	

}