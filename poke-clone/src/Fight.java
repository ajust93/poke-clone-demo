import java.util.Random;
import java.util.Scanner;

public class Fight {
	private static int activeAnimalHP;
	private static int wildAnimalHP;
	private static String wildAnimalName;
	private static boolean didPlayerWin = false;
	
	public static void fightWildAnimal(Scanner scanner, Player player) {
		Animal wildAnimal = Animal.findRandomAnimal();
		wildAnimalName = wildAnimal.getName();
		System.out.println("A wild " + wildAnimalName + " appeared. Battle starts now!");
		Animal activeAnimal = player.animalTeam[0];
		activeAnimalHP = activeAnimal.getBaseHP();
		wildAnimalHP = wildAnimal.getBaseHP();
		fasterAnimalStartsAttack(activeAnimal, wildAnimal, scanner);
		if (didPlayerWin) player.gotNewAnimal(wildAnimal);
		didPlayerWin = false;
	}
	
	public static void fasterAnimalStartsAttack(Animal activeAnimal, Animal wildAnimal, Scanner scanner) {
		if (activeAnimal.getBaseSpeed() >= wildAnimal.getBaseSpeed()) animalAttacks(false, scanner, activeAnimal, wildAnimal);
		else animalAttacks(true, scanner, wildAnimal, activeAnimal);
	}
	
	public static void animalAttacks(boolean isWildAnimalAttacking, Scanner scanner, Animal attacker, Animal defender) {
		if (isWildAnimalAttacking) {
			Random random = new Random();
			int IndexOfRandomSkill = random.nextInt(4);
			Skill skill = Skill.values()[IndexOfRandomSkill];
			System.out.print("Wild " + attacker.getName() + " uses " + skill.getName() + ". ");
			int damage = calculateDamage(attacker, skill, defender);
			activeAnimalHP -= damage;
		} else {
			System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
			System.out.println("HP of your animal: " + activeAnimalHP + "/" + attacker.getBaseHP());
			System.out.println("HP of wild animal: " + wildAnimalHP + "/" + defender.getBaseHP());
			System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
			System.out.println("Pick a skill to use by choosing the corresponding number:");
			Skill.printAllSkills();
			int indexOfSkill = scanner.nextInt() - 1;
			Skill skill = Skill.values()[indexOfSkill];
			System.out.print("Your " + attacker.getName() + " uses " + skill.getName() + ". ");
			int damage = calculateDamage(attacker, skill, defender);
			wildAnimalHP -= damage;
		}
		if (isFightOver()) {
			determineWinner();
		} else {
			animalAttacks(!isWildAnimalAttacking, scanner, defender, attacker);
		}
	}
	
	public static int calculateDamage(Animal attacker, Skill skill, Animal defender) {
		int damage = 0;
		double chanceToMissSkill = Math.random();
		boolean skillDidMiss = chanceToMissSkill > skill.getAccuracy();
		if (skillDidMiss) {
			System.out.println("Attack missed! No damage was dealt.");
			return 0;
		}
		damage = (attacker.getBaseAtk() + skill.getDamage()) - defender.getBaseDef();
		System.out.println(damage + " damage was dealt.");
		return damage;
	}
	
	public static boolean isFightOver() {
		if (wildAnimalHP <= 0 || activeAnimalHP <= 0) return true;
		return false;
	}
	
	public static void determineWinner() {
		if (wildAnimalHP <= 0) {
			didPlayerWin = true;
			System.out.printf("You won! %s got caught and is now your companion. \n", wildAnimalName);
		} else {
			System.out.println("You lost and fled from the battle. ");
		}
		System.out.println("Some time has passed and all animals were healed in the meantime.");
	}

}
