package passwordGenerator;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PasswordGenerator extends Application{
	
	
	
	
	
	 @Override
	    public void start(Stage primaryStage) throws Exception{
	        Parent root = FXMLLoader.load(getClass().getResource("PasswordGenerator.fxml"));
	        
	        primaryStage.setTitle("Password Generator");
	       
	        Scene scene = new Scene(root, 1200, 800);
	        scene.getStylesheets().add("styles.css");
	        
	        primaryStage.setScene(scene);
	        
	        
	        primaryStage.show();
	    }
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		
		launch(args);
	

	}

}




