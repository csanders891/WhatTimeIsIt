package time;

import java.util.Scanner;

public class WhatTimeIsIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a time (24 hour format)");
		String time = keyboard.nextLine();
		int Time = Integer.parseInt(time);
		
		//length must be 3 or 4 digits
		while(time.length() < 3 || time.length() > 4)
		{
			System.out.println("Invalid entry.  Try again");
			time = keyboard.nextLine();
			Time = Integer.parseInt(time);
		}
	
		//time cannot be a negative or after 2539 (there is no 2400 hours); goes back to 000 at midnight)
		while(Time < 0 || Time > 2359)
		{
			System.out.println("Invalid entry.  Try again");
			time = keyboard.nextLine();
			Time = Integer.parseInt(time);
		}
	
		int hour = 0;
		
	
		//midnight
		if(Time < 100)	//before 1am
			hour = 12;
				
		else 
			hour = Time / 100;
				
		int minute = (Time % 1000) % 100;
		
		
		//minute must be between 00-59
		while (hour < 0  || hour > 23 || minute < 0 || minute > 59)
		{
			System.out.println("Invalid entry.  Try again");
			time = keyboard.nextLine();
			Time = Integer.parseInt(time);
		
			while(time.length() < 3 || time.length() > 4)
			{
				System.out.println("Invalid entry.  Try again");
				time = keyboard.nextLine();
				Time = Integer.parseInt(time);
			}
			
			if(Time < 100)	
				hour = 12;
			
			else
				hour = Time / 100;
			minute = (Time % 1000) % 100;
			
		}
	
		//1PM or later
		if(hour > 12)
			hour-=12;
		
		
		String am_or_pm;
		
		//morning
		if(Time < 1200)
		am_or_pm = "AM"; 
		
		//afternoon/evening
		else
			am_or_pm = "PM";

		//top of the hour
		if(minute == 0)
			System.out.println(hour + ":" + minute + "" + minute + " " + am_or_pm);
			
		else
		{
			if(minute < 10)
				System.out.println(hour + ":0" + minute + " " + am_or_pm);
			
			else
				System.out.println(hour + ":" + minute + " " + am_or_pm);
			
		}
			
	
			
	}

}
