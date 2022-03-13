package isen.projet.main.Controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import projet.isen.java2.db.daos.PersonDao;
import projet.isen.java2.db.entity.Person;

public class PersonController implements Initializable{
	
	@FXML
	private Button ListPersons;
	@FXML
	private Button AddPerson;
	@FXML
	private Button DeletePerson;
	@FXML
	private Button Quit;
	@FXML
	private Button UpdatePerson;
	
	
	
	
	public void QuitSoftWare() {
		System.exit(0);
	}
	
	@FXML
	private void ShowPersonsButton(ActionEvent event) throws IOException {		
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/ListPersonsScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.setTitle("List Of Persons");
		app_stage.show();
	}
	
	@FXML
	private void AddPeronButton(ActionEvent event) throws IOException {
		System.out.println("handle button");
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/AddPersonScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.setTitle("Add Person");
		app_stage.show();
	}
	
	@FXML
	private void DeletePersonButton(ActionEvent event) throws IOException {
		System.out.println("handle button");
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/DeletePersonScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.setTitle("Delete Person");
		app_stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
