package passwordGenerator;

import java.net.URL;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import java.lang.Object;

public class Controller {
	
	private static String[] lowerCaseCharacters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",};
	private static String[] upperCaseCharacters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static String[] theNumbers = {"1","2","3","4","5","6","7","8","9","0", "1","2","3","4","5","6","7","8","9","0"};
	private static String[] symbols = {"!","@","#","$","%","^","&","*","!","@","#","$","%","^","&","*"};
	
	
	
	private double test;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label generatedPassword;

    @FXML
    private Button copyButton;

    @FXML
    private CheckBox uppercaseCheck;

    @FXML
    private CheckBox lowercaseCheck;

    @FXML
    private  CheckBox numericCheck;

    @FXML
    private  CheckBox symbolCheck;

    @FXML
   private Slider lengthSlider;
    

    @FXML
    private Label passwordLength;

    @FXML
    private Button generatePasswordButton;
    
    


    @FXML
    void copyPassword(ActionEvent event) {
    	
    	String myString = generatedPassword.getText();
    	StringSelection stringSelection = new StringSelection(myString);
    	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    	clipboard.setContents(stringSelection, null);
   
    }
     
    String[] append(String[] destination, String[] arrayCopy) {
    	String[] tempArray = new String[destination.length + arrayCopy.length];
    	int i = 0, j = 0;
    	while(i< destination.length) {
    		tempArray[i] = destination[i];
    		i++;
    	}
    	while(i < tempArray.length) {
    		tempArray[i] = arrayCopy[j];
    		j++;
    		i++;
    	}
 
    	destination = tempArray;
    	return destination;
    } 
    

    @FXML
    void generatePassword(ActionEvent event) {
    	
    	String[] finalArray = {""};
    	String max = passwordLength.getText();
    	String randomChar;
    	String password = "";
    	int i = 0;
    	int randomNum;
    	int maxNum = Integer.parseInt(max);
    	
    	if(uppercaseCheck.isSelected()) {
    		
    		finalArray = append(finalArray, upperCaseCharacters);
    	}
    	if(lowercaseCheck.isSelected()) {
    		
    		finalArray =  append(finalArray, lowerCaseCharacters);
    	}
    	if(numericCheck.isSelected()) {
    		
    		finalArray =  append(finalArray, theNumbers);   	     
    	}
    	
    	if(symbolCheck.isSelected()) {
    	
    		finalArray =  append(finalArray, symbols);
    	}
    	
    	while(i < maxNum) {
    	
    		randomNum = (int) (Math.random()* finalArray.length);
        	randomChar = finalArray[randomNum];
        	password += randomChar;
        	i++;
        	
    	}
    	
    	if (password.length() == maxNum) {
    		generatedPassword.setText(password); 
    	}
    	else {
    		randomNum = (int) (Math.random()* finalArray.length);
        	randomChar = finalArray[randomNum];
    		password += randomChar;
    		generatedPassword.setText(password); 
    	}
    	
    	
    	
    	/* 
    	 
    	  for(i=0; i<finalArray.length; i++) {
    		System.out.println(finalArray[i]);
    		}
    	
    	*/
    	
    	
    }
    
    
    
  
   
    
    
    
    
    
    
    

    @FXML
    void updateNumber(MouseEvent event) {
 
  
    

    }

    @FXML
    void initialize() {
    	
    	passwordLength.textProperty().bind(Bindings.format( "%.0f", lengthSlider.valueProperty()));
    	
        assert generatedPassword != null : "fx:id=\"generatedPassword\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";
        assert copyButton != null : "fx:id=\"copyButton\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";
        assert uppercaseCheck != null : "fx:id=\"uppercaseCheck\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";
        assert lowercaseCheck != null : "fx:id=\"lowercaseCheck\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";
        assert numericCheck != null : "fx:id=\"numericCheck\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";
        assert symbolCheck != null : "fx:id=\"symbolCheck\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";
        assert lengthSlider != null : "fx:id=\"lengthSlider\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";
        assert passwordLength != null : "fx:id=\"passwordLength\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";
        assert generatePasswordButton != null : "fx:id=\"generatePasswordButton\" was not injected: check your FXML file 'PasswordGenerator.fxml'.";

        
        
        
        
    }
    
   
}
