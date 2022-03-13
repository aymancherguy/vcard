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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projet.isen.java2.db.daos.PersonDao;
import projet.isen.java2.db.entity.Person;

public class ShowPersonsController implements Initializable{

	@FXML
	private Button Back450;
	@FXML
	private Button Quit450;
	
	@FXML
	private TableView<Person> my_table = new TableView<Person>();
	@FXML
	private TableColumn<Person, Integer> id_person = new TableColumn<Person, Integer>("id");
	@FXML
	private TableColumn<Person, String> lastname = new TableColumn<Person, String>("last_name");
	@FXML
	private TableColumn<Person, String> firstname = new TableColumn<Person, String>("first_name");
	@FXML
	private TableColumn<Person, String> nickname = new TableColumn<Person, String>("nickname");
	@FXML
	private TableColumn<Person, String> phonenumber = new TableColumn<Person, String>("phone_number");
	@FXML
	private TableColumn<Person, String> address = new TableColumn<Person, String>("address");
	@FXML
	private TableColumn<Person, String> emailaddress = new TableColumn<Person, String>("email_address");
	@FXML
	private TableColumn<Person, LocalDate> birthday = new TableColumn<Person, LocalDate>("birthday");
	
	ObservableList<Person> item = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		my_table.setEditable(true);
		PersonDao per = new PersonDao();
		List<Person> allPersons = per.listPersons();
	
		for(Person my_person : allPersons) {
			item.add(my_person);
		}
		
		id_person.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
		lastname.setCellValueFactory(new PropertyValueFactory<Person, String>("last_name"));
		firstname.setCellValueFactory(new PropertyValueFactory<Person, String>("first_name"));
		nickname.setCellValueFactory(new PropertyValueFactory<Person, String>("nickname"));
		phonenumber.setCellValueFactory(new PropertyValueFactory<Person, String>("phone_number"));
		address.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
		emailaddress.setCellValueFactory(new PropertyValueFactory<Person, String>("email_address"));
		birthday.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birth_date"));
		my_table.setItems(item);
		
	}
	
	@FXML
	private void quitPersonsList() {
		System.exit(0);
	}
	
	@FXML
	private void GoBackMainScreen(ActionEvent event) throws IOException {
		Parent homeScreen_par = FXMLLoader.load(getClass().getResource("../view/HomeScreen.fxml"));
		Scene homeScreen = new Scene(homeScreen_par);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(homeScreen);
		app_stage.show();
	}
}
