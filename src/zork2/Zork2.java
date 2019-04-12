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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

	/*
	 * 
	 */
	public Passage(String name) throws Exception {
		Path filepath = Paths.get(getClass().getResource(String.format("/story/%s.txt", name)).toURI());
		List<String> lines = Files.readAllLines(filepath);
		StringBuilder sb = new StringBuilder();

		// Goes through the text file and then gets each part and assigns/formats it
		// where necessary.
		while (!lines.get(i).equals("Fin;")) {

			if (lines.get(i).equals("Output;")) {

				i++;

				while (!lines.get(i).equals("End;")) {
					sb.append(lines.get(i));
					sb.append(System.getProperty("line.separator"));
					body = sb.toString();
					i++;
				}
			}

			if (lines.get(i).equals("Buttons;")) {

				i++;

				while (!lines.get(i).equals("End;")) {
					options.add(lines.get(i));
					i++;
				}
			}

			if (lines.get(i).equals("Inventory;")) {

				i++;

				while (!lines.get(i).equals("End;")) {
					inventory.add(lines.get(i));
					i++;
				}
			}
			// If we add more parts to the text file you would add the if while methods here
			i++;
		}
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
		if (name.equals("back")) {
			name = array.get(itteration - 1);
			if(name.equals("back")) {
				name = array.get(itteration - 1);
			}
		}
		try {
			if (name.equals("explore")) {
				double ran = Math.random();
				if (ran > .5) {
					name = "enemy";
				}
			}
			array.add(name);
			Passage passage = new Passage(name);
			pane.getChildren().clear();
			GridPane gridTest = new GridPane();
			gridTest.setAlignment(Pos.CENTER);
			gridTest.setVgap(10);
			gridTest.setHgap(40);
			List<Button> list = new ArrayList<Button>();
			List<String> buttons = passage.getList();
			String body = passage.getBody();

			for (int i = 0; i < buttons.size(); i++) {
				MyButton button = new MyButton(buttons.get(i));
				list.add(button);

				if (i <= 3) {
					gridTest.add(button, i, 0);
				} else {
					gridTest.add(button, i - 4, 1);
				}
			}

			Button[] buttonArray = new Button[list.size()];
			for (int i = 0; i < list.size(); i++) {
				buttonArray[i] = list.get(i);
			}

			pane = new BorderPane();

			pane.getChildren().clear();
			Text bodyText = new Text(body);
			TextFlow textFlow = new TextFlow(bodyText);
			ScrollPane scrollPane = new ScrollPane(textFlow);
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);

			pane.setBottom(gridTest);
			pane.setCenter(scrollPane);
			pane.setRight(null);
			scene.setRoot(pane);
			
			itteration++;

			for (int i = 0; i < buttonArray.length; i++) {
				int _i = i;
				buttonArray[i].setOnAction(e -> {
					changeScene(buttonArray[_i].getText());
				});
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Passage passage = new Passage("test");

		GridPane gridTest = new GridPane();
		gridTest.setAlignment(Pos.CENTER);
		gridTest.setVgap(10);
		gridTest.setHgap(40);
		List<Button> list = new ArrayList<Button>();
		List<String> buttons = passage.getList();
		String body = passage.getBody();

		// Through options I now have a list of button names. Using these button names I
		// will get the button from its own ??? (decide later) From there buttons will
		// call eachother changing what is displayed and outputted

		/*
		 * here is where buttons are added to the scene
		 */
		for (int i = 0; i < buttons.size(); i++) {
			MyButton button = new MyButton(buttons.get(i));
			list.add(button);

			if (i <= 3) {
				gridTest.add(button, i, 0);
			} else {
				gridTest.add(button, i - 4, 1);
			}
		}

		Button[] buttonArray = new Button[list.size()];
		for (int i = 0; i < list.size(); i++) {
			buttonArray[i] = list.get(i);
		}

		pane = new BorderPane();
		Text introText = new Text("Welcome to the game");
		MyButton button2 = new MyButton("Begin");
		introText.setStyle("-fx-font-size: 22pt;");
		pane.setTop(introText);
		pane.setCenter(button2);
		BorderPane.setAlignment(introText, Pos.CENTER);

		button2.setOnAction(e -> {
			pane.getChildren().clear();
			Text bodyText = new Text(body);
			TextFlow textFlow = new TextFlow(bodyText);
			ScrollPane scrollPane = new ScrollPane(textFlow);
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);

			pane.setBottom(gridTest);
			pane.setCenter(scrollPane);
			pane.setRight(null);

		});

		for (int i = 0; i < buttonArray.length; i++) {
			int _i = i;
			buttonArray[i].setOnAction(e -> {
				changeScene(buttonArray[_i].getText());
			});
		}

		/*
		 * here is where the output is put into a scene and made so it is scrollable.
		 */

		scene = new Scene(pane, 920, 600);

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
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