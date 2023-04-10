package Helpers;

import java.util.Locale;

import com.github.javafaker.Faker;

import lombok.Data;

public class AddressDetails {
	String streetAddress;
	String city;
	String state;
	String postalCode;
	String phoneNumber;
	String country;

	public AddressDetails FillAddress() {
		Faker fake = new Faker(Locale.UK);
		this.streetAddress = fake.address().streetAddress();
		this.city = fake.address().city();
		this.state = fake.address().state();
		this.postalCode = fake.address().zipCode();
		this.country = fake.address().country();
		this.phoneNumber = fake.phoneNumber().phoneNumber();
		return this;

	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
