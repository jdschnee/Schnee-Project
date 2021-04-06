package com.schnee;

public class Card
{
	private String side1="";
	private String side2="";
	
	public Card(String s1, String s2)
	{
		side1 = s1;
		side2 = s2;
	}
	
	public String getSide(int side)
	{
		if(side==1)
		{
			return side1;
		}
		
		else
		{
			return side2;
		}
	}
	
	public void setSide(int side, String text)
	{
		if(side==1)
		{
			side1 = text;
		}
		else
		{
			side2 = text;
		}
	}
	
	public String toString()
	{
		return side1 + " / " + side2;
	}
}
