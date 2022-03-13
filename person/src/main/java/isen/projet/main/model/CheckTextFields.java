package isen.projet.main.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import projet.isen.java2.db.entity.Person;

public class CheckTextFields{

	
	public boolean checkSpecialCharacters(String checkString) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		
		String str = checkString;
		
		Matcher matcher = pattern.matcher(str);
		
		if(!matcher.matches()) return true;
		
		// to change after code
		return false;
	}
	
	public boolean checkAddress(String checkString) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9 ]*");
		
		String str = checkString;
		
		Matcher matcher = pattern.matcher(str);
		
		if(!matcher.matches()) return true;
		
		// to change after code
		return false;
	}
	
	public boolean checkemailaddress(String email) {
		  String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                  "[a-zA-Z0-9_+&*-]+)*@" + 
                  "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                  "A-Z]{2,7}$"; 
                    
		  Pattern pat = Pattern.compile(emailRegex); 
		  if (email == null) 
			  return false; 
		  return pat.matcher(email).matches(); 
	}
	
	public boolean Check_birth_day(String dateToValidate){
		String dateFromat = "dd/MM/yyyy";
		if(dateToValidate == null){
			return false;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
		
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Person CheckValidation(String lastname, String firstname, String nickname, String phonenumber, String address,
			String emailaddress, String birthday) {
		
		int checkvariables[] = new int[7];
		
		if(!checkSpecialCharacters(lastname) && lastname.length() > 0) {
			;
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Last Name Invalid");
			alert.setHeaderText(null);
			alert.setContentText("Please Check your Last Name");
			alert.showAndWait();
			checkvariables[0] = -1;
		}
		
		if(!checkSpecialCharacters(firstname) && firstname.length() > 0) {
			;
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("First Name Invalid");
			alert.setHeaderText(null);
			alert.setContentText("Please Check your First Name");
			alert.showAndWait();
			checkvariables[1] = -1;
		}
		
		if(!checkSpecialCharacters(nickname)) {
			;
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Invalid Nickname");
			alert.setHeaderText(null);
			alert.setContentText("Please Check your Nickname");
			alert.showAndWait();
			checkvariables[2] = -1;
		}
		
		if(!checkSpecialCharacters(phonenumber)) {
			;
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Phone Number Invalid");
			alert.setHeaderText(null);
			alert.setContentText("Please Check your Phone Number");
			alert.showAndWait();
			checkvariables[3] = -1;
		}
		
		if(!checkAddress(address) && address.length() > 0) {
			;
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Address Invalid");
			alert.setHeaderText(null);
			alert.setContentText("Please Check your Address");
			alert.showAndWait();
			checkvariables[4] = -1;
		}
		
		if(checkemailaddress(emailaddress) || emailaddress.length() == 0) {
			;
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Email Address Invalid");
			alert.setHeaderText(null);
			alert.setContentText("Please Check your Email Address");
			alert.showAndWait();
			checkvariables[5] = -1;
		}
		
		if(Check_birth_day(birthday)) {
			;
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Birthday Invalid");
			alert.setHeaderText(null);
			alert.setContentText("Please Check your Birthday");
			alert.showAndWait();
			checkvariables[6] = -1;
		}
		
		int count = 0;
		
		
		System.out.println(Arrays.toString(checkvariables));
		
		for(int i = 0 ; i < checkvariables.length ; i++) {
			if(checkvariables[i] != 0) {
				count = count +1;
			}
		}
		
		
		
		if(count == 0) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String date = birthday;
			LocalDate localDate = LocalDate.parse(date, formatter);
			Person per = new Person(1, lastname, firstname, nickname, phonenumber, address, emailaddress, localDate);
			return per;
		}
		
		return null;
	}

}
