package Screens;

import java.util.*;

import Services.DirectoryService;
import Services.ScreenService;

public class WelcomeScreen implements Screen {
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
		System.out.println("\n");
		Show();
	}
	
	@Override
	public void Show() {
		System.out.println("Main Menu");
		for(String s:options) {
			System.out.println(s);
		}
	}
	
	public void GetUserInput() {
		int selectedOption=0;
		while((selectedOption=this.getOption())!=4) {
			this.NavigateOption(selectedOption);
		}
	}
	
	@Override
	public void NavigateOption(int option) {
		switch(option) {
		case 1:
			this.showFiles();
			this.Show();
			break;
			
		case 2:
			ScreenService.setCurrentScreen(ScreenService.FileOptionScreen);
			ScreenService.getCurrentScreen().Show();
			ScreenService.getCurrentScreen().GetUserInput();
			break;
		case 3:
			System.out.println("Thanks for using LockerMe.com");
			System.exit(0);
		default: System.out.println("Invalid Option");
		}
	}
	
	public void showFiles() {
		System.out.println("List of Files:");
		DirectoryService.PrintFiles();
		
		
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
