package zork2;

import java.util.ArrayList;
import java.util.List;

public class Event {
		
		public static int[][] gameBoard;
		public static ArrayList<ArrayList<Integer>> coOrds;
		public static int x;
		public static int y;
		public static Inventory inventory;
		
	public Event() {
		gameBoard = new int[][] {{2, 2, 0, 0, 0}, {2, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
		coOrds = new ArrayList<ArrayList<Integer>>();
		inventory = new Inventory();
		for (int i = 0; i < 5; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < 5; j++) {
				temp.add(gameBoard[i][j]);
			}
			coOrds.add(temp);
		}
		x = 0;
		y = 0;
		coOrds.get(y).set(x, 1);
	}
	
	
	public static void checkSpace() throws Exception {
		if(coOrds.get(y).get(x) == 2) {
			inventory.changePotion(1);
		}
	}
	
	
	public static void moveNorth() {
		if (y == 4) {
			
		}
		coOrds.get(y).set(x, 0);
		y += 1;
	}
	
	public static void moveSouth() {
		if (y == 0) {
			
		}
		coOrds.get(y).set(x, 0);
		y -= 1;
	}
	
	public static void moveEast() {
		if (x == 4) {
			
		}
		coOrds.get(y).set(x, 0);
		x += 1;
	}
	
	public static void moveWest() {
		if (x == 0) {
			
		}
		coOrds.get(y).set(x, 0);
		x -= 1;
	}
	
	
	public static String currentPosition() {
		return String.format("x = %d, y = %d", x, y);
	}
}
