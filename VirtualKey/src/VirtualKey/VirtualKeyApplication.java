package VirtualKey;

import Screens.WelcomeScreen;

public class VirtualKeyApplication {
	public static void main(String[] args) {
		WelcomeScreen welcomeScreen = new WelcomeScreen();
		welcomeScreen.intoWelcomeScreen();
//		welcomeScreen.Show();
		welcomeScreen.GetUserInput();

	}
}
