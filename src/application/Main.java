package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
// import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// root of our application
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// generating navbar hbox with buttons for different parts of the app
			HBox navBar = createNavBarHBox();
			root.setTop(navBar);
			
			// generating sidebar
			VBox stockSideBar = createStockListVBox();
			root.setLeft(stockSideBar);
			// setting up title and showing stage
			primaryStage.setTitle("Portfolio Manager");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates horizontal HBox for a navbar for the app.
	 */
	public HBox createNavBarHBox() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    Button buttonCurrent = new Button("Portfolio Information");
	    buttonCurrent.setPrefSize(150, 20);
	    
	    Button buttonProjected = new Button("Calculations");
	    buttonProjected.setPrefSize(150, 20);
	    hbox.getChildren().addAll(buttonCurrent, buttonProjected);
		return hbox;
	}
	/**
	 * Creates vertical VBox sidebar for the list of stocks in our portfolio.
	 */
	public VBox createStockListVBox() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(10));
	    vbox.setSpacing(8);
	    
	    Text title = new Text("Your Stocks");
	    title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
	    vbox.getChildren().add(title);
	    
	    /*
	     * User's stocks.
	     */
	    Hyperlink[] stocks = new Hyperlink[] {
	    		new Hyperlink("TSLA"),
	    		new Hyperlink("MSFT")
	    };
	    for (int i=0; i<2; i++) {
	        VBox.setMargin(stocks[i], new Insets(0, 0, 0, 8));
	        vbox.getChildren().add(stocks[i]);
	    }

		return vbox;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
