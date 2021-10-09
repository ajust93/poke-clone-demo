import java.util.Scanner;

public class Game {
	public static boolean didPlayerCloseGame = false;
	
	public static Player createPlayer(Scanner scanner) {
		String playerName = scanner.nextLine();
		System.out.printf("Nice to meet you, %s! \n", playerName);
		Player player = new Player(playerName);
		return player;
	}
	
	public static void showOptions() {
		System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
		System.out.println("Pick one option by choosing the corresponding number: \n"
			+ "1 Look for animals and start a fight. \n"
			+ "2 Show data about all animals. \n"
			+ "3 Show data about current player. \n"
			+ "4 Show current animals in your team. \n"
			+ "5 Show animals in your storage. \n"
			+ "10 Close game.");
	}
	
	public static void chooseOption(Scanner scanner, Player player) {
		int option = scanner.nextInt();
		switch(option) {
		case 1: Fight.fightWildAnimal(scanner, player); break;
		case 2: Animal.printAllAnimalData(); break;
		case 3: player.printPlayerData(); break;
		case 4: player.printTeam(); break;
		case 5: player.printStorage(); break;
		case 10: Game.didPlayerCloseGame = true; break;
		default:
			System.out.println("Invalid option. Choose again.");
			chooseOption(scanner, player);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome! What is your name?");
		Player player = createPlayer(scanner);
		System.out.println(
			"I will help you survive in this cruel world. Take this animal as a present. \n"
			+ "It's a " + Animal.PIG.getName() + " and it will protect you in fights. \n"
			+ "Later on you will be able to catch more animals by defeating them. \n"
			+ "It was a pleasure to meet you. Good luck!");
		player.gotNewAnimal(Animal.PIG);
		
		while (true) {
			showOptions();
			System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
			chooseOption(scanner, player);
			if (didPlayerCloseGame) {
				System.out.println("Game closed. Thanks for playing!");
				break;
			}
		}
		scanner.close();
	}
}

// TODO: JUnit test cases (TDD important for quality software)