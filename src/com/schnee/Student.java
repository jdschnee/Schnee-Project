package com.schnee;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String language;
	private double gpa;
	private String id;
	private String phoneNumber;
	private String courseCode;
	private String[] favoriteLanguages;
	
	List<String> countryOptions;
	List<String> languageOptions;
	
	public Student() {
		//Pre-populate
		firstName = "Josh";
		lastName = "Schnee";
		country = "United States";
		language = "Java";
		gpa = 3.0;
		id = "000000";
		phoneNumber = "xxx-xxx-xxxx";
		courseCode = "UNOXXXXXX";
		
		countryOptions = new ArrayList<>();
		
		countryOptions.add("Brazil");
		countryOptions.add("France");
		countryOptions.add("Germany");
		countryOptions.add("India");
		countryOptions.add("Turkey");
		countryOptions.add("United Kingdom");
		countryOptions.add("United States");
		
		
		languageOptions = new ArrayList<>();
		
		languageOptions.add("Java");
		languageOptions.add("C#");
		languageOptions.add("PHP");
		languageOptions.add("Ruby");
	}
	
	
	public void validateCourseCode(FacesContext context,
		UIComponent component,Object value) throws ValidatorException {
		
		if(value==null) {
			return;
		}
		
		String data = value.toString();
		
		if(!data.startsWith("UNO")) {
			FacesMessage message = new FacesMessage("Course Code must start with UNO");
			throw new ValidatorException(message);
		}
		
	}
	
	
	public List<String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(List<String> countryOptions) {
		this.countryOptions = countryOptions;
	}
	
	public List<String> getLanguageOptions() {
		return languageOptions;
	}
	
	public void setLanguageOptions(List<String> languageOptions) {
		this.languageOptions = languageOptions;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	} 
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String[] getFavoriteLanguages() {
		return favoriteLanguages;
	}

	public void setFavoriteLanguages(String[] favoriteLanguages) {
		this.favoriteLanguages = favoriteLanguages;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
