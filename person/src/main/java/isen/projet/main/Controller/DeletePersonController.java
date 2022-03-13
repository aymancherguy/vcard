package isen.projet.main.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import isen.projet.main.model.CheckID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import projet.isen.java2.db.daos.PersonDao;
import projet.isen.java2.db.entity.Person;

public class DeletePersonController implements Initializable{
	
	@FXML
	Button Delete;
	@FXML
	Button Quit;
	@FXML
	Button Back;
	
	@FXML
	private TextField GetID;
	
	
	@FXML
	public void deleteperson() {
		String id = GetID.getText();
		CheckID check = new CheckID();
		if(check.chek_id(id)) {
			int id_checked = Integer.parseInt(id);
			PersonDao perDao = new PersonDao();
			perDao.deletePerson(id_checked);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Person Deleted");
			alert.setHeaderText(null);
			alert.setContentText("The Person Was Deleted Successfully");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void Quit() {
		System.exit(0);
	}
	
	@FXML
	public void BackMainScreen(ActionEvent event) throws IOException {
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/HomeScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.show();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
