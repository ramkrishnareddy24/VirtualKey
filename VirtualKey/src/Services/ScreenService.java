package Services;

import Screens.*;

public class ScreenService {
	
	
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
	public static FileOptionsScreen FileOptionScreen = new FileOptionsScreen();
	
	public static Screen CurrentScreen = WelcomeScreen;
	
	public static Screen getCurrentScreen() {
		return CurrentScreen;
	}
	
	public static void setCurrentScreen(Screen currentScreen) {
		CurrentScreen = currentScreen;
	}
}
