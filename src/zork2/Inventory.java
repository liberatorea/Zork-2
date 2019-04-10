package zork2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.io.BufferedReader;


public class Inventory {
	
	public static int potion = 0;
	public static int sword = 0;
	public static int dagger = 0;
	public static int legArmor = 0;
	public static int torsoArmor = 0;
	public static int helmet = 0;
	
	public Inventory() {
	}
	
	public void changeInv(String object) throws Exception{
		Path inv = Paths.get("C:/Users/liberatorea/Desktop/Zork-2/src/story/Inventory.txt");
		List<String> lines = Files.readAllLines(inv);
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		while(!lines.get(i).equals("Fin;")) {
			if (lines.get(i).equals(object)) {
				lines.get(i).replaceAll(String.format("%s.*", object), String.format("%s: %d", object, Integer.valueOf(object)));
			}
			i++;
		}
	}
	
	public boolean badChange(int object, int numChange) {
		if(object + numChange < 0) {
			return true;
		}
		return false;
	}
	
	public void changePotion(int numChange) throws Exception {
		if (badChange(potion, numChange)) {
			potion = 0;
			this.changeInv("Potions");
			return;
		}
		potion += numChange;
		this.changeInv("Potions");
	}
	
	public void changeSword(int numChange) throws Exception {
		if (badChange(sword, numChange)) {
			sword = 0;
			this.changeInv("Swords");
			return;
		}
		sword += numChange;
		this.changeInv("Swords");
	}
	
	public void changeDagger(int numChange) throws Exception {
		if (badChange(dagger, numChange)) {
			dagger = 0;
			this.changeInv("Daggers");
			return;
		}
		dagger += numChange;
		this.changeInv("Daggers");
	}
	
	public void changeLegArmor(int numChange) throws Exception {
		if (badChange(legArmor, numChange)) {
			legArmor = 0;
			this.changeInv("Leg Armor");
			return;
		}
		legArmor += numChange;
		this.changeInv("Leg Armor");
	}
	
	public void changeTorsoArmor(int numChange) throws Exception {
		if (badChange(torsoArmor, numChange)) {
			torsoArmor = 0;
			this.changeInv("Torso Armor");
			return;
		}
		torsoArmor += numChange;
		this.changeInv("Torso Armor");
	}
	
	public void changeHelmet(int numChange) throws Exception {
		if (badChange(helmet, numChange)) {
			helmet = 0;
			this.changeInv("Helmet");
			return;
		}
		helmet += numChange;
		this.changeInv("Helmet");
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
