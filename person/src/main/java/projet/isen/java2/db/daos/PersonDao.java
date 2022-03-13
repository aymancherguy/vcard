package projet.isen.java2.db.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import projet.isen.java2.db.daos.DataSourceFactory;
import projet.isen.java2.db.entity.Person;

import projet.isen.java2.db.interfaces.PersonDaoInter;

public class PersonDao implements PersonDaoInter{
	
	@Override
	public List<Person> listPersons(){
		List<Person> listOfPersons = new ArrayList<>();
		try(Connection connection = (Connection) DataSourceFactory.getDataSource().getConnection()){
			try(Statement statement = (Statement) connection.createStatement()){
				try(ResultSet results = statement.executeQuery("select * from person")){
					while(results.next()) {
						Person person = new Person(
								results.getInt("idperson"),
								results.getString("lastname"),
								results.getString("firstname"),
								results.getString("nickname"),
								results.getString("phone_number"),
								results.getString("address"),
								results.getString("email_address"),
								results.getDate("birth_date").toLocalDate()
								);
						listOfPersons.add(person);					
					}
				}
			}	
		}catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Failed Connecting to the server");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());

			alert.showAndWait();
			//System.out.println(e.getMessage());
		}
		return listOfPersons;
	}
	
	@Override
	public Person addPerson(Person person) {
		try(Connection connection = (Connection) DataSourceFactory.getDataSource().getConnection()){
			String sqlQuerry = "insert into person( lastname, firstname, nickname, phone_number, address, email_address, birth_date)"+"VALUES(?, ?, ?, ?, ?, ?, ?)";
			try(PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sqlQuerry, Statement.RETURN_GENERATED_KEYS)){
				//statement.setInt(1, person.getId());
				statement.setString(1, person.getLast_name());
				statement.setString(2, person.getFirst_name());
				statement.setString(3, person.getNickname());
				statement.setString(4, person.getPhone_number());
				statement.setString(5, person.getAddress());
				statement.setString(6, person.getEmail_address());
				statement.setDate(7, Date.valueOf(person.getBirth_date()));
				statement.executeUpdate();
				ResultSet ids = statement.getGeneratedKeys();
				if(ids.next()) {
					return new Person(ids.getInt(1), person.getLast_name(), person.getFirst_name(), person.getNickname(), person.getPhone_number(), person.getAddress(), person.getEmail_address(), person.getBirth_date());
				}
			}
		}catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Failed Adding Person");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());

			alert.showAndWait();
		}
		return null;
	}
	
	@Override
	public void deletePerson(Integer personId) {
		try(Connection connection = (Connection) DataSourceFactory.getDataSource().getConnection()){
			try(PreparedStatement statement = (PreparedStatement) connection.prepareStatement("delete from person where idperson=?")){
				statement.setInt(1, personId);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Failed Deleting Person");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());

			alert.showAndWait();
		}
	}
}
