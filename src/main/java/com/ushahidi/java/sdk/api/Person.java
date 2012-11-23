package com.ushahidi.java.sdk.api;

public class Person {

	private String firstName;
	private String lastName;
	private String email;

	public Person(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String toString() {
		return "Person [firstName:" + firstName + ", lastName:" + lastName
				+ ", email:" + email + "]";
	}
}
