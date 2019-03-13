package zork2;

import javafx.scene.control.Button;

public class MyButton extends Button{
	public MyButton (String text) {
		super(text);
		setStyle("-fx-font-size: 12pt;");
		setPrefWidth(200);
	}
	
	
}
