package zork2;

public class Inventory {
	
	public static int potion = 0;
	public static int sword = 0;
	public static int dagger = 0;
	public static int legArmor = 0;
	public static int torsoArmor = 0;
	public static int helmet = 0;
	
	public Inventory() {
	}
	
	public static void changePotion(int numChange) {
		potion += numChange;
	}
	
	public static void changeSword(int numChange) {
		sword += numChange;
	}
	
	public static void changeDagger(int numChange) {
		dagger += numChange;
	}
	
	public static void changeLegArmor(int numChange) {
		legArmor += numChange;
	}
	
	public static void changeTorsoArmor(int numChange) {
		torsoArmor += numChange;
	}
	
	public static void changeHelmet(int numChange) {
		helmet += numChange;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
