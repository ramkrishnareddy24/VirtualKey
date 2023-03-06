package Screens;

import java.util.*;

public class WelcomeScreen {
	private String welcomeText = "Welcome to VirtualKey LockerMe.com";
	private String developerName = "Ramakrishna G. Kannari";
	
	private ArrayList<String> options = new ArrayList<String>();
	
	public WelcomeScreen() {
		options.add("1. Show Files");
		options.add("2. Show File Options Menu");
		options.add("3. Quit");
	}
	
	public void intoWelcomeScreen() {
		System.out.println(welcomeText);
		System.out.println(developerName);
		System.out.println();
		Show();
	}

	public void Show() {
		for(String s:options) {
			System.out.println(s);
		}
	}
	
	public void GetUserInput() {
		int selectedOption=0;
		while((selectedOption=this.getOption())!=3) {
			this.NavigateOption(selectedOption);
		}
	}
	
	public void NavigateOption(int option) {
		switch(option) {
		case 1:
//			this.showFiles();
			this.Show();
			break;
			
		case 2:
			break;
		default: System.out.println("Invalid Option");
		}
	}
	
	private int getOption() {
		int option=0;
		Scanner sc = new Scanner(System.in);
		try {
			option = sc.nextInt();
		}
		catch(InputMismatchException e) {}
		return option;
	}
	
}
