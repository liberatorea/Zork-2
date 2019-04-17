package zork2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

//To do, use gridpane add and remove. will remove all buttons from the bottom part of the gridpane and then add the new button, rinse and repeat.
/*
 * 
 */
class Passage extends GridPane {
	String body;

	private ArrayList<String> options = new ArrayList<>();
	private ArrayList<String> inventory = new ArrayList<>();
	private int i = 0;

	public Passage(String name) throws Exception {
		Path filepath = Paths.get(getClass().getResource(String.format("/story/%s.txt", name)).toURI());
		List<String> lines = Files.readAllLines(filepath);
		StringBuilder sb = new StringBuilder();
		
	}
	

	/*
	 * Getters for the list of buttons and output.
	 */
	public List<String> getList() {
		return options;
	}

	public String getBody() {
		return body;
	}

	public List<String> getInv() {
		return inventory;
	}

//Here is where we will change things about the program.

}

/*
 * 
 */
public class Zork2 extends Application {
	/*
	 * This is where the program is put together. It is put on a gridpane with the
	 * output being outputed to the top, buttons to the bottom, and various stats to
	 * the right.
	 * 
	 */
	Scene scene;
	BorderPane pane;
	List<String> array = new ArrayList<>(Arrays.asList("test"));
	int itteration = 0;

	/*
	 * this is what causes new scenes to be made. It takes the name of a clicked
	 * button and then fetches the file with the corresponding name before repeating
	 * the process.
	 */
	public void changeScene(String name) {
		

		
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane box = new BorderPane();
		MyButton begin = new MyButton("Begin");
		begin.setOnAction(e ->{
			System.out.print("This is the game");
		});
		Text introText = new Text("Work in progress");
		introText.setStyle("-fx-font-size: 22pt;");
		box.setTop(introText);
		box.setCenter(begin);
		BorderPane.setAlignment(introText, Pos.CENTER);
		
	
		scene = new Scene(box, 920, 600);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Zork 2");
		primaryStage.show();
	}

	/*
	 * 
	 */
	public static void main(String[] args) {
		launch(args);
	}
}//
//This is not working