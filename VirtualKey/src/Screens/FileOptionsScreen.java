package Screens;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entities.Directory;
import Services.ScreenService;

public class FileOptionsScreen implements Screen{
	
	private Directory dir = new Directory();
	
	private ArrayList<String> options = new ArrayList<String>();
	
	public FileOptionsScreen(){
		options.add("1. Add a File.");
		options.add("2. Delete a File");
		options.add("3. Search a File");
		options.add("4. Return to Main Menu");
	}
	
	@Override
	public void Show() {
		System.out.println("File Options Menu:");
		for(String s:options)
			System.out.println(s);
	}
	
	public void GetUserInput() {
		int selectedOption;
		while((selectedOption = this.getOption())!=5) {
			this.NavigateOption(selectedOption);
		}
	}

	@Override
	public void NavigateOption(int option) {
		switch(option) {
		case 1:
			this.AddFile();
			this.Show();
			break;
		case 2:
			this.DeleteFile();
			this.Show();
			break;
		case 3:
			this.SearchFile();
			this.Show();
			break;
		case 4:
			ScreenService.setCurrentScreen(ScreenService.WelcomeScreen);
			ScreenService.getCurrentScreen().Show();
			ScreenService.getCurrentScreen().GetUserInput();
			break;
		default:
			System.out.println("Invalid Option");
			break;
		}
	}

	

	public void AddFile() {
		System.out.println("Please enter the filename to create:");
		
		String fileName = this.getInputString();
		
		System.out.println("Youre adding file named: "+fileName);
		
		try {
			Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
			
			File file = new File(dir.getName()+fileName);
			
			if(file.createNewFile()) {
				System.out.println("File created: "+file.getName());
				dir.getFiles().add(file);
			}
			else
			{
				System.out.println("File already exists.");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void DeleteFile() {
		System.out.println("Please enter the filename to delete");
		
		String fileName = this.getInputString();
		
		System.out.println("Youre deleting file named :"+fileName);
		
		Path path = FileSystems.getDefault().getPath(Directory.name+fileName).toAbsolutePath();
		File file = path.toFile();
		
		if(file.delete()) {
			System.out.println("Deleted File: "+file.getName());
			dir.getFiles().remove(file);
		}
		else
		{
			System.out.println("Failed to delete the file: "+fileName+", file Not Found");
		}
	}

	public void SearchFile() {
		Boolean found = false;
		
		System.out.println("Please enter the filename search");
		String fileName = this.getInputString();
		System.out.println("Youre searching file named :"+fileName);
		
		ArrayList<File> files = dir.getFiles();
		
		for(int i=0;i<files.size();i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("File Found :"+fileName);
				found = true;
			}
		}
		if(found==false)
			System.out.println("File Does Not Exist.");
	}
	
	private String getInputString() {
		Scanner sc = new Scanner(System.in);
		return(sc.nextLine());
	}

	

	private int getOption() {
		Scanner sc = new Scanner(System.in);
		
		int returnOption = 0;
		try {
			returnOption = sc.nextInt();
		}
		catch(InputMismatchException e) {}
		return returnOption;
	}
	
}
