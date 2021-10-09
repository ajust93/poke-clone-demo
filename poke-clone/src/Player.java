import java.util.ArrayList;

public class Player {
	private final String name;
	Animal[] animalTeam = new Animal[6];
	private int teamSize = 0;
	ArrayList<Animal> animalStorage = new ArrayList<>();
	
	Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTeamSize() {
		return teamSize;
	}
	
	public void printPlayerData() {
		System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
		System.out.printf(
			"Name: %s \n%d/6 animal(s) in team \n%d animal(s) in storage \n",
			name, teamSize, animalStorage.size()
		);
	}
	
	public void printTeam() {
		System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
		System.out.println("Current team:");
		for (int i = 0; i < teamSize; i++) {
			System.out.println((i+1) + " " + animalTeam[i].getName());
		}
	}
	
	public void printStorage() {
		System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
		System.out.println("Storage:");
		if (animalStorage.size() == 0) {
			System.out.println("Currently no animals in your storage.");
		} else {
			int count = 1;
			for (Animal animal : animalStorage) {
				System.out.println(count + " " + animal.getName());
				count++;
			}
		}
	}
	
	public void gotNewAnimal(Animal animal) {
		if (teamSize < 6) {
			animalTeam[teamSize] = animal;
			teamSize++;
		} else {
			animalStorage.add(animal);
		}
	}
	
	// TODO: currently not an option to pick in the game, but easy to implement (might have minor bug)
	public void changeTeamOrderOfTwoAnimals(int position1, int position2) {
		if ((position1 >= 0 && position2 >= 0) && (position1 < 6 && position2 < 6)) {
			Animal tmp = animalTeam[position1];
			animalTeam[position1] = animalTeam[position2];
			animalTeam[position2] = tmp;
		} else {
			System.out.println("Invalid input. Only 0 (first animal) to 5 (last animal) is possible.");
			printTeam();
		}
	}
	
	// TODO: currently not an option to pick in the game, but easy to implement (might have minor bug)
	public void replaceAnimalInTeamWithStorage(int positionTeam, int positionStorage) {
		if ((positionTeam < teamSize) && (positionStorage < animalStorage.size()) 
			&& (positionTeam >= 0) && (positionStorage >= 0)) {
			
		} else {
			System.out.println("Invalid input. Please try again.");
			printTeam();
			printStorage();
		}
	}
	
}