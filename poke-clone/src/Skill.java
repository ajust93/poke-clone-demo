
public enum Skill {
	TACKLE(1, "Tackle", "Normal", 20, 0.95),
	HEADBUTT(2, "Headbutt", "Normal", 30, 0.85),
	SLASH(3, "Slash", "Normal", 25, 0.90),
	BODYSLAM(4, "Bodyslam", "Normal", 35, 0.80);
	
	private final int id;
	private final String name;
	private final String element;
	private final int damage;
	private final double accuracy;
	
	Skill(int id, String name, String element, int damage, double accuracy) {
		this.id = id;
		this.name = name;
		this.element = element;
		this.damage = damage;
		this.accuracy = accuracy;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getElement() {
		return element;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public double getAccuracy() {
		return accuracy;
	}
	
	public static void printAllSkills() {
		for (Skill skill : Skill.values()) {
			System.out.printf(
				"%d %10s: %8s %3d DMG  %4.2f ACC \n",
				skill.getID(), skill.getName(), skill.getElement(),
				skill.getDamage(), skill.getAccuracy()
			);
		}
	}

}
