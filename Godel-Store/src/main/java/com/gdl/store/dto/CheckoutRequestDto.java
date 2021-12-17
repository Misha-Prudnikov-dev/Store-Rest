package com.gdl.store.dto;

import com.gdl.store.entity.Address;

public class CheckoutRequestDto {

	private Address address;
	private String typePayment;

	public CheckoutRequestDto() {

	}

	public CheckoutRequestDto( Address address, String typePayment) {
		this.address = address;
		this.typePayment = typePayment;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}



}
