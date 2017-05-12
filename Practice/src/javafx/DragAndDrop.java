package javafx;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DragAndDrop extends Application {
	//
	private TableView table = new TableView();
	private TableView table2 = new TableView();
	
	@Override
	public void start(Stage stage) throws Exception {
		//
		Scene scene = new Scene(new Group());
		stage.setTitle("Table View Sample");
		stage.setWidth(600);
		stage.setHeight(600);

		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		TableColumn firstNameCol = new TableColumn("First Name");
		TableColumn lastNameCol = new TableColumn("Last Name");
		TableColumn emailCol = new TableColumn("Email");

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
		table2.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
		
		GridPane gridPane = new GridPane();
		
		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);
		
		final VBox vbox2 = new VBox();
		vbox2.setSpacing(10);
		vbox2.setPadding(new Insets(100, 100, 110, 100));
		vbox2.getChildren().addAll(label, table2);

		((Group) scene.getRoot()).getChildren().addAll(vbox, vbox2);

		vbox.setOnDragDropped(new EventHandler<DragEvent>() {
			//
			@Override
			public void handle(DragEvent event) {
				//
				System.out.println("box drag");
			}
		});
		
		vbox2.setOnDragDropped(new EventHandler<DragEvent>() {
			//
			@Override
			public void handle(DragEvent event) {
				//
				System.out.println("box2 drag");
			}
		});
		
		//gridPane.add(vbox, 0, 0);
		//gridPane.add(vbox2, 0, 1);
		
		gridPane.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				// 
				System.out.println("grid drag");
				
			}
		});
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
