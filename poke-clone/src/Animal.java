import java.util.Random;

public enum Animal {
	PIG(1, "Pig", 50, 15, 20, 10),
	HORSE(2, "Horse", 55, 20, 20, 15),
	TIGER(3, "Tiger", 60, 30, 15, 20),
	WOLF(4, "Wolf", 55, 15, 20, 15),
	DONKEY(5, "Donkey", 45, 15, 20, 10),
	MONKEY(6, "Monkey", 65, 20, 15, 10),
	ZEBRA(7, "Zebra", 55, 20, 20, 15),
	LION(8, "Lion", 60, 15, 30, 20),
	PANDA(9, "Panda", 55, 25, 20, 5),
	BEAR(10, "Bear", 60, 15, 25, 5);
	
	private final int id;
	private final String name;
	private final int baseHP;
	private final int baseAtk;
	private final int baseDef;
	private final int baseSpeed;
	
	private Animal (int id, String name, int baseHP, int baseAtk, int baseDef, int baseSpeed) {
		this.id = id;
		this.name = name;
		this.baseHP = baseHP;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
		this.baseSpeed = baseSpeed;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBaseHP() {
		return baseHP;
	}
	
	public int getBaseAtk() {
		return baseAtk;
	}
	
	public int getBaseDef() {
		return baseDef;
	}
	
	public int getBaseSpeed() {
		return baseSpeed;
	}
	
	public static Animal findRandomAnimal() {
		Random random = new Random();
		int arrSize = random.nextInt(values().length);
        Animal animal = values()[arrSize];
        return animal;
	}
	
	public static void printAllAnimalData() {
		System.out.println("-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");
		for (Animal animal : Animal.values()) {
			System.out.printf(
				"(#%2d) %7s: %3d HP %3d ATK %3d DEF %3d SPD \n",
				animal.getId(), animal.getName(),
				animal.getBaseHP(), animal.getBaseAtk(),
				animal.getBaseDef(), animal.getBaseSpeed()
			);
		}
	}

}
