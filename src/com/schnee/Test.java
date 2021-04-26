package com.schnee;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	Student newStudent = new Student();
	
	
	@org.junit.jupiter.api.Test
	void testsetFirstName() {
		newStudent.setFirstName("John");
		assertEquals(newStudent.getFirstName(), "John");
	}
	
	@org.junit.jupiter.api.Test
	void testsetNotFirstName() {
		newStudent.setFirstName("John");
		assertNotEquals(newStudent.getFirstName(), "Bob");
	}
	
	@org.junit.jupiter.api.Test
	void testsetNullFirstName() {
		newStudent.setFirstName(null);
		assertEquals(newStudent.getFirstName(), null);
	}
	
	@org.junit.jupiter.api.Test
	void testsetLastName()
	{
		newStudent.setLastName("Mulaney");
		assertEquals(newStudent.getLastName(), "Mulaney");
	}
	
	@org.junit.jupiter.api.Test
	void testsetNotLastName() {
		newStudent.setLastName("Mulaney");
		assertNotEquals(newStudent.getLastName(), "Smith");
	}
	
	@org.junit.jupiter.api.Test
	void testsetNullLastName() {
		newStudent.setLastName(null);
		assertEquals(newStudent.getLastName(), null);
	}

	@org.junit.jupiter.api.Test
	void testsetCountry() {
		newStudent.setLastName("United States");
		assertEquals(newStudent.getCountry(), "United States");
	}

	@org.junit.jupiter.api.Test
	void testsetLanguage() {
		newStudent.setLanguage("Spanish");
		assertEquals(newStudent.getLanguage(), "Spanish");
	}
	
	@org.junit.jupiter.api.Test
	void testsetLanguageChange() {
		newStudent.setLanguage("Spanish");
		newStudent.setLanguage("English");
		assertEquals(newStudent.getLanguage(), "English");
	}
	
	@org.junit.jupiter.api.Test
	void testsetCourseCode() {
		newStudent.setCourseCode("UNO123");
		assertEquals(newStudent.getCourseCode(), "UNO123");
	}
	
	@org.junit.jupiter.api.Test
	void testgetId() {
		newStudent.setId("123456789");
		assertEquals(newStudent.getId(), "123456789");
	}
	
	@org.junit.jupiter.api.Test
	void testsetPhoneNumber() {
		newStudent.setPhoneNumber("4021112222");
		assertEquals(newStudent.getPhoneNumber(), "4021112222");
	}
	
	@org.junit.jupiter.api.Test
	void testfavLanguages() {
		String[] strArray = new String[] {"java", "c", "python"};
		newStudent.setFavoriteLanguages(strArray);
		assertEquals(newStudent.getFavoriteLanguages(), strArray);
	}
	

}
