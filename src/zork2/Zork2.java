package zork2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/*
 * 
 */
class Passage extends GridPane {
	String body;
	String name;
	private ArrayList<String> options = new ArrayList<>();
	private int i = 1;

	/*
	 * 
	 */
	public Passage(String name) throws Exception {
		Path filepath = Paths.get(getClass().getResource(String.format("/story/%s.txt", name)).toURI());
		List<String> lines = Files.readAllLines(filepath);
		StringBuilder sb = new StringBuilder();
		
		while (!lines.get(i).equals("Buttons:")) {
			sb.append(lines.get(i));
			sb.append(System.getProperty("line.separator"));
			body = sb.toString();
			i++;
		}

		i++;

		while (!lines.get(i).equals("End")) {
			options.add(lines.get(i));
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
}

class ButtonTypes extends Button{
	public ButtonTypes() {
		
	}
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
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane gridTest = new GridPane();
		gridTest.setAlignment(Pos.CENTER);
		gridTest.setVgap(10);
		gridTest.setHgap(40);
		
		
		Passage passage = new Passage("test");
		List<String> buttons = passage.getList();
		String body = passage.getBody();

		/*
		 * here is where buttons are added to the scene
		 */
		for (int i = 0; i < buttons.size(); i++) {
			MyButton button = new MyButton(buttons.get(i));

			if (i <= 3) {
				gridTest.add(button, i, 0);
			} else {
				gridTest.add(button, i - 4, 1);
			}
		}

		BorderPane pane = new BorderPane();

		/*
		 * here is where the output is put into a scene and made so it is scrollable.
		 */
		Text bodyText = new Text(body);
		TextFlow textFlow = new TextFlow(bodyText);
		ScrollPane scrollPane = new ScrollPane(textFlow);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);

		pane.setBottom(gridTest);
		pane.setCenter(scrollPane);
		pane.setRight(null);

		primaryStage.setScene(new Scene(pane, 920, 600));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	/*
	 * 
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
